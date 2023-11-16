package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.IntroPlaceEntity;
import com.example.portfolio.service.dto.IntroPlaceDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class IntroPlaceMapper {
    private final ModelMapper modelMapper;
    public IntroPlaceEntity toEntity(IntroPlaceDTO introPlaceDTO){
        return modelMapper.map(introPlaceDTO, IntroPlaceEntity.class);
    }
    public IntroPlaceDTO toDTO(IntroPlaceEntity introPlaceEntity){
        return modelMapper.map(introPlaceEntity, IntroPlaceDTO.class);
    }
    //    Chuyen doi list
    public List<IntroPlaceEntity> toEntities(List<IntroPlaceDTO> introPlaceDTOS){
        return introPlaceDTOS.stream().map(introPlaceDTO -> modelMapper.map(introPlaceDTO, IntroPlaceEntity.class)).collect(Collectors.toList());
    }
    public List<IntroPlaceDTO> toDTOS(List<IntroPlaceEntity> introPlaceEntities){
        return introPlaceEntities.stream().map(introPlaceEntity -> modelMapper.map(introPlaceEntity, IntroPlaceDTO.class)).collect(Collectors.toList());
    }
}
