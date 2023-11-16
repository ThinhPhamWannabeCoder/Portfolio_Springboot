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
    private final DomainMapper domainMapper;
    private final SkillMapper skillMapper;
    public DomainSkillRefEntity toEntity(DomainSkillRefDTO domainSkillRefDTO){
        DomainSkillRefEntity domainSkillRefEntity = modelMapper.map(domainSkillRefDTO, DomainSkillRefEntity.class);
        domainSkillRefEntity.setDomain(domainMapper.toEntity(domainSkillRefDTO.getDomainDTO()));
        domainSkillRefEntity.setSkill(skillMapper.toEntity(domainSkillRefDTO.getSkillDTO()));
        return domainSkillRefEntity;
    }
    public DomainSkillRefDTO toDTO(DomainSkillRefEntity domainSkillRefEntity){
        DomainSkillRefDTO domainSkillRefDTO = modelMapper.map(domainSkillRefEntity, DomainSkillRefDTO.class);
        domainSkillRefDTO.setDomainDTO(domainMapper.toDTO(domainSkillRefEntity.getDomain()));
        domainSkillRefDTO.setSkillDTO(skillMapper.toDTO(domainSkillRefEntity.getSkill()));
        return domainSkillRefDTO;
    }
    //    Chuyen doi list
    public List<DomainSkillRefEntity> toEntities(List<DomainSkillRefDTO> domainSkillRefDTOS){
        List<DomainSkillRefEntity> domainSkillRefEntityList = domainSkillRefDTOS
                .stream()
                .map(domainSkillRefDTO -> {
                    DomainSkillRefEntity entity = modelMapper.map(domainSkillRefDTO, DomainSkillRefEntity.class);
                    entity.setDomain(domainMapper.toEntity(domainSkillRefDTO.getDomainDTO()));
                    entity.setSkill(skillMapper.toEntity(domainSkillRefDTO.getSkillDTO()));
                    return entity;
                })
                .collect(Collectors.toList());
        return domainSkillRefDTOS.stream().map(domainSkillRefDTO -> modelMapper.map(domainSkillRefDTO, DomainSkillRefEntity.class)).collect(Collectors.toList());
    }
    public List<DomainSkillRefDTO> toDTOS(List<DomainSkillRefEntity> domainSkillRefEntities){
        return domainSkillRefEntities.stream()
                .map(domainSkillRefEntity -> {
                    DomainSkillRefDTO dto = modelMapper.map(domainSkillRefEntity, DomainSkillRefDTO.class);
                    dto.setSkillDTO(skillMapper.toDTO(domainSkillRefEntity.getSkill()));
                    dto.setDomainDTO(domainMapper.toDTO(domainSkillRefEntity.getDomain()));
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
