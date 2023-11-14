package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.SkillEntity;
import com.example.portfolio.service.dto.SkillDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SkillMapper {
    private final ModelMapper modelMapper;
    public SkillEntity toEntity(SkillDTO SkillDTO){
        return modelMapper.map(SkillDTO, SkillEntity.class);
    }
    public SkillDTO toDTO(SkillEntity Skill){
        return modelMapper.map(Skill, SkillDTO.class);
    }
    //    Chuyen doi list
    public List<SkillEntity> toEntities(List<SkillDTO> SkillDTOS){
        return SkillDTOS.stream().map(SkillDTO -> modelMapper.map(SkillDTO, SkillEntity.class)).collect(Collectors.toList());
    }
    public List<SkillDTO> toDTOS(List<SkillEntity> Skills){
        return Skills.stream().map(Skill -> modelMapper.map(Skill, SkillDTO.class)).collect(Collectors.toList());
    }
}
