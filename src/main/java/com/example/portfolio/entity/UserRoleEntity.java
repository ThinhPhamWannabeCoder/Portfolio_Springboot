package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user_role")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName ="user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id",nullable = false)
    private  RoleEntity role;
    @Override
    public String toString() {
        return "User_Role{" +
                "id=" + id +
                ", role=" + role.getId() + // Include only relevant information
                '}';
    }
}
