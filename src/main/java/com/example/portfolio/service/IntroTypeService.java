package com.example.portfolio.service;

import com.example.portfolio.repository.IntroTypeRepository;
import com.example.portfolio.service.dto.IntroTypeDTO;
import com.example.portfolio.service.mapper.IntroTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IntroTypeService {
    private final IntroTypeRepository introTypeRepository ;
    private final IntroTypeMapper introTypeMapper;
    public List<IntroTypeDTO> getAll(){
        return introTypeMapper.toDTOS(introTypeRepository.findAll());
    }
//    public List<IntroTypeDTO> getByTopicName(String){
//
//    }
}
