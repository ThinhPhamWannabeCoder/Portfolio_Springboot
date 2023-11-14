package com.example.portfolio.service;


import com.example.portfolio.repository.SkillTypeRepository;
import com.example.portfolio.service.dto.SkillDTO;
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
}
