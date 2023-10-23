package org.orgless.restaurantmanagementservice.persistence;

import org.orgless.restaurantmanagementservice.entity.User;
import org.orgless.restaurantmanagementservice.entity.UserAuthorizationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorizationTokenDAO extends JpaRepository<UserAuthorizationToken, Integer> {
    UserAuthorizationToken findByUser(User user);
    UserAuthorizationToken findByTokenValue(String tokenValue);

    void deleteByUser(User user);
}
