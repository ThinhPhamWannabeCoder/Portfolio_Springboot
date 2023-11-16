package com.example.portfolio.service.dto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLanguageRefDTO {
    private Integer id;

    private ProjectDTO projectDTO;

    private SkillDTO languageDTO;
}
