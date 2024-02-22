package com.example.portfolio.service;

import com.example.portfolio.form.request.FormProjectLanguage;
import com.example.portfolio.form.request.FormProjectTool;
import com.example.portfolio.repository.ProjectToolRefRepository;
import com.example.portfolio.repository.SkillRepository;
import com.example.portfolio.service.dto.ProjectLanguageRefDTO;
import com.example.portfolio.service.dto.ProjectToolRefDTO;
import com.example.portfolio.service.mapper.ProjectToolRefMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectToolRefService {
    private final ProjectToolRefRepository projectToolRefRepository;
    private final ProjectToolRefMapper projectToolRefMapper;
    private final SkillRepository skillRepository;

    public List<ProjectToolRefDTO> getAll(){
        return projectToolRefMapper.toDTOS(projectToolRefRepository.findAll());
    }
    public ProjectToolRefDTO getById(Integer id){
        return projectToolRefMapper.toDTO(projectToolRefRepository.findById(id).orElse(null));
    }
    public List<ProjectToolRefDTO> getAllByProjectId(Integer projectId){
        return projectToolRefMapper.toDTOS(projectToolRefRepository.findByProjectId(projectId).orElse(null));
    }
    public List<ProjectToolRefDTO> getByToolId(Integer toolId){
        return projectToolRefMapper.toDTOS(projectToolRefRepository.findByToolId(toolId).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            projectToolRefRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin project lanuage theo id" + e.getMessage());
            return false;
        }
    }

    public boolean save(FormProjectTool formProjectTool){
        try{
//            Kiem tra xem co dung lanuage id nay mang type la languae
            if( skillRepository.findById(formProjectTool.getToolId()).orElseThrow(()-> new EntityNotFoundException(" khong tim dc skill voi id do")).getSkillType().getName().equals("tool")){
                projectToolRefRepository.save(projectToolRefMapper.toEntity(formProjectTool));
            };

            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro place" + e.getMessage());
            return false;
        }
    }
}
