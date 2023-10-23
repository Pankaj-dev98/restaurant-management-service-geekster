package org.orgless.restaurantmanagementservice.utils;

import lombok.Data;

@Data
public class AuthorizationInputDTO {
    private String email;
    private String tokenValue;
}
