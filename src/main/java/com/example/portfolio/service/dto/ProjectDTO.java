package com.example.portfolio.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

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
    List<ProjectLanguageRefDTO> projectLanguageRefDTOList;

    List<ProjectToolRefDTO> projectToolRefDTOList;

    List<PostDTO> postDTOList;
}
