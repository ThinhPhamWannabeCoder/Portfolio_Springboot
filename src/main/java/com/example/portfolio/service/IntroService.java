package com.example.portfolio.service;

import com.example.portfolio.entity.IntroEntity;
import com.example.portfolio.form.request.FormIntro;
import com.example.portfolio.form.request.FormIntroFilter;
import com.example.portfolio.repository.*;
import com.example.portfolio.service.dto.IntroDTO;
import com.example.portfolio.service.mapper.IntroMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.standard.expression.Fragment;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IntroService {
    private final IntroRepository introRepository;
    private final IntroMapper introMapper;
    private final IntroPlaceRepository introPlaceRepository;
    private final IntroTypeRepository introTypeRepository;
    private final IntroTopicRepository introTopicRepository;
    public List<IntroDTO> getAll(){
        return introMapper.toDTOS(introRepository.findAll());
    }
//    public List<IntroDTO> getByTopicName(String){
//
//    }
    public IntroDTO getById(Integer id){
    return introMapper.toDTO(introRepository.findById(id).orElse(null));
}

    public List<IntroDTO> getAllByIntroTopicId(Integer topicId){
        return introMapper.toDTOS(introRepository.findByIntroTopicId(topicId).orElseThrow(() -> new EntityNotFoundException("Loi tai IntroTopic")));

    }
    public List<IntroDTO> getAllByIntroPlaceId(Integer placeId){
        return introMapper.toDTOS(introRepository.findByIntroPlaceId(placeId).orElseThrow(()-> new EntityNotFoundException("Loi tai IntroPlace")));
    }
    public List<IntroDTO> getAllByIntroTypeId(Integer typeId){
        return  introMapper.toDTOS(introRepository.findByIntroTypeId(typeId).orElseThrow(()-> new EntityNotFoundException("Loi tai IntroType")));
    }
    public List<IntroDTO> getAllByTopicIdPlaceIdTypeId(FormIntroFilter request){
        return introMapper.toDTOS(introRepository.findByIntroTopicIdAndIntroTypeIdAndIntroPlaceId(
                request.getTopicId(),
                request.getTypeId(),
                request.getPlaceId()
        ).orElseThrow(()-> new EntityNotFoundException("Loi tai Filter")));
    }
    @Transactional
    public boolean deleteById(Integer id){
        try{
            introRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong xoa duoc thong tin intro" + e.getMessage());
            return false;
        }
    }
    @Transactional
    public boolean create(FormIntro request){
        try{
            introRepository.save(introMapper.formToEntity(request));
            return true;
        }
        catch(Exception e){
            System.out.println("Khong save dc thong tin intro" + e.getMessage());
            return false;
        }
    }
    @Transactional
    public  boolean update(Integer id,FormIntro dto){
        try {
            IntroEntity entity = introRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Khong tim duoc Intro theo id da cho"));

            entity.setIntroType(introTypeRepository.findById(dto.getTypeId()).orElseThrow(()-> new EntityNotFoundException("Khomg tim duoc introType theo id da cho")));
            entity.setIntroTopic(introTopicRepository.findById(dto.getTopicId()).orElseThrow(()-> new EntityNotFoundException("Khomg tim duoc introTopic theo id da cho")));
            entity.setIntroPlace(introPlaceRepository.findById(dto.getPlaceId()).orElseThrow(()-> new EntityNotFoundException("Khomg tim duoc introPlace theo id da cho")));
            entity.setDesc(dto.getDesc());

            introRepository.save(entity);
            return true;
        }
        catch (Exception e){
            System.out.println("Failed to update Intro" + e.getMessage());
            return false;
        }
    }
}
