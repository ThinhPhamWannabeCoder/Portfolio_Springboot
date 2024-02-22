package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.DomainEntity;
import com.example.portfolio.service.dto.DomainDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DomainMapper {
    private final ModelMapper modelMapper;

    public DomainEntity toEntity(DomainDTO domainDTO){
        return modelMapper.map(domainDTO, DomainEntity.class);
    }
    public DomainDTO toDTO(DomainEntity domainEntity){
        return modelMapper.map(domainEntity, DomainDTO.class);
    }
    //    Chuyen doi list
    public List<DomainEntity> toEntities(List<DomainDTO> domainDTOS){
        return domainDTOS.stream().map(domainDTO -> modelMapper.map(domainDTO, DomainEntity.class)).collect(Collectors.toList());
    }
    public List<DomainDTO> toDTOS(List<DomainEntity> domainEntities){
        return domainEntities.stream().map(domainEntity -> modelMapper.map(domainEntity, DomainDTO.class)).collect(Collectors.toList());
    }
}
