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
    private final TopicRepository TopicRepository;
    private final TopicMapper TopicMapper;

    public List<TopicDTO> getAll(){
        return TopicMapper.toDTOS(TopicRepository.findAll());
    }
    public List<TopicDTO> getByDomainId(Integer domainId){
        return TopicMapper.toDTOS(TopicRepository.findByDomainId(domainId).orElse(null));
    }
}
