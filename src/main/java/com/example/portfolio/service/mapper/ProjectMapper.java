package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.ProjectEntity;
import com.example.portfolio.repository.TopicRepository;
import com.example.portfolio.service.dto.ProjectDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectMapper {
    private final ModelMapper modelMapper;
    private final TopicRepository topicRepository;

    public ProjectEntity toEntity(ProjectDTO projectDTO){
        ProjectEntity entity = modelMapper.map(projectDTO, ProjectEntity.class);
        entity.setTopic(topicRepository.findById(projectDTO.getTopicId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc topic theo id da cho")));
        return entity;
    }
    public ProjectDTO toDTO(ProjectEntity projectEntity){
        ProjectDTO dto = modelMapper.map(projectEntity, ProjectDTO.class);
        dto.setTopicId(projectEntity.getTopic().getId());
        return dto;
    }
    //    Chuyen doi list
    public List<ProjectEntity> toEntities(List<ProjectDTO> projectDTOS){
        return projectDTOS.stream().map(projectDTO -> {
            ProjectEntity entity = modelMapper.map(projectDTO, ProjectEntity.class);
            entity.setTopic(topicRepository.findById(projectDTO.getTopicId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc topic theo id da cho")));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<ProjectDTO> toDTOS(List<ProjectEntity> projectEntities){
        return projectEntities.stream().map(projectEntity -> {
            ProjectDTO dto = modelMapper.map(projectEntity, ProjectDTO.class);
            dto.setTopicId(projectEntity.getTopic().getId());
            return dto;
        }).collect(Collectors.toList());
    }
}
