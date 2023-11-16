package com.example.portfolio.service;

import com.example.portfolio.repository.IntroTopicRepository;
import com.example.portfolio.service.dto.IntroTopicDTO;
import com.example.portfolio.service.mapper.IntroTopicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IntroTopicService {
    private final IntroTopicRepository introTopicRepository;
    private final IntroTopicMapper introTopicMapper;
    public List<IntroTopicDTO> getAll(){
        return introTopicMapper.toDTOS(introTopicRepository.findAll());
    }
//    public List<IntroTopicDTO> getByTopicName(String){
//
//    }
}
