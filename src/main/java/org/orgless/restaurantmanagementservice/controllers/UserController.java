package org.orgless.restaurantmanagementservice.controllers;

import org.orgless.restaurantmanagementservice.entity.User;
import org.orgless.restaurantmanagementservice.service.UserService;
import org.orgless.restaurantmanagementservice.utils.OrderDTO;
import org.orgless.restaurantmanagementservice.utils.SignInInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // sign up
    @PostMapping("/signup")
    public String userSignUp(User user) {
       return userService.userSignUp(user);
    }
    // sign in
    @PostMapping("/signin")
    public String userSignIn(@RequestBody SignInInputDTO signInInput) {
        return userService.userSignIn(signInInput);
    }
    // sign out
    @DeleteMapping("/signout")
    public String userSignOut(@RequestParam String email, @RequestParam String token) {
        return userService.userSignOut(email, token);
    }

    @PostMapping("/order")
    public String placeOrder(OrderDTO orderDTO) {
        return userService.placeOrder(orderDTO);
    }
}
