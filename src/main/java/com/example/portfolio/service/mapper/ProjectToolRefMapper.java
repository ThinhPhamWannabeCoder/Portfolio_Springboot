package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.ProjectToolRefEntity;
import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.repository.SkillRepository;
import com.example.portfolio.service.dto.ProjectToolRefDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectToolRefMapper {
    private final ModelMapper modelMapper;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final SkillMapper skillMapper;
    public ProjectToolRefEntity toEntity(ProjectToolRefDTO projectToolRefDTO){
        ProjectToolRefEntity entity = modelMapper.map(projectToolRefDTO, ProjectToolRefEntity.class);
        entity.setTool(skillRepository.findById(projectToolRefDTO.getToolDTO().getId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc skill theo id da cho")));
        entity.setProject(projectRepository.findById(projectToolRefDTO.getProjectId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc Project theo id da cho")));
        return entity;
    }
    public ProjectToolRefDTO toDTO(ProjectToolRefEntity projectToolRefEntity){
        ProjectToolRefDTO dto = modelMapper.map(projectToolRefEntity, ProjectToolRefDTO.class);
        dto.setToolDTO(skillMapper.toDTO(skillRepository.findById( projectToolRefEntity
                                                                    .getTool()
                                                                    .getId())
                .orElseThrow(() -> new EntityNotFoundException("Khong tim duoc skill theo id da cho"))));
        dto.setProjectId(projectToolRefEntity.getProject().getId());
        return dto;
    }
    //    Chuyen doi list
    public List<ProjectToolRefEntity> toEntities(List<ProjectToolRefDTO> projectToolRefDTOS){
        return projectToolRefDTOS.stream().map(projectToolRefDTO -> {
            ProjectToolRefEntity entity = modelMapper.map(projectToolRefDTO, ProjectToolRefEntity.class);
            entity.setTool(skillRepository.findById(projectToolRefDTO.getToolDTO().getId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc skill theo id da cho")));
            entity.setProject(projectRepository.findById(projectToolRefDTO.getProjectId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc Project theo id da cho")));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<ProjectToolRefDTO> toDTOS(List<ProjectToolRefEntity> projectToolRefEntities){
        return projectToolRefEntities.stream().map(projectToolRefEntity -> {
            ProjectToolRefDTO dto = modelMapper.map(projectToolRefEntity, ProjectToolRefDTO.class);;
            dto.setToolDTO(skillMapper.toDTO(skillRepository.findById(projectToolRefEntity.getTool().getId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc skill theo id da cho"))));
            dto.setProjectId(projectToolRefEntity.getProject().getId());
            return dto;
        }).collect(Collectors.toList());
    }
}
