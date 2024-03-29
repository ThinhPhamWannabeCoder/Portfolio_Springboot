package com.example.portfolio.service;

import com.example.portfolio.form.request.FormProjectLanguage;
import com.example.portfolio.repository.ProjectLanguageRefRepository;
import com.example.portfolio.repository.SkillRepository;
import com.example.portfolio.service.dto.IntroPlaceDTO;
import com.example.portfolio.service.dto.ProjectLanguageRefDTO;
import com.example.portfolio.service.dto.SkillDTO;
import com.example.portfolio.service.mapper.ProjectLanguageRefMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectLanguageRefService {
    private final ProjectLanguageRefRepository projectLanguageRefRepository;
    private final ProjectLanguageRefMapper projectLanguageRefMapper;
    private final SkillRepository skillRepository;
    public List<ProjectLanguageRefDTO> getAll(){
        return projectLanguageRefMapper.toDTOS(projectLanguageRefRepository.findAll());
    }
    public ProjectLanguageRefDTO getById(Integer id){
        return projectLanguageRefMapper.toDTO(projectLanguageRefRepository.findById(id).orElse(null));
    }
    public List<ProjectLanguageRefDTO> getAllByProjectId(Integer projectId){
        return projectLanguageRefMapper.toDTOS(projectLanguageRefRepository.findByProjectId(projectId).orElse(null));
    }
    public List<ProjectLanguageRefDTO> getAllByLanguageId(Integer languageId){
        return projectLanguageRefMapper.toDTOS(projectLanguageRefRepository.findByLanguageId(languageId).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            projectLanguageRefRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin project lanuage theo id" + e.getMessage());
            return false;
        }
    }

    public boolean create(FormProjectLanguage formProjectLanguage){
        try{
//            Kiem tra xem co dung lanuage id nay mang type la languae
            if( skillRepository.findById(formProjectLanguage.getLanguageId()).orElseThrow(()-> new EntityNotFoundException("Khong tim dc skill voi id do")).getSkillType().getName().equals("language")){
                projectLanguageRefRepository.save(projectLanguageRefMapper.toEntity(formProjectLanguage));
            };

            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro place" + e.getMessage());
            return false;
        }
    }

}
