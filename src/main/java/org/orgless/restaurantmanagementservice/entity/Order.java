package org.orgless.restaurantmanagementservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.orgless.restaurantmanagementservice.utils.OrderStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @ManyToOne
    @JoinColumn(name = "fk_food_item_id")
    private FoodItem foodItem;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    OrderStatus status;
}
