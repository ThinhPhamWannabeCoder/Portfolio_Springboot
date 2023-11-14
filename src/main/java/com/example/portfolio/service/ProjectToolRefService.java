package com.example.portfolio.service;

import com.example.portfolio.repository.ProjectToolRefRepository;
import com.example.portfolio.service.dto.ProjectToolRefDTO;
import com.example.portfolio.service.mapper.ProjectToolRefMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectToolRefService {
    private final ProjectToolRefRepository projectToolRefRepository;
    private final ProjectToolRefMapper projectToolRefMapper;

    public List<ProjectToolRefDTO> getAll(){
        return projectToolRefMapper.toDTOS(projectToolRefRepository.findAll());
    }
    public List<ProjectToolRefDTO> getByProjectId(Integer projectId){
        return projectToolRefMapper.toDTOS(projectToolRefRepository.findByProjectId(projectId).orElse(null));
    }
    public List<ProjectToolRefDTO> getByToolId(Integer toolId){
        return projectToolRefMapper.toDTOS(projectToolRefRepository.findByToolId(toolId).orElse(null));
    }
}
