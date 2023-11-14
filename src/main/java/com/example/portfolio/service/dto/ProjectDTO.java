package com.example.portfolio.service.dto;

import com.example.portfolio.entity.TopicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private Integer id;

    private TopicDTO topicDTO;

    private String name;
    private String desc;
    private Date date;
}
