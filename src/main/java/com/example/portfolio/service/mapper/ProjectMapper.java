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
    public ProjectEntity toEntity(ProjectDTO ProjectDTO){
        return modelMapper.map(ProjectDTO, ProjectEntity.class);
    }
    public ProjectDTO toDTO(ProjectEntity Project){
        return modelMapper.map(Project, ProjectDTO.class);
    }
    //    Chuyen doi list
    public List<ProjectEntity> toEntities(List<ProjectDTO> ProjectDTOS){
        return ProjectDTOS.stream().map(ProjectDTO -> modelMapper.map(ProjectDTO, ProjectEntity.class)).collect(Collectors.toList());
    }
    public List<ProjectDTO> toDTOS(List<ProjectEntity> Projects){
        return Projects.stream().map(Project -> modelMapper.map(Project, ProjectDTO.class)).collect(Collectors.toList());
    }
}
