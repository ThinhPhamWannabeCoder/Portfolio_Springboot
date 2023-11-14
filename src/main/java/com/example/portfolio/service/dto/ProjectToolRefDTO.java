package com.example.portfolio.service.dto;

import com.example.portfolio.entity.ProjectEntity;
import com.example.portfolio.entity.SkillEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
