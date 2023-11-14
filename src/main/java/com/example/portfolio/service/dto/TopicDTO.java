package com.example.portfolio.service.dto;

import com.example.portfolio.entity.DomainEntity;
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
public class TopicDTO {
    private Integer id;

    private DomainDTO domainDTO;

    private String name;
    private String desc;
}
