package com.example.portfolio.service;

import com.example.portfolio.repository.DomainRepository;
import com.example.portfolio.service.dto.DomainDTO;
import com.example.portfolio.service.mapper.DomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainService {
    private final DomainRepository domainRepository;
    private final DomainMapper domainMapper;
    public List<DomainDTO> getAll(){
        return domainMapper.toDTOS(domainRepository.findAll());
    }
//    public List<DomainDTO> getByTopicName(String){
//
//    }
}
