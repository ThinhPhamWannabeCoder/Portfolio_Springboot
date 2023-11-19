package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.SkillEntity;
import com.example.portfolio.form.request.FormSkill;
import com.example.portfolio.repository.SkillTypeRepository;
import com.example.portfolio.service.dto.SkillDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SkillMapper {
    private final ModelMapper modelMapper;
    private final SkillTypeMapper skillTypeMapper;
    private final SkillTypeRepository skillTypeRepository;
    public SkillEntity toEntity(SkillDTO skillDTO){
        SkillEntity entity = modelMapper.map(skillDTO, SkillEntity.class);
        entity.setSkillType(skillTypeMapper.toEntity(skillDTO.getSkillTypeDTO()));
        return entity;
    }
    public SkillEntity FormtoEntity(FormSkill formSkill) {
        SkillEntity entity = modelMapper.map(formSkill, SkillEntity.class);
        entity.setSkillType(skillTypeRepository.findById(formSkill.getSkillTypeId()).orElseThrow(() -> new EntityNotFoundException("Failed to get Skill Type")));
        return entity;
    }
    public SkillDTO toDTO(SkillEntity skillEntity){
        SkillDTO dto = modelMapper.map(skillEntity, SkillDTO.class);
        dto.setSkillTypeDTO(skillTypeMapper.toDTO(skillEntity.getSkillType()));
        return dto;
    }
    //    Chuyen doi list
    public List<SkillEntity> toEntities(List<SkillDTO> skillDTOS){
        return skillDTOS.stream().map(skillDTO -> {
            SkillEntity entity = modelMapper.map(skillDTO, SkillEntity.class);
            entity.setSkillType(skillTypeMapper.toEntity(skillDTO.getSkillTypeDTO()));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<SkillDTO> toDTOS(List<SkillEntity> skillEntities){
        return skillEntities.stream().map(skillEntity ->{
            SkillDTO dto = modelMapper.map(skillEntity, SkillDTO.class);
            dto.setSkillTypeDTO(skillTypeMapper.toDTO(skillEntity.getSkillType()));
            return dto;
        }).collect(Collectors.toList());
    }


}
