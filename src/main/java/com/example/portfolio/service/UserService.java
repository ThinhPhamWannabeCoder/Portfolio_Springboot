package com.example.portfolio.service;

import com.example.portfolio.repository.RoleRepository;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.repository.UserRoleRepository;
import com.example.portfolio.service.dto.UserDTO;
import com.example.portfolio.service.mapper.UserMapper;
import com.example.portfolio.service.mapper.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userroleRepository;
    private final UserMapper userMapper;
    private final UserRoleMapper user_roleMapper;

    public List<UserDTO> getAll(){
        List<UserDTO>  userDTOList = userMapper.toDTOS(userRepository.findAll());
        return userDTOList;
    }
    public UserDTO getById(int user_id){
        return userMapper.toDTO(userRepository.findById(user_id).orElse(null));

    }
    public boolean create(UserDTO userDTO){
        try{
            userRepository.save(userMapper.toEntity(userDTO));
            return true;
        }
        catch(Exception e){
            System.out.println("Loi tai day nay" + e);
            return false;
        }

    }
}
