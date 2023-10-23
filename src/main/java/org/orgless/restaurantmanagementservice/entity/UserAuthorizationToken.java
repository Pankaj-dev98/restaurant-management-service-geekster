package org.orgless.restaurantmanagementservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_authorization_token")
public class UserAuthorizationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "token_value")
    private String tokenValue;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
}
