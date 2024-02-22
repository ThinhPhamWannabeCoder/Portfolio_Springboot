package com.example.portfolio.service;

import com.example.portfolio.form.request.FormIntroFilter;
import com.example.portfolio.repository.IntroRepository;
import com.example.portfolio.service.dto.IntroDTO;
import com.example.portfolio.service.mapper.IntroMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IntroService {
    private final IntroRepository introRepository;
    private final IntroMapper introMapper;
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
    public boolean create(IntroDTO introDTO){
        try{
            introRepository.save(introMapper.toEntity(introDTO));
            return true;
        }
        catch(Exception e){
            System.out.println("Khong save dc thong tin intro" + e.getMessage());
            return false;
        }
    }
}
