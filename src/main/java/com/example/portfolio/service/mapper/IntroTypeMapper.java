package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.IntroTypeEntity;
import com.example.portfolio.service.dto.IntroTypeDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class IntroTypeMapper {
    private final ModelMapper modelMapper;
    public IntroTypeEntity toEntity(IntroTypeDTO introTypeDTO){
        return modelMapper.map(introTypeDTO, IntroTypeEntity.class);
    }
    public IntroTypeDTO toDTO(IntroTypeEntity introTypeEntity){
        return modelMapper.map(introTypeEntity, IntroTypeDTO.class);
    }
    //    Chuyen doi list
    public List<IntroTypeEntity> toEntities(List<IntroTypeDTO> introTypeDTOS){
        return introTypeDTOS.stream().map(introTypeDTO -> modelMapper.map(introTypeDTO, IntroTypeEntity.class)).collect(Collectors.toList());
    }
    public List<IntroTypeDTO> toDTOS(List<IntroTypeEntity> introTypeEntities){
        return introTypeEntities.stream().map(introTypeEntity -> modelMapper.map(introTypeEntity, IntroTypeDTO.class)).collect(Collectors.toList());
    }
}
