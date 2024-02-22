package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.RoleEntity;
import com.example.portfolio.service.dto.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleMapper {
    private final ModelMapper modelMapper;
    //    chuyen doi 1
    public RoleEntity toEntity(RoleDTO roleDTO){
        return modelMapper.map(roleDTO, RoleEntity.class);
    }
    public RoleDTO toDTO(RoleEntity role){
        return modelMapper.map(role, RoleDTO.class);
    }
    //    Chuyen doi list
    public List<RoleEntity> toEntities(List<RoleDTO> roleDTOS){
        return roleDTOS.stream().map(roleDTO -> modelMapper.map(roleDTO, RoleEntity.class)).collect(Collectors.toList());
    }
    public List<RoleDTO> toDTOS(List<RoleEntity> roles){
        return roles.stream().map(role -> modelMapper.map(role, RoleDTO.class)).collect(Collectors.toList());
    }
}
