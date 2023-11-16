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
public class AboutDTO {
    private Integer id;

    private UserDTO userDTO;

    private String type;

    private String header;

    private String tag_1;

    private String tag_2;

    private String desc;

    private Date date;
}
