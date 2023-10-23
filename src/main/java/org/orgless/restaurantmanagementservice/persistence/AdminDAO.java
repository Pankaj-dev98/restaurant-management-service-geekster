package org.orgless.restaurantmanagementservice.persistence;

import org.orgless.restaurantmanagementservice.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDAO extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
}
