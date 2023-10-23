package org.orgless.restaurantmanagementservice.service;

import org.orgless.restaurantmanagementservice.entity.FoodItem;
import org.orgless.restaurantmanagementservice.entity.User;
import org.orgless.restaurantmanagementservice.persistence.UserDAO;
import org.orgless.restaurantmanagementservice.utils.OrderDTO;
import org.orgless.restaurantmanagementservice.utils.PasswordEncryptor;
import org.orgless.restaurantmanagementservice.utils.SignInInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    private UserDAO userDAO;
    private UserAuthorizationTokenService tokenService;
    private FoodItemService foodItemService;
    private OrderService orderService;


    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setTokenService(UserAuthorizationTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Autowired
    public void setFoodItemService(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String userSignUp(User user) {
        user.setEmail(user.getEmail().toLowerCase());

        if(userDAO.findByEmail(user.getEmail()) != null)
            return "User already exists.";
        user.setId(0);

        try {
            user.setPassword(PasswordEncryptor.encrypt(user.getPassword()));
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Internal server error";
        }
        return "NEW USER CREATED\n" + userDAO.save(user);
    }

    public String userSignIn(SignInInputDTO signInInput) {
        String email = signInInput.getEmail().toLowerCase();
        String password = signInInput.getPassword();

        User user = userDAO.findByEmail(email);
        if(user == null)
            return "Email is not registered";
        try {
            if(!PasswordEncryptor.encrypt(password).equals(user.getPassword()))
                return "Incorrect email/password";
            return "User signed in successfully\n" + email + "\n Token: " + tokenService.createToken(user);
        } catch(NoSuchAlgorithmException e) {
            return "Internal server error";
        }
    }

    public String userSignOut(String email, String token) {
        if(!tokenService.authenticate(email, token))
            return "Invalid credentials";

        tokenService.removeToken(userDAO.findByEmail(email));
        return email + " successfully signed out";
    }

    public String placeOrder(OrderDTO orderDTO) {
        if(!tokenService.authenticate(orderDTO.getEmail(), orderDTO.getToken()))
            return "Invalid credentials";

        if(orderDTO.getQuantity() < 1)
            return "invalid quantity";

        var item = foodItemService.getItemById(orderDTO.getFoodItemId()).orElseThrow();
        var user = userDAO.findByEmail(orderDTO.getEmail());

        return "NEW ORDER GENERATED\n" + orderService.placeNewOrder(user, item , orderDTO.getQuantity())
                + "\nDUE AMOUNT = " + (item.getPrice() * orderDTO.getQuantity()) + "Rs.";
    }
}
