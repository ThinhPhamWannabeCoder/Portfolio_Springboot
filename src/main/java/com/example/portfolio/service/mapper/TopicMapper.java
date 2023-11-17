package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.TopicEntity;
import com.example.portfolio.repository.DomainRepository;
import com.example.portfolio.service.dto.TopicDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TopicMapper {
    private final ModelMapper modelMapper;
    private final DomainRepository domainRepository;
    public TopicEntity toEntity(TopicDTO topicDTO){
        TopicEntity entity = modelMapper.map(topicDTO, TopicEntity.class);
        entity.setDomain(domainRepository.findById(topicDTO.getId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc thong tin theo domain Id da cho")));
        return entity;
    }
    public TopicDTO toDTO(TopicEntity topicEntity){
        TopicDTO dto = modelMapper.map(topicEntity, TopicDTO.class);
        dto.setDomainId(topicEntity.getDomain().getId());
        return dto;
    }
    //    Chuyen doi list
    public List<TopicEntity> toEntities(List<TopicDTO> topicDTOS){
        return topicDTOS.stream().map(topicDTO -> {
            TopicEntity entity = modelMapper.map(topicDTO, TopicEntity.class);
            entity.setDomain(domainRepository.findById(topicDTO.getId()).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc thong tin theo domain Id da cho")));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<TopicDTO> toDTOS(List<TopicEntity> topicEntitiesics){
        return topicEntitiesics.stream().map(topicEntity -> {
            TopicDTO dto = modelMapper.map(topicEntity, TopicDTO.class);
            dto.setDomainId(topicEntity.getDomain().getId());
            return dto;
        }).collect(Collectors.toList());
    }
}
