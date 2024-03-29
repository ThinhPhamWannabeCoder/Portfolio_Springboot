package com.example.portfolio.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String email;
    private String password;
    private String fullName;
    //    private List<RoleDTO> roles ;
    private List<UserRoleDTO> userroleDTOList;
}
