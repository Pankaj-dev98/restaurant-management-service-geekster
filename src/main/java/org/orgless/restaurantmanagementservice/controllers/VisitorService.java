package org.orgless.restaurantmanagementservice.controllers;

import org.orgless.restaurantmanagementservice.entity.FoodItem;
import org.orgless.restaurantmanagementservice.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/visitor")
public class VisitorService {
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/item-list")
    public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllItems();
    }
}
