package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.ProjectToolRefEntity;
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
    public ProjectToolRefEntity toEntity(ProjectToolRefDTO ProjectToolRefDTO){
        return modelMapper.map(ProjectToolRefDTO, ProjectToolRefEntity.class);
    }
    public ProjectToolRefDTO toDTO(ProjectToolRefEntity ProjectToolRef){
        return modelMapper.map(ProjectToolRef, ProjectToolRefDTO.class);
    }
    //    Chuyen doi list
    public List<ProjectToolRefEntity> toEntities(List<ProjectToolRefDTO> ProjectToolRefDTOS){
        return ProjectToolRefDTOS.stream().map(ProjectToolRefDTO -> modelMapper.map(ProjectToolRefDTO, ProjectToolRefEntity.class)).collect(Collectors.toList());
    }
    public List<ProjectToolRefDTO> toDTOS(List<ProjectToolRefEntity> ProjectToolRefs){
        return ProjectToolRefs.stream().map(ProjectToolRef -> modelMapper.map(ProjectToolRef, ProjectToolRefDTO.class)).collect(Collectors.toList());
    }
}
