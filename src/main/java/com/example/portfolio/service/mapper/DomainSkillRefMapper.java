package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.DomainSkillRefEntity;
import com.example.portfolio.service.dto.DomainSkillRefDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DomainSkillRefMapper {
    private final ModelMapper modelMapper;
    public DomainSkillRefEntity toEntity(DomainSkillRefDTO DomainSkillRefDTO){
        return modelMapper.map(DomainSkillRefDTO, DomainSkillRefEntity.class);
    }
    public DomainSkillRefDTO toDTO(DomainSkillRefEntity DomainSkillRef){
        return modelMapper.map(DomainSkillRef, DomainSkillRefDTO.class);
    }
    //    Chuyen doi list
    public List<DomainSkillRefEntity> toEntities(List<DomainSkillRefDTO> DomainSkillRefDTOS){
        return DomainSkillRefDTOS.stream().map(DomainSkillRefDTO -> modelMapper.map(DomainSkillRefDTO, DomainSkillRefEntity.class)).collect(Collectors.toList());
    }
    public List<DomainSkillRefDTO> toDTOS(List<DomainSkillRefEntity> DomainSkillRefs){
        return DomainSkillRefs.stream().map(DomainSkillRef -> modelMapper.map(DomainSkillRef, DomainSkillRefDTO.class)).collect(Collectors.toList());
    }
}
