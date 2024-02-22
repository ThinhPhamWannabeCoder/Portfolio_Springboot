package com.example.portfolio.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeHolderDTO {
    private Integer id;

    private UserDTO userDTO;

    private PostDTO postDTO;

    private Date date;
}
