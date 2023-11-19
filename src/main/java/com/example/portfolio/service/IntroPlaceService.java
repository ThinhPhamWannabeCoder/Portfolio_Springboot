package com.example.portfolio.service;

import com.example.portfolio.entity.IntroPlaceEntity;
import com.example.portfolio.repository.IntroPlaceRepository;
import com.example.portfolio.repository.IntroRepository;
import com.example.portfolio.service.dto.IntroPlaceDTO;
import com.example.portfolio.service.mapper.IntroPlaceMapper;
import jakarta.persistence.EntityNotFoundException;
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
    public IntroPlaceDTO getById(Integer id){
        return introPlaceMapper.toDTO(introPlaceRepository.findById(id).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            introPlaceRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin intro place theo id" + e.getMessage());
            return false;
        }
    }
    public boolean deleteByName(String name){
        try{
            introPlaceRepository.deleteByName(name);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin intro place theo name" + e.getMessage());
            return false;
        }
    }
    public boolean create(IntroPlaceDTO introPlaceDTO){
        try{
            introPlaceRepository.save(introPlaceMapper.toEntity(introPlaceDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro place" + e.getMessage());
            return false;
        }
    }
    public boolean update(Integer id,IntroPlaceDTO dto){
        try{
            IntroPlaceEntity entity = introPlaceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc thong tin introPlace voi id da cho"));
            entity.setName(dto.getName());
            introPlaceRepository.save(entity);
            return true;
        }
        catch (Exception e){
            System.out.println("Failed to update Introplace " +e.getMessage());
            return false;
        }
    }
}
