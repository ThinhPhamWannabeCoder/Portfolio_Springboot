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
    public IntroTypeDTO getByName(String typeName){
        return introTypeMapper.toDTO(introTypeRepository.findByName(typeName).orElse(null));
    }
    public IntroTypeDTO getById(Integer id){
        return introTypeMapper.toDTO(introTypeRepository.findById(id).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            introTypeRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin intro type theo id" + e.getMessage());
            return false;
        }

    }
    public boolean deleteByName(String name){
        try{
            introTypeRepository.deleteByName(name);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin intro type theo name" + e.getMessage());
            return false;
        }
    }
    public boolean create(IntroTypeDTO introTypeDTO){
        try{
            introTypeRepository.save(introTypeMapper.toEntity(introTypeDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro type" + e.getMessage());
            return false;
        }
    }
}
