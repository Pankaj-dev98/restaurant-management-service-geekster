package org.orgless.restaurantmanagementservice.persistence;

import org.orgless.restaurantmanagementservice.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemDAO extends JpaRepository<FoodItem, Integer> {

}
