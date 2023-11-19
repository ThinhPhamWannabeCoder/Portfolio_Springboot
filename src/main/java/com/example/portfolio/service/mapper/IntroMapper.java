package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.IntroEntity;
import com.example.portfolio.form.request.FormIntro;
import com.example.portfolio.repository.IntroPlaceRepository;
import com.example.portfolio.repository.IntroTopicRepository;
import com.example.portfolio.repository.IntroTypeRepository;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.service.dto.IntroDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class IntroMapper {
    private final ModelMapper modelMapper;
    private final IntroPlaceMapper introPlaceMapper;
    private final IntroTopicMapper introTopicMapper;
    private final IntroTypeMapper introTypeMapper;
    private final UserRepository userRepository;
    private final IntroPlaceRepository introPlaceRepository;
    private final IntroTopicRepository introTopicRepository;
    private final IntroTypeRepository introTypeRepository;


    public IntroEntity formToEntity(FormIntro dto){
        IntroEntity entity =  modelMapper.map(dto, IntroEntity.class);
        entity.setUser(userRepository.findById(dto.getUserId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc thong tin user theo Id da cho")));
        entity.setIntroPlace(introPlaceRepository.findById(dto.getPlaceId()).orElseThrow(()-> new EntityNotFoundException("Failed to get place")));
        entity.setIntroTopic(introTopicRepository.findById(dto.getTopicId()).orElseThrow(()-> new EntityNotFoundException("Failed to get place")));
        entity.setIntroType(introTypeRepository.findById(dto.getTypeId()).orElseThrow(()-> new EntityNotFoundException("Failed to get place")));
        return entity;
    }

    public IntroEntity toEntity(IntroDTO introDTO){
        IntroEntity entity =  modelMapper.map(introDTO, IntroEntity.class);
        entity.setUser(userRepository.findById(introDTO.getUserId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc thong tin user theo Id da cho")));
        entity.setIntroPlace(introPlaceMapper.toEntity(introDTO.getIntroPlaceDTO()));
        entity.setIntroTopic(introTopicMapper.toEntity(introDTO.getIntroTopicDTO()));
        entity.setIntroType(introTypeMapper.toEntity(introDTO.getIntroTypeDTO()));
        return entity;
    }
    public IntroDTO toDTO(IntroEntity introEntity){
        IntroDTO dto = modelMapper.map(introEntity, IntroDTO.class);
        dto.setUserId(introEntity.getUser().getId());
        dto.setIntroPlaceDTO(introPlaceMapper.toDTO(introEntity.getIntroPlace()));
        dto.setIntroTopicDTO(introTopicMapper.toDTO(introEntity.getIntroTopic()));
        dto.setIntroTypeDTO(introTypeMapper.toDTO(introEntity.getIntroType()));

        return dto;
    }
    //    Chuyen doi list
    public List<IntroEntity> toEntities(List<IntroDTO> introDTOS){
        return introDTOS.stream().map(introDTO -> {
            IntroEntity entity = modelMapper.map(introDTO, IntroEntity.class);
            entity.setUser(userRepository.findById(introDTO.getUserId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc thong tin user theo Id da cho")));
            entity.setIntroPlace(introPlaceMapper.toEntity(introDTO.getIntroPlaceDTO()));
            entity.setIntroTopic(introTopicMapper.toEntity(introDTO.getIntroTopicDTO()));
            entity.setIntroType(introTypeMapper.toEntity(introDTO.getIntroTypeDTO()));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<IntroDTO> toDTOS(List<IntroEntity> introEntities){
        return introEntities.stream().map(introEntity -> {
            IntroDTO dto = modelMapper.map(introEntity, IntroDTO.class);
            dto.setUserId(introEntity.getUser().getId());
            dto.setIntroPlaceDTO(introPlaceMapper.toDTO(introEntity.getIntroPlace()));
            dto.setIntroTopicDTO(introTopicMapper.toDTO(introEntity.getIntroTopic()));
            dto.setIntroTypeDTO(introTypeMapper.toDTO(introEntity.getIntroType()));
            return dto;
        }).collect(Collectors.toList());
    }
}
