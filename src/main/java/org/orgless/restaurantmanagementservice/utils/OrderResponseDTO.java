package org.orgless.restaurantmanagementservice.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.orgless.restaurantmanagementservice.entity.Order;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderResponseDTO {
    private int id;
    private LocalDateTime creationTime;
    private String foodItem;
    private int quantity;
    private String userEmail;
    private OrderStatus orderStatus;

    public OrderResponseDTO(Order order) {
        id = order.getId();
        creationTime = order.getCreationTime();
        foodItem = order.getFoodItem().getTitle();
        quantity = order.getQuantity();
        userEmail = order.getUser().getEmail();
        orderStatus = order.getStatus();
    }
}
