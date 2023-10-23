package org.orgless.restaurantmanagementservice.service;

import org.orgless.restaurantmanagementservice.entity.FoodItem;
import org.orgless.restaurantmanagementservice.persistence.FoodItemDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {
    private FoodItemDAO foodItemDAO;

    public FoodItemService(FoodItemDAO foodItemDAO) {
        this.foodItemDAO = foodItemDAO;
    }

    public List<FoodItem> addFoodItems(List<FoodItem> items) {
        for(FoodItem item: items) {
            item.setId(0);
        }

        return foodItemDAO.saveAll(items);
    }

    public List<FoodItem> getAllItems() {
        return foodItemDAO.findAll();
    }

    public Optional<FoodItem> getItemById(int id) {
        return foodItemDAO.findById(id);
    }
}
