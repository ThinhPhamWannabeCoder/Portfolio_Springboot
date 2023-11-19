package com.example.portfolio.service;

import com.example.portfolio.entity.SkillEntity;
import com.example.portfolio.form.request.FormSkill;
import com.example.portfolio.repository.SkillRepository;
import com.example.portfolio.repository.SkillTypeRepository;
import com.example.portfolio.service.dto.SkillDTO;
import com.example.portfolio.service.dto.SkillTypeDTO;
import com.example.portfolio.service.mapper.SkillMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;
    private final SkillTypeRepository skillTypeRepository;

    public List<SkillDTO> getAll(){
        return skillMapper.toDTOS(skillRepository.findAll());
    }
    public SkillDTO getById(Integer id){
        return  skillMapper.toDTO(skillRepository.findById(id).orElse(null));
    }
    public SkillDTO getByName(String name){
        return  skillMapper.toDTO(skillRepository.findByName(name).orElse(null));
    }

    public List<SkillDTO> getBySkillTypeId(Integer skillTypeId){
        return skillMapper.toDTOS(skillRepository.findBySkillTypeId(skillTypeId).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            skillRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin skill theo id" + e.getMessage());
            return false;
        }
    }
    public boolean deleteByName(String name){
        try{
            skillRepository.deleteByName(name);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin skill theo ten" + e.getMessage());
            return false;
        }
    }
    public boolean create(FormSkill formSkill){
        try{
            skillRepository.save(skillMapper.FormtoEntity(formSkill));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro place" + e.getMessage());
            return false;
        }
    }
    public boolean update(Integer id,FormSkill formSkill){
        try{
            SkillEntity entity =  skillRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Failed to find Skill by id"));

            entity.setSkillType(skillTypeRepository.findById(formSkill.getSkillTypeId()).orElseThrow(()->new EntityNotFoundException("Failed to find SkillType by id")));
            entity.setName(formSkill.getName());
            entity.setDesc(formSkill.getDesc());

            skillRepository.save(entity);
            return true;
        }
        catch (Exception e){
            System.out.println("Failed to update skill " +e.getMessage());
            return false;
        }
    }

}
