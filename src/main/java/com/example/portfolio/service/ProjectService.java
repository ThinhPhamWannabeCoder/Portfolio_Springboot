package com.example.portfolio.service;

import com.example.portfolio.entity.ProjectEntity;
import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.repository.TopicRepository;
import com.example.portfolio.service.dto.ProjectDTO;
import com.example.portfolio.service.mapper.ProjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final TopicRepository topicRepository;
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
    public boolean update (Integer id,ProjectDTO dto){
        try{
            ProjectEntity entity = projectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc project theo id"));
            entity.setTopic(topicRepository.findById(dto.getTopicId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc topic thoe id")));
            entity.setName(dto.getName());
            entity.setDesc(dto.getDesc());
            return true;
        }
        catch (Exception e){
            System.out.println("Failed to update project " + e.getMessage());
            return false;
        }
    }
}
