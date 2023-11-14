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
    public ProjectLanguageRefEntity toEntity(ProjectLanguageRefDTO ProjectLanguageRefDTO){
        return modelMapper.map(ProjectLanguageRefDTO, ProjectLanguageRefEntity.class);
    }
    public ProjectLanguageRefDTO toDTO(ProjectLanguageRefEntity ProjectLanguageRef){
        return modelMapper.map(ProjectLanguageRef, ProjectLanguageRefDTO.class);
    }
    //    Chuyen doi list
    public List<ProjectLanguageRefEntity> toEntities(List<ProjectLanguageRefDTO> ProjectLanguageRefDTOS){
        return ProjectLanguageRefDTOS.stream().map(ProjectLanguageRefDTO -> modelMapper.map(ProjectLanguageRefDTO, ProjectLanguageRefEntity.class)).collect(Collectors.toList());
    }
    public List<ProjectLanguageRefDTO> toDTOS(List<ProjectLanguageRefEntity> ProjectLanguageRefs){
        return ProjectLanguageRefs.stream().map(ProjectLanguageRef -> modelMapper.map(ProjectLanguageRef, ProjectLanguageRefDTO.class)).collect(Collectors.toList());
    }
}
