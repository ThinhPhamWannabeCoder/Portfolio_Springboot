package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.LikeHolderEntity;
import com.example.portfolio.service.dto.LikeHolderDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LikeHolderMapper {
    private final ModelMapper modelMapper;
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    public LikeHolderEntity toEntity(LikeHolderDTO likeHolderDTO){
        LikeHolderEntity entity = modelMapper.map(likeHolderDTO, LikeHolderEntity.class);
        entity.setUser(userMapper.toEntity(likeHolderDTO.getUserDTO()));
        entity.setPost(postMapper.toEntity(likeHolderDTO.getPostDTO()));
        return entity;
    }
    public LikeHolderDTO toDTO(LikeHolderEntity likeHolderEntity){
        LikeHolderDTO dto = modelMapper.map(likeHolderEntity, LikeHolderDTO.class);
        dto.setUserDTO(userMapper.toDTO(likeHolderEntity.getUser()));
        dto.setPostDTO(postMapper.toDTO(likeHolderEntity.getPost()));
        return dto;
    }
    //    Chuyen doi list
    public List<LikeHolderEntity> toEntities(List<LikeHolderDTO> likeHolderDTOS){
        return likeHolderDTOS.stream().map(likeHolderDTO -> {
            LikeHolderEntity entity = modelMapper.map(likeHolderDTO, LikeHolderEntity.class);
            entity.setUser(userMapper.toEntity(likeHolderDTO.getUserDTO()));
            entity.setPost(postMapper.toEntity(likeHolderDTO.getPostDTO()));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<LikeHolderDTO> toDTOS(List<LikeHolderEntity> likeHolderEntities){
        return likeHolderEntities.stream().map(likeHolderEntity -> {
            LikeHolderDTO dto = modelMapper.map(likeHolderEntity, LikeHolderDTO.class);
            dto.setUserDTO(userMapper.toDTO(likeHolderEntity.getUser()));
            dto.setPostDTO(postMapper.toDTO(likeHolderEntity.getPost()));
            return dto;
        }).collect(Collectors.toList());
    }
}
