package org.orgless.restaurantmanagementservice.utils;

import lombok.Data;

@Data
public class OrderDTO {
    private String email;
    private String token;
    private int foodItemId;
    private int quantity;
}
