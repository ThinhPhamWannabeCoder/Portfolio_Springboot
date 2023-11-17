package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.AboutEntity;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.service.dto.AboutDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AboutMapper {
    private final ModelMapper modelMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public AboutEntity toEntity(AboutDTO aboutDTO){
        AboutEntity entity = modelMapper.map(aboutDTO, AboutEntity.class);
        entity.setUser(userRepository.findById(aboutDTO.getUserId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc thong tin user theo Id da cho")));
        return entity;
    }
    public AboutDTO toDTO(AboutEntity aboutEntity){
        AboutDTO dto = modelMapper.map(aboutEntity, AboutDTO.class);
        dto.setUserId(aboutEntity.getUser().getId());
        return dto;
    }
    //    Chuyen doi list
    public List<AboutEntity> toEntities(List<AboutDTO> aboutDTOS){
        return aboutDTOS.stream().map(aboutDTO -> {
            AboutEntity entity = modelMapper.map(aboutDTO, AboutEntity.class);
            entity.setUser(userRepository.findById(aboutDTO.getUserId()).orElseThrow(() -> new EntityNotFoundException("Khong tim duoc thong tin user theo Id da cho")));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<AboutDTO> toDTOS(List<AboutEntity> aboutEntities){
        return aboutEntities.stream().map(aboutEntity -> {
            AboutDTO dto = modelMapper.map(aboutEntity, AboutDTO.class);
            dto.setUserId(aboutEntity.getUser().getId());
            return dto;
        }).collect(Collectors.toList());
    }
}
