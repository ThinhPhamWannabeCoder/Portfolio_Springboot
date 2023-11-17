package com.example.portfolio.service;

import com.example.portfolio.repository.ProjectLanguageRefRepository;
import com.example.portfolio.service.dto.ProjectLanguageRefDTO;
import com.example.portfolio.service.mapper.ProjectLanguageRefMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectLanguageRefService {
    private final ProjectLanguageRefRepository projectLanguageRefRepository;
    private final ProjectLanguageRefMapper projectLanguageRefMapper;

    public List<ProjectLanguageRefDTO> getAll(){
        return projectLanguageRefMapper.toDTOS(projectLanguageRefRepository.findAll());
    }
    public List<ProjectLanguageRefDTO> getAllByProjectId(Integer projectId){
        return projectLanguageRefMapper.toDTOS(projectLanguageRefRepository.findByProjectId(projectId).orElse(null));
    }
    public List<ProjectLanguageRefDTO> getAllByLanguageId(Integer languageId){
        return projectLanguageRefMapper.toDTOS(projectLanguageRefRepository.findByLanguageId(languageId).orElse(null));
    }

}
