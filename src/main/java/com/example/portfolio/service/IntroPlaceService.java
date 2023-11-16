package com.example.portfolio.service;

import com.example.portfolio.repository.IntroPlaceRepository;
import com.example.portfolio.service.dto.IntroPlaceDTO;
import com.example.portfolio.service.mapper.IntroPlaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IntroPlaceService {
    private final IntroPlaceRepository introPlaceRepository;
    private final IntroPlaceMapper introPlaceMapper;
    public List<IntroPlaceDTO> getAll(){
        return introPlaceMapper.toDTOS(introPlaceRepository.findAll());
    }
//    public List<IntroPlaceDTO> getByTopicName(String){
//
//    }
    public IntroPlaceDTO getByName(String placeName){
        return introPlaceMapper.toDTO(introPlaceRepository.findByName(placeName).orElse(null));
    }
}
