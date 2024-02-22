package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.ProjectLanguageRefEntity;
import com.example.portfolio.form.request.FormProjectLanguage;
import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.repository.SkillRepository;
import com.example.portfolio.service.dto.ProjectLanguageRefDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectLanguageRefMapper {
    private final ModelMapper modelMapper;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final SkillMapper skillMapper;
    public ProjectLanguageRefEntity toEntity(ProjectLanguageRefDTO projectLanguageRefDTO){
        ProjectLanguageRefEntity entity = modelMapper.map(projectLanguageRefDTO, ProjectLanguageRefEntity.class);
        entity.setLanguage(skillRepository.findById(projectLanguageRefDTO.getLanguageDTO().getId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc skill theo id da cho")));
        entity.setProject(projectRepository.findById(projectLanguageRefDTO.getProjectId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc Project theo id da cho")));
        return entity;
    }
    public ProjectLanguageRefEntity toEntity(FormProjectLanguage formProjectLanguage) {
        ProjectLanguageRefEntity entity = modelMapper.map(formProjectLanguage, ProjectLanguageRefEntity.class);
        entity.setProject(projectRepository.findById(formProjectLanguage.getProjectId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc Project theo id da cho")));
        entity.setLanguage(skillRepository.findById(formProjectLanguage.getLanguageId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc skill theo id da cho")));
        return entity;
    }
    public ProjectLanguageRefDTO toDTO(ProjectLanguageRefEntity projectLanguageRefEntity){
        ProjectLanguageRefDTO dto = modelMapper.map(projectLanguageRefEntity, ProjectLanguageRefDTO.class);;
        dto.setLanguageDTO(skillMapper.toDTO(skillRepository.findById(projectLanguageRefEntity.getLanguage().getId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc skill theo id da cho"))));
        dto.setProjectId(projectLanguageRefEntity.getProject().getId());
        return dto;
    }
    //    Chuyen doi list
    public List<ProjectLanguageRefEntity> toEntities(List<ProjectLanguageRefDTO> projectLanguageRefDTOS){
        return projectLanguageRefDTOS.stream().map(projectLanguageRefDTO -> {
            ProjectLanguageRefEntity entity = modelMapper.map(projectLanguageRefDTO, ProjectLanguageRefEntity.class);
            entity.setLanguage(skillRepository.findById(projectLanguageRefDTO.getLanguageDTO().getId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc skill theo id da cho")));
            entity.setProject(projectRepository.findById(projectLanguageRefDTO.getProjectId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc Project theo id da cho")));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<ProjectLanguageRefDTO> toDTOS(List<ProjectLanguageRefEntity> projectLanguageRefEntities){
        return projectLanguageRefEntities.stream().map(projectLanguageRefEntity -> {
            ProjectLanguageRefDTO dto = modelMapper.map(projectLanguageRefEntity, ProjectLanguageRefDTO.class);;
            dto.setLanguageDTO(skillMapper.toDTO(skillRepository.findById(projectLanguageRefEntity.getLanguage().getId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc skill theo id da cho"))));
            dto.setProjectId(projectLanguageRefEntity.getProject().getId());
            return dto;
        }).collect(Collectors.toList());
    }


}
