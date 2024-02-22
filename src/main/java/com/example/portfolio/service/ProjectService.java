package com.example.portfolio.service;

import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.service.dto.ProjectDTO;
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
    public List<ProjectDTO> getAllByTopicId(Integer topicId){
        return projectMapper.toDTOS(projectRepository.findByTopicId(topicId).orElse(null));
    }
    public ProjectDTO getById(Integer id){
        return projectMapper.toDTO(projectRepository.findById(id).orElse(null));
    }
    public ProjectDTO getByName(String name){
        return projectMapper.toDTO(projectRepository.findByName(name).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            projectRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin project theo id" + e.getMessage());
            return false;
        }
    }
    public boolean deleteByName(String name){
        try{
            projectRepository.deleteByName(name);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin project theo name" + e.getMessage());
            return false;
        }
    }
    public boolean create(ProjectDTO projectDTO){
        try{
            projectRepository.save(projectMapper.toEntity(projectDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin place" + e.getMessage());
            return false;
        }
    }
}
