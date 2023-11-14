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
    public DomainEntity toEntity(DomainDTO DomainDTO){
        return modelMapper.map(DomainDTO, DomainEntity.class);
    }
    public DomainDTO toDTO(DomainEntity Domain){
        return modelMapper.map(Domain, DomainDTO.class);
    }
    //    Chuyen doi list
    public List<DomainEntity> toEntities(List<DomainDTO> DomainDTOS){
        return DomainDTOS.stream().map(DomainDTO -> modelMapper.map(DomainDTO, DomainEntity.class)).collect(Collectors.toList());
    }
    public List<DomainDTO> toDTOS(List<DomainEntity> Domains){
        return Domains.stream().map(Domain -> modelMapper.map(Domain, DomainDTO.class)).collect(Collectors.toList());
    }
}
