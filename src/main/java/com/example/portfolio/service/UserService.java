package com.example.portfolio.service;

import com.example.portfolio.entity.RoleEntity;
import com.example.portfolio.entity.UserEntity;
import com.example.portfolio.entity.UserRoleEntity;
import com.example.portfolio.repository.RoleRepository;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.repository.UserRoleRepository;
import com.example.portfolio.service.dto.UserDTO;
import com.example.portfolio.service.dto.UserRoleDTO;
import com.example.portfolio.service.mapper.UserMapper;
import com.example.portfolio.service.mapper.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public UserDTO getById(Integer userId){
        return userMapper.toDTO(userRepository.findById(userId).orElse(null));
    }
    public UserDTO getByEmail(String email ){
        return userMapper.toDTO(userRepository.findByEmail(email).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin user theo id" + e.getMessage());
            return false;
        }
    }
    public boolean deleteByEmail(String email){
        try{
            userRepository.deleteByEmail(email);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin user theo email" + e.getMessage());
            return false;
        }
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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(email));
        return new User(userEntity.getEmail(),
                userEntity.getPassword(),
                mapRolesToAuthorities(userEntity.getUserroleList().stream().map(userRoleEntity -> userRoleEntity.getRole()).collect(Collectors.toList())));
    }
    private List<GrantedAuthority> mapRolesToAuthorities(List<RoleEntity> roleEntities){
        return roleEntities.stream().map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getName())).collect(Collectors.toList());
    }
}
