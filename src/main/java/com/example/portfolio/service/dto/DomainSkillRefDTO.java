package com.example.portfolio.service.dto;

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

    private Integer domainId;

    private Integer skillId;
}
