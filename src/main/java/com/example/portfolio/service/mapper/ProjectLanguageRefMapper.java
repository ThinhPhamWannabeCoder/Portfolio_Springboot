package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.ProjectLanguageRefEntity;
import com.example.portfolio.service.dto.ProjectLanguageRefDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectLanguageRefMapper {
    private final ModelMapper modelMapper;
    private final SkillMapper skillMapper;
    private final ProjectMapper projectMapper;
    public ProjectLanguageRefEntity toEntity(ProjectLanguageRefDTO projectLanguageRefDTO){
        ProjectLanguageRefEntity entity = modelMapper.map(projectLanguageRefDTO, ProjectLanguageRefEntity.class);
        entity.setLanguage(skillMapper.toEntity(projectLanguageRefDTO.getLanguageDTO()));
        entity.setProject(projectMapper.toEntity(projectLanguageRefDTO.getProjectDTO()));
        return entity;
    }
    public ProjectLanguageRefDTO toDTO(ProjectLanguageRefEntity projectLanguageRefEntity){
        ProjectLanguageRefDTO dto = modelMapper.map(projectLanguageRefEntity, ProjectLanguageRefDTO.class);;
        dto.setLanguageDTO(skillMapper.toDTO(projectLanguageRefEntity.getLanguage()));
        dto.setProjectDTO(projectMapper.toDTO(projectLanguageRefEntity.getProject()));
        return dto;
    }
    //    Chuyen doi list
    public List<ProjectLanguageRefEntity> toEntities(List<ProjectLanguageRefDTO> projectLanguageRefDTOS){
        return projectLanguageRefDTOS.stream().map(projectLanguageRefDTO -> {
            ProjectLanguageRefEntity entity = modelMapper.map(projectLanguageRefDTO, ProjectLanguageRefEntity.class);
            entity.setLanguage(skillMapper.toEntity(projectLanguageRefDTO.getLanguageDTO()));
            entity.setProject(projectMapper.toEntity(projectLanguageRefDTO.getProjectDTO()));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<ProjectLanguageRefDTO> toDTOS(List<ProjectLanguageRefEntity> projectLanguageRefEntities){
        return projectLanguageRefEntities.stream().map(projectLanguageRefEntity -> {
            ProjectLanguageRefDTO dto = modelMapper.map(projectLanguageRefEntity, ProjectLanguageRefDTO.class);;
            dto.setLanguageDTO(skillMapper.toDTO(projectLanguageRefEntity.getLanguage()));
            dto.setProjectDTO(projectMapper.toDTO(projectLanguageRefEntity.getProject()));
            return dto;
        }).collect(Collectors.toList());
    }
}
