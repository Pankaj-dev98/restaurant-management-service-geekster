package org.orgless.restaurantmanagementservice.persistence;

import org.orgless.restaurantmanagementservice.entity.Order;
import org.orgless.restaurantmanagementservice.utils.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {

    List<Order> findByStatus(OrderStatus status);
}
