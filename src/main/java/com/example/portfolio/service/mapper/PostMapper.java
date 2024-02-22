package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.PostEntity;
import com.example.portfolio.service.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostMapper {
    private final ModelMapper modelMapper;
    private final UserMapper userMapper;
    private final ProjectMapper projectMapper;

    public PostEntity toEntity(PostDTO postDTO){
        PostEntity entity = modelMapper.map(postDTO, PostEntity.class);
        entity.setUser(userMapper.toEntity(postDTO.getUserDTO()));
        entity.setProject(projectMapper.toEntity(postDTO.getProjectDTO()));
        return entity;
    }
    public PostDTO toDTO(PostEntity postEntity){
        PostDTO dto  = modelMapper.map(postEntity, PostDTO.class);
        dto.setUserDTO(userMapper.toDTO(postEntity.getUser()));
        dto.setProjectDTO(projectMapper.toDTO(postEntity.getProject()));
        return dto;
    }
    //    Chuyen doi list
    public List<PostEntity> toEntities(List<PostDTO> postDTOS){
        return postDTOS.stream().map(postDTO -> {
            PostEntity entity = modelMapper.map(postDTO, PostEntity.class);
            entity.setUser(userMapper.toEntity(postDTO.getUserDTO()));
            entity.setProject(projectMapper.toEntity(postDTO.getProjectDTO()));
            return entity;
        }).collect(Collectors.toList());
    }
    public List<PostDTO> toDTOS(List<PostEntity> postEntities){
        return postEntities.stream().map(postEntity -> {
            PostDTO dto  = modelMapper.map(postEntity, PostDTO.class);
            dto.setUserDTO(userMapper.toDTO(postEntity.getUser()));
            dto.setProjectDTO(projectMapper.toDTO(postEntity.getProject()));
            return dto;
        }).collect(Collectors.toList());
    }
}
