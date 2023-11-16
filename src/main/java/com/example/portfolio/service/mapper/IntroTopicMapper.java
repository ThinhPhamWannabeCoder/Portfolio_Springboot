package com.example.portfolio.service.mapper;


import com.example.portfolio.entity.IntroTopicEntity;
import com.example.portfolio.service.dto.IntroTopicDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class IntroTopicMapper {
    private final ModelMapper modelMapper;
    public IntroTopicEntity toEntity(IntroTopicDTO introTopicDTO){
        return modelMapper.map(introTopicDTO, IntroTopicEntity.class);
    }
    public IntroTopicDTO toDTO(IntroTopicEntity introTopicEntity){
        return modelMapper.map(introTopicEntity, IntroTopicDTO.class);
    }
    //    Chuyen doi list
    public List<IntroTopicEntity> toEntities(List<IntroTopicDTO> introTopicDTOS){
        return introTopicDTOS.stream().map(introTopicDTO -> modelMapper.map(introTopicDTO, IntroTopicEntity.class)).collect(Collectors.toList());
    }
    public List<IntroTopicDTO> toDTOS(List<IntroTopicEntity> introTopicEntities){
        return introTopicEntities.stream().map(introTopicEntity -> modelMapper.map(introTopicEntity, IntroTopicDTO.class)).collect(Collectors.toList());
    }
}
