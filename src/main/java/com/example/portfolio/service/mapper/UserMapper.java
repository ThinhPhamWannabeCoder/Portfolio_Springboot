package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.UserEntity;
import com.example.portfolio.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;

    //    Tra ve 1 ket qua duy nhat
//    DTO
    public UserDTO toDTO(UserEntity user){
        return modelMapper.map(user, UserDTO.class);
    }
    //    USER
    public UserEntity toEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

    //    Tra ve 1 List
    public List<UserDTO> toDTOS(List<UserEntity> users){
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }
    public List<UserEntity> toEntities(List<UserDTO> userDTOS){
        return userDTOS.stream().map(userDTO -> modelMapper.map(userDTO, UserEntity.class)).collect(Collectors.toList());
    }
}
