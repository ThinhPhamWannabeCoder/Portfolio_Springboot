package com.example.portfolio.service;

import com.example.portfolio.repository.DomainSkillRefRepository;
import com.example.portfolio.service.dto.DomainSkillRefDTO;
import com.example.portfolio.service.mapper.DomainSkillRefMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainSkillRefService {
    private final DomainSkillRefRepository domainSkillRefRepository;
    private final DomainSkillRefMapper domainSkillRefMapper;
    public List<DomainSkillRefDTO> getAll(){
        return domainSkillRefMapper.toDTOS(domainSkillRefRepository.findAll());
    }
    public List<DomainSkillRefDTO> geByDomainId(Integer domainId){
        return domainSkillRefMapper.toDTOS(domainSkillRefRepository.findByDomainId(domainId).orElse(null));
    }
    public List<DomainSkillRefDTO> getBySkillId(Integer skillId){
        return domainSkillRefMapper.toDTOS(domainSkillRefRepository.findBySkillId(skillId).orElse(null));
    }
}
