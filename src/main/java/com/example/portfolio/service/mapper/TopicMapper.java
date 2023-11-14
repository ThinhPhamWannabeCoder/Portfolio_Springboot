package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.TopicEntity;
import com.example.portfolio.service.dto.TopicDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TopicMapper {
    private final ModelMapper modelMapper;
    public TopicEntity toEntity(TopicDTO TopicDTO){
        return modelMapper.map(TopicDTO, TopicEntity.class);
    }
    public TopicDTO toDTO(TopicEntity Topic){
        return modelMapper.map(Topic, TopicDTO.class);
    }
    //    Chuyen doi list
    public List<TopicEntity> toEntities(List<TopicDTO> TopicDTOS){
        return TopicDTOS.stream().map(TopicDTO -> modelMapper.map(TopicDTO, TopicEntity.class)).collect(Collectors.toList());
    }
    public List<TopicDTO> toDTOS(List<TopicEntity> Topics){
        return Topics.stream().map(Topic -> modelMapper.map(Topic, TopicDTO.class)).collect(Collectors.toList());
    }
}
