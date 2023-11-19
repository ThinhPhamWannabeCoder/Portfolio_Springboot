package com.example.portfolio.service;

import com.example.portfolio.entity.DomainSkillRefEntity;
import com.example.portfolio.repository.DomainRepository;
import com.example.portfolio.repository.DomainSkillRefRepository;
import com.example.portfolio.repository.SkillRepository;
import com.example.portfolio.service.dto.DomainSkillRefDTO;
import com.example.portfolio.service.mapper.DomainSkillRefMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainSkillRefService {
    private final DomainSkillRefRepository domainSkillRefRepository;
    private final DomainSkillRefMapper domainSkillRefMapper;
    private final DomainRepository domainRepository;
    private final SkillRepository skillRepository;
    public List<DomainSkillRefDTO> getAll(){
        return domainSkillRefMapper.toDTOS(domainSkillRefRepository.findAll());
    }
    public DomainSkillRefDTO getById(Integer id){
        return domainSkillRefMapper.toDTO(domainSkillRefRepository.findById(id).orElse(null));
    }
    public List<DomainSkillRefDTO> geByDomainId(Integer domainId){
        return domainSkillRefMapper.toDTOS(domainSkillRefRepository.findByDomainId(domainId).orElse(null));
    }
    public List<DomainSkillRefDTO> getBySkillId(Integer skillId){
        return domainSkillRefMapper.toDTOS(domainSkillRefRepository.findBySkillId(skillId).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            domainSkillRefRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin intro place" + e.getMessage());
            return false;
        }
    }
    @Transactional
    public boolean create(DomainSkillRefDTO domainSkillRefDTO){
        try{
            domainSkillRefRepository.save(domainSkillRefMapper.toEntity(domainSkillRefDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro place" + e.getMessage());
            return false;
        }
    }
    @Transactional
    public boolean update(Integer id,  DomainSkillRefDTO dto){
        try{
            DomainSkillRefEntity entity = domainSkillRefRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc thong tin DomainSkill"));
            entity.setSkill(skillRepository.findById(dto.getSkillId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc thong tin Skill moi")));
            entity.setDomain(domainRepository.findById(dto.getDomainId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc thong tin domain moi")));
            domainSkillRefRepository.save(entity);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong update thanh cong Domain Sill " + e.getMessage());
            return false;
        }
    }
}
