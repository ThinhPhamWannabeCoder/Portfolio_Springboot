package com.example.portfolio.service.dto;

import com.example.portfolio.entity.DomainEntity;
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
public class DomainSkillRefDTO {
    private Integer id;

    private DomainDTO domainDTO;

    private SkillEntity skill;
}
