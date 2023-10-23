package org.orgless.restaurantmanagementservice.service;

import org.orgless.restaurantmanagementservice.entity.FoodItem;
import org.orgless.restaurantmanagementservice.entity.Order;
import org.orgless.restaurantmanagementservice.entity.User;
import org.orgless.restaurantmanagementservice.persistence.OrderDAO;
import org.orgless.restaurantmanagementservice.utils.OrderResponseDTO;
import org.orgless.restaurantmanagementservice.utils.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order placeNewOrder(User user, FoodItem item, int quantity) {
        if(quantity == 0)
            return null;

        return orderDAO.save(new Order(0, LocalDateTime.now(), item, quantity, user, OrderStatus.CREATED));
    }

    private OrderResponseDTO convertToDTO(Order order) {
        return new OrderResponseDTO(order);
    }

    public List<OrderResponseDTO> getAllOrders() {
        List<OrderResponseDTO> result = new ArrayList<>();

        for(Order order: orderDAO.findAll())
            result.add(convertToDTO(order));

        return result;
    }

    public OrderResponseDTO updateOrder(int orderId, OrderStatus status) {
        Order order = orderDAO.findById(orderId).orElseThrow();
        order.setStatus(status);

        return(convertToDTO(orderDAO.save(order)));
    }

    public List<OrderResponseDTO> getOrdersByStatus(OrderStatus status) {
        List<Order> orders = orderDAO.findByStatus(status);
        List<OrderResponseDTO> result = new ArrayList<>();

        for(Order order: orders)
            result.add(convertToDTO(order));

        return result;
    }
}
