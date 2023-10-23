package org.orgless.restaurantmanagementservice.controllers;

import org.orgless.restaurantmanagementservice.entity.FoodItem;
import org.orgless.restaurantmanagementservice.entity.Order;
import org.orgless.restaurantmanagementservice.service.AdminService;
import org.orgless.restaurantmanagementservice.service.OrderService;
import org.orgless.restaurantmanagementservice.utils.OrderResponseDTO;
import org.orgless.restaurantmanagementservice.utils.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private AdminService adminService;
    private OrderService orderService;

    @Autowired
    public AdminController(AdminService adminService, OrderService orderService) {
        this.adminService = adminService;
        this.orderService = orderService;
    }

    @PostMapping("/food-items")
    public String addFoodItems(@RequestBody List<FoodItem> foodItems, @RequestParam String email) {
        return adminService.addFoodItems(foodItems, email);
    }

    @GetMapping("/orders")
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/orders/{orderId}")
    public OrderResponseDTO updateOrder(@PathVariable int orderId, @RequestParam OrderStatus status) {
        return orderService.updateOrder(orderId, status);
    }

    @GetMapping("/orders/{status}")
    public List<OrderResponseDTO> getOrdersByStatus(@PathVariable OrderStatus status) {
        return orderService.getOrdersByStatus(status);
    }
}
