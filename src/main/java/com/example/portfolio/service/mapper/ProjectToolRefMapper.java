package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.ProjectToolRefEntity;
import com.example.portfolio.entity.ProjectToolRefEntity;
import com.example.portfolio.service.dto.ProjectToolRefDTO;
import com.example.portfolio.service.dto.ProjectToolRefDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectToolRefMapper {
    private final ModelMapper modelMapper;
    private final SkillMapper skillMapper;
    private final ProjectMapper projectMapper;
    public ProjectToolRefEntity toEntity(ProjectToolRefDTO projectToolRefDTO){
        ProjectToolRefEntity entity = modelMapper.map(projectToolRefDTO, ProjectToolRefEntity.class);
        entity.setTool(skillMapper.toEntity(projectToolRefDTO.getToolDTO()));
        entity.setProject(projectMapper.toEntity(projectToolRefDTO.getProjectDTO()));
        return entity;
    }
    public ProjectToolRefDTO toDTO(ProjectToolRefEntity projectToolRefEntity){
        ProjectToolRefDTO dto = modelMapper.map(projectToolRefEntity, ProjectToolRefDTO.class);;
        dto.setToolDTO(skillMapper.toDTO(projectToolRefEntity.getTool()));
        dto.setProjectDTO(projectMapper.toDTO(projectToolRefEntity.getProject()));
        return dto;
    }
    //    Chuyen doi list
    public List<ProjectToolRefEntity> toEntities(List<ProjectToolRefDTO> projectToolRefDTOS){
        return projectToolRefDTOS.stream().map(projectToolRefDTO -> {
            ProjectToolRefEntity entity = modelMapper.map(projectToolRefDTO, ProjectToolRefEntity.class);
            entity.setTool(skillMapper.toEntity(projectToolRefDTO.getToolDTO()));
            entity.setProject(projectMapper.toEntity(projectToolRefDTO.getProjectDTO()));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<ProjectToolRefDTO> toDTOS(List<ProjectToolRefEntity> projectToolRefEntities){
        return projectToolRefEntities.stream().map(projectToolRefEntity -> {
            ProjectToolRefDTO dto = modelMapper.map(projectToolRefEntity, ProjectToolRefDTO.class);;
            dto.setToolDTO(skillMapper.toDTO(projectToolRefEntity.getTool()));
            dto.setProjectDTO(projectMapper.toDTO(projectToolRefEntity.getProject()));
            return dto;
        }).collect(Collectors.toList());
    }
}
