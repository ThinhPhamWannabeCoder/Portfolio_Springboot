package com.example.portfolio.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectToolRefDTO {
    private Integer id;

    private ProjectDTO projectDTO;


    private SkillDTO toolDTO;
}
