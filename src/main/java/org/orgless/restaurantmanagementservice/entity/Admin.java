package org.orgless.restaurantmanagementservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Entity
@Table(name = "admin")
@Validated
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Pattern(regexp = "^.*@admin\\.com$")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
