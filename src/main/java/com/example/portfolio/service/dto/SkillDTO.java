package com.example.portfolio.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO {
    private Integer id;

    private SkillTypeDTO skillTypeDTO;

    private String name;
    private String desc;
}
