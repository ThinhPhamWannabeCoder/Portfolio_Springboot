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
    public DomainDTO getByName(String name){
        return domainMapper.toDTO(domainRepository.findByName(name).orElseThrow(()-> new EntityNotFoundException("Không tìm được domain name")));
    }
    public DomainDTO getById(Integer domainId){
        return domainMapper.toDTO(domainRepository.findById(domainId).orElseThrow(()-> new EntityNotFoundException("Không tìm được domain name")));
    }

    public boolean deleteById(Integer id){
        try{
            domainRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin doamain theo id" + e.getMessage());
            return false;
        }
    }
    public boolean deleteByName(String name){
        try{
            domainRepository.deleteByName(name);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin domain theo ten" + e.getMessage());
            return false;
        }
    }
    public boolean create(DomainDTO domainDTO){
        try{
            domainRepository.save(domainMapper.toEntity(domainDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin domain" + e.getMessage());
            return false;
        }
    }
}
