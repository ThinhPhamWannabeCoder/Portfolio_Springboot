package com.example.portfolio.service;

import com.example.portfolio.entity.IntroTopicEntity;
import com.example.portfolio.repository.IntroTopicRepository;
import com.example.portfolio.service.dto.IntroTopicDTO;
import com.example.portfolio.service.mapper.IntroTopicMapper;
import jakarta.persistence.EntityNotFoundException;
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
    public IntroTopicDTO getByName(String topicName){
        return introTopicMapper.toDTO(introTopicRepository.findByName(topicName).orElse(null));
    }
    public IntroTopicDTO getById(Integer id){
        return introTopicMapper.toDTO(introTopicRepository.findById(id).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            introTopicRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin intro topic theo id" + e.getMessage());
            return false;
        }

    }
    public boolean deleteByName(String name){
        try{
            introTopicRepository.deleteByName(name);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin intro topic theo name" + e.getMessage());
            return false;
        }
    }
    public boolean create(IntroTopicDTO introTopicDTO){
        try{
            introTopicRepository.save(introTopicMapper.toEntity(introTopicDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro name" + e.getMessage());
            return false;
        }
    }
    public boolean update(Integer id, IntroTopicDTO dto){
        try{
            IntroTopicEntity entity = introTopicRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc thong tin introTopic voi id da cho"));
            entity.setName(dto.getName());
            introTopicRepository.save(entity);
            return true;
        }
        catch (Exception e){
            System.out.println("Failed to update IntroTopic " +e.getMessage());
            return false;
        }
    }
}
