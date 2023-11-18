package com.example.portfolio.service;


import com.example.portfolio.repository.SkillTypeRepository;
import com.example.portfolio.service.dto.SkillTypeDTO;
import com.example.portfolio.service.mapper.SkillTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillTypeService {
    private final SkillTypeRepository skillTypeRepository;
    private final SkillTypeMapper skillTypeMapper;

    public List<SkillTypeDTO> getAll(){
        return skillTypeMapper.toDTOS(skillTypeRepository.findAll());
    }
    public SkillTypeDTO getById(Integer id){
        return  skillTypeMapper.toDTO(skillTypeRepository.findById(id).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            skillTypeRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin skillType theo id" + e.getMessage());
            return false;
        }
    }
    public boolean deleteByName(String name){
        try{
            skillTypeRepository.deleteByName(name);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin skillType theo name" + e.getMessage());
            return false;
        }
    }
    public boolean create(SkillTypeDTO skillTypeDTO){
        try{
            skillTypeRepository.save(skillTypeMapper.toEntity(skillTypeDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin SkillType" + e.getMessage());
            return false;
        }
    }
    
}
