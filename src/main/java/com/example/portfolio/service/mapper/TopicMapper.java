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
    private final DomainMapper domainMapper;
    public TopicEntity toEntity(TopicDTO topicDTO){
        TopicEntity entity = modelMapper.map(topicDTO, TopicEntity.class);
        entity.setDomain(domainMapper.toEntity(topicDTO.getDomainDTO()));
        return entity;
    }
    public TopicDTO toDTO(TopicEntity topicEntity){
        TopicDTO dto = modelMapper.map(topicEntity, TopicDTO.class);
        dto.setDomainDTO(domainMapper.toDTO(topicEntity.getDomain()));
        return dto;
    }
    //    Chuyen doi list
    public List<TopicEntity> toEntities(List<TopicDTO> topicDTOS){
        return topicDTOS.stream().map(topicDTO -> {
            TopicEntity entity = modelMapper.map(topicDTO, TopicEntity.class);
            entity.setDomain(domainMapper.toEntity(topicDTO.getDomainDTO()));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<TopicDTO> toDTOS(List<TopicEntity> topicEntitiesics){
        return topicEntitiesics.stream().map(topicEntity -> {
            TopicDTO dto = modelMapper.map(topicEntity, TopicDTO.class);
            dto.setDomainDTO(domainMapper.toDTO(topicEntity.getDomain()));
            return dto;
        }).collect(Collectors.toList());
    }
}
