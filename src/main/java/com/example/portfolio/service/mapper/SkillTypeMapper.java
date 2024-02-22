package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.SkillTypeEntity;
import com.example.portfolio.service.dto.SkillTypeDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SkillTypeMapper {
    private final ModelMapper modelMapper;
    public SkillTypeEntity toEntity(SkillTypeDTO SkillTypeDTO){
        return modelMapper.map(SkillTypeDTO, SkillTypeEntity.class);
    }
    public SkillTypeDTO toDTO(SkillTypeEntity SkillType){
        return modelMapper.map(SkillType, SkillTypeDTO.class);
    }
    //    Chuyen doi list
    public List<SkillTypeEntity> toEntities(List<SkillTypeDTO> SkillTypeDTOS){
        return SkillTypeDTOS.stream().map(SkillTypeDTO -> modelMapper.map(SkillTypeDTO, SkillTypeEntity.class)).collect(Collectors.toList());
    }
    public List<SkillTypeDTO> toDTOS(List<SkillTypeEntity> SkillTypes){
        return SkillTypes.stream().map(SkillType -> modelMapper.map(SkillType, SkillTypeDTO.class)).collect(Collectors.toList());
    }
}
