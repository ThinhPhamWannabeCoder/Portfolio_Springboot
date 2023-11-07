package com.example.portfolio.service.mapper;

import com.example.portfolio.entity.UserRoleEntity;
import com.example.portfolio.repository.RoleRepository;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.service.dto.UserRoleDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRoleMapper {
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private  final UserRepository userRepository;
    public UserRoleEntity toEntity(UserRoleDTO user_roleDTO){
        UserRoleEntity userrole =  modelMapper.map(user_roleDTO,  UserRoleEntity.class);
        userrole.setRole(roleRepository.findById(user_roleDTO.getRole_id()).orElseThrow(() -> new EntityNotFoundException("Khong tim thay Role co role_id" + user_roleDTO.getRole_id())));
        userrole.setUser(userRepository.findById(user_roleDTO.getUser_id()).orElseThrow(() -> new EntityNotFoundException("Khong tim thay User co user_id" + user_roleDTO.getUser_id())));
        return  userrole;
    }
    public UserRoleDTO toDTO(UserRoleEntity user_role){
        UserRoleDTO userroleDTO  = modelMapper.map(user_role, UserRoleDTO.class);
        userroleDTO.setRole_id(user_role.getRole().getId());
        userroleDTO.setUser_id(user_role.getUser().getId());
        return userroleDTO;
    }

    public List<UserRoleEntity> toEntities(List<UserRoleDTO> user_roleDTOS){
        return user_roleDTOS.stream().map(user_roleDTO -> {
            UserRoleEntity user_role = modelMapper.map(user_roleDTO, UserRoleEntity.class);
            user_role.setRole(roleRepository.findById(user_roleDTO.getRole_id()).orElseThrow(() -> new EntityNotFoundException("Khong tim thay Role co role_id" + user_roleDTO.getRole_id())));
            user_role.setUser(userRepository.findById(user_roleDTO.getUser_id()).orElseThrow(() -> new EntityNotFoundException("Khong tim thay User co user_id" + user_roleDTO.getUser_id())));
            return user_role;
        }).collect(Collectors.toList());
    }
    public  List<UserRoleDTO> toDTOS(List<UserRoleEntity> user_roles){
        return user_roles.stream().map(user_role -> {
                    UserRoleDTO user_roleDTO  = modelMapper.map(user_role, UserRoleDTO.class);
                    user_roleDTO.setRole_id(user_role.getRole().getId());
                    user_roleDTO.setUser_id(user_role.getUser().getId());
                    return user_roleDTO;
                }).collect(Collectors.toList());
    }
}
