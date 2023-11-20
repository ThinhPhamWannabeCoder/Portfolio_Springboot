package com.example.portfolio.service;

import com.example.portfolio.repository.TopicRepository;
import com.example.portfolio.service.dto.TopicDTO;
import com.example.portfolio.service.mapper.TopicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    public TopicDTO getById(Integer id){
        return topicMapper.toDTO(topicRepository.findById(id).orElse(null));
    }

    public List<TopicDTO> getAll(){
        return topicMapper.toDTOS(topicRepository.findAll());
    }
    public List<TopicDTO> getAllByDomainId(Integer domainId){
        return topicMapper.toDTOS(topicRepository.findByDomainId(domainId).orElse(null));
    }
}
