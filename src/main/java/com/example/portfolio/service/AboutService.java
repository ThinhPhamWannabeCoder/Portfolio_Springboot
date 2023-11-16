package com.example.portfolio.service;

import com.example.portfolio.repository.AboutRepository;
import com.example.portfolio.service.dto.AboutDTO;
import com.example.portfolio.service.mapper.AboutMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutService {
    private final AboutRepository aboutRepository;
    private final AboutMapper aboutMapper;
    public List<AboutDTO> getAll(){
        return aboutMapper.toDTOS(aboutRepository.findAll());
    }
//    public List<AboutDTO> getByTopicName(String){
//
//    }
}
