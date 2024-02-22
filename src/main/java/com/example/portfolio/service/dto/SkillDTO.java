package com.example.portfolio.service.dto;

import com.example.portfolio.entity.SkillTypeEntity;
import jakarta.persistence.Column;
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
public class SkillDTO {
    private Integer id;

    private SkillTypeDTO skillTypeDTO;

    private String name;
    private String desc;
}
