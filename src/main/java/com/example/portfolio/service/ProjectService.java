package com.example.portfolio.service;

import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.service.dto.ProjectDTO;
import com.example.portfolio.service.dto.UserDTO;
import com.example.portfolio.service.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    public List<ProjectDTO> getAll(){
        return projectMapper.toDTOS(projectRepository.findAll());
    }
    public List<ProjectDTO> getByTopicId(Integer topicId){
        return projectMapper.toDTOS(projectRepository.findByTopicId(topicId).orElse(null));
    }
}
