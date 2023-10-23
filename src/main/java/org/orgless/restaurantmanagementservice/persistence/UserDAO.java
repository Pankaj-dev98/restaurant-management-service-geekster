package org.orgless.restaurantmanagementservice.persistence;

import org.orgless.restaurantmanagementservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
