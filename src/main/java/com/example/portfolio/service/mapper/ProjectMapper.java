package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.ProjectEntity;
import com.example.portfolio.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectMapper {
    private final ModelMapper modelMapper;
    private final TopicMapper topicMapper;

    public ProjectEntity toEntity(ProjectDTO projectDTO){
        ProjectEntity entity = modelMapper.map(projectDTO, ProjectEntity.class);
        entity.setTopic(topicMapper.toEntity(projectDTO.getTopicDTO()));
        return entity;
    }
    public ProjectDTO toDTO(ProjectEntity projectEntity){
        ProjectDTO dto = modelMapper.map(projectEntity, ProjectDTO.class);
        dto.setTopicDTO(topicMapper.toDTO(projectEntity.getTopic()));
        return dto;
    }
    //    Chuyen doi list
    public List<ProjectEntity> toEntities(List<ProjectDTO> projectDTOS){
        return projectDTOS.stream().map(projectDTO -> {
            ProjectEntity entity = modelMapper.map(projectDTO, ProjectEntity.class);
            entity.setTopic(topicMapper.toEntity(projectDTO.getTopicDTO()));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<ProjectDTO> toDTOS(List<ProjectEntity> projectEntities){
        return projectEntities.stream().map(projectEntity -> {
            ProjectDTO dto = modelMapper.map(projectEntity, ProjectDTO.class);
            dto.setTopicDTO(topicMapper.toDTO(projectEntity.getTopic()));
            return dto;
        }).collect(Collectors.toList());
    }
}
