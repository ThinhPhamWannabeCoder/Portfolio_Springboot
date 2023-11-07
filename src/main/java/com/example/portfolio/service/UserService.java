package com.example.portfolio.service;

import com.example.portfolio.entity.UserEntity;
import com.example.portfolio.entity.UserRoleEntity;
import com.example.portfolio.repository.RoleRepository;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.repository.UserRoleRepository;
import com.example.portfolio.service.dto.UserDTO;
import com.example.portfolio.service.dto.UserRoleDTO;
import com.example.portfolio.service.mapper.UserMapper;
import com.example.portfolio.service.mapper.UserRoleMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
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
            UserEntity userEntity = userMapper.toEntity(userDTO);
            userRepository.save(userEntity);
            Integer userId = userEntity.getId();
            if (userId != null){
                UserRoleDTO user_roleDTO = new UserRoleDTO();
                user_roleDTO.setUser_id(userId); //phai kiem tra la co khong da
                user_roleDTO.setRole_id(roleRepository.findByName("USER").get().getId());

                UserRoleEntity userrole = user_roleMapper.toEntity(user_roleDTO);
                userroleRepository.save(userrole);

                List<UserRoleEntity> list = new ArrayList<>();
                if (userrole!= null){
                    list.add(userrole);
                    userEntity.setUserroleList(list);
                    userRepository.save(userEntity);
                }
                else {
                    return false;
                }
            }

            return true;
        }
        catch(Exception e){
            System.out.println("Loi tai day nay" + e);
            return false;
        }

    }
    public boolean exists(String email){
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
