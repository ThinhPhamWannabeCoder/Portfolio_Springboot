package com.example.portfolio.service;

import com.example.portfolio.repository.DomainRepository;
import com.example.portfolio.service.dto.DomainDTO;
import com.example.portfolio.service.mapper.DomainMapper;
import jakarta.persistence.EntityNotFoundException;
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
    public DomainDTO getByDomainName(String name){
        return domainMapper.toDTO(domainRepository.findByName(name).orElseThrow(()-> new EntityNotFoundException("Không tìm được domain name")));
    }
    public DomainDTO getByDomainId(Integer domainId){
        return domainMapper.toDTO(domainRepository.findById(domainId).orElseThrow(()-> new EntityNotFoundException("Không tìm được domain name")));
    }
}
