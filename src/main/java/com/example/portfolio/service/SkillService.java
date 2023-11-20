package com.example.portfolio.service;

import com.example.portfolio.repository.SkillRepository;
import com.example.portfolio.service.dto.SkillDTO;
import com.example.portfolio.service.mapper.SkillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    public List<SkillDTO> getAll(){
        return skillMapper.toDTOS(skillRepository.findAll());
    }
    public SkillDTO getById(Integer id){
        return  skillMapper.toDTO(skillRepository.findById(id).orElse(null));
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
    public boolean create(SkillDTO skillDTO){
        try{
            skillRepository.save(skillMapper.toEntity(skillDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro place" + e.getMessage());
            return false;
        }
    }

}
