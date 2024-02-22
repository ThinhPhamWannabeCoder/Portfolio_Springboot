package com.example.portfolio.service.dto;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {
    private Integer user_role_id;
    private Integer user_id;
    private Integer role_id;
}
