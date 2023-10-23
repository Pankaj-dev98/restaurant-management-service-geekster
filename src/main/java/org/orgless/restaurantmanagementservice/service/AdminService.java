package org.orgless.restaurantmanagementservice.service;

import org.orgless.restaurantmanagementservice.entity.Admin;
import org.orgless.restaurantmanagementservice.entity.FoodItem;
import org.orgless.restaurantmanagementservice.persistence.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private AdminDAO adminDAO;
    private FoodItemService foodItemService;

    @Autowired
    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Autowired
    public void setFoodItemService(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    public String addFoodItems(List<FoodItem> foodItems, String email) {
        Admin admin = adminDAO.findByEmail(email);
        if(admin == null)
            return "Invalid credentials";

        foodItems = foodItemService.addFoodItems(foodItems);
        return foodItems.size() + " ITEMS ADDED\n" + foodItems.toString();
    }
}
