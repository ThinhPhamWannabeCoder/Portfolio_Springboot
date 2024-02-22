package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.DomainSkillRefEntity;
import com.example.portfolio.repository.DomainRepository;
import com.example.portfolio.repository.SkillRepository;
import com.example.portfolio.service.dto.DomainSkillRefDTO;
import jakarta.persistence.EntityNotFoundException;
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
    private final DomainRepository domainRepository;
    private final SkillRepository skillRepository;
    public DomainSkillRefEntity toEntity(DomainSkillRefDTO domainSkillRefDTO){
        DomainSkillRefEntity entity = modelMapper.map(domainSkillRefDTO, DomainSkillRefEntity.class);
        entity.setDomain(domainRepository.findById(domainSkillRefDTO.getDomainId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc thong tin domain theo id da cho")));
        entity.setSkill(skillRepository.findById(domainSkillRefDTO.getSkillId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc skill voi id da cho")));
        return entity;
    }
    public DomainSkillRefDTO toDTO(DomainSkillRefEntity domainSkillRefEntity){
        DomainSkillRefDTO dto = modelMapper.map(domainSkillRefEntity, DomainSkillRefDTO.class);
        dto.setDomainId(domainSkillRefEntity.getDomain().getId());
        dto.setSkillId(domainSkillRefEntity.getSkill().getId());
        return dto;
    }
    //    Chuyen doi list
    public List<DomainSkillRefEntity> toEntities(List<DomainSkillRefDTO> domainSkillRefDTOS){
        List<DomainSkillRefEntity> domainSkillRefEntityList = domainSkillRefDTOS
                .stream()
                .map(domainSkillRefDTO -> {
                    DomainSkillRefEntity entity = modelMapper.map(domainSkillRefDTO, DomainSkillRefEntity.class);
                    entity.setDomain(domainRepository.findById(domainSkillRefDTO.getDomainId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc thong tin domain theo id da cho")));
                    entity.setSkill(skillRepository.findById(domainSkillRefDTO.getSkillId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc skill voi id da cho")));
                    return entity;
                })
                .collect(Collectors.toList());
        return domainSkillRefDTOS.stream().map(domainSkillRefDTO -> modelMapper.map(domainSkillRefDTO, DomainSkillRefEntity.class)).collect(Collectors.toList());
    }
    public List<DomainSkillRefDTO> toDTOS(List<DomainSkillRefEntity> domainSkillRefEntities){
        return domainSkillRefEntities.stream()
                .map(domainSkillRefEntity -> {
                    DomainSkillRefDTO dto = modelMapper.map(domainSkillRefEntity, DomainSkillRefDTO.class);
                    dto.setDomainId(domainSkillRefEntity.getDomain().getId());
                    dto.setSkillId(domainSkillRefEntity.getSkill().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
