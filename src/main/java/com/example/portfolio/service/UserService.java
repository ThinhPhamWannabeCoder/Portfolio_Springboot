package com.example.portfolio.service;

import com.example.portfolio.entity.RoleEntity;
import com.example.portfolio.entity.UserEntity;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.service.dto.UserDTO;
import com.example.portfolio.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;

    private final UserMapper userMapper;

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
            userEntity.setRole(RoleEntity.USER);
            userRepository.save(userEntity);
            return true;
        }
        catch (Exception e){
            System.out.println("DCMM");
            return false;
        }

    }
//    public boolean create(UserDTO userDTO){
//
//        try{
//            UserEntity userEntity = userMapper.toEntity(userDTO);
//            userRepository.save(userEntity);
//            Integer userId = userEntity.getId();
//            if (userId != null){
//                UserRoleDTO user_roleDTO = new UserRoleDTO();
//                user_roleDTO.setUser_id(userId); //phai kiem tra la co khong da
//                user_roleDTO.setRole_id(roleRepository.findByName("USER").get().getId());
//
//                UserRoleEntity userrole = user_roleMapper.toEntity(user_roleDTO);
//                userroleRepository.save(userrole);
//
//                List<UserRoleEntity> list = new ArrayList<>();
//                if (userrole!= null){
//                    list.add(userrole);
//                    userEntity.setUserroleList(list);
//                    userRepository.save(userEntity);
//                }
//                else {
//                    return false;
//                }
//            }
//
//            return true;
//        }
//        catch(Exception e){
//            System.out.println("Loi tai day nay" + e);
//            return false;
//        }

//    }
    public boolean exists(String email){
        return userRepository.existsByEmail(email);
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(email));
//        return new User(userEntity.getEmail(),
//                userEntity.getPassword(),
//                mapRolesToAuthorities(userEntity.getUserroleList().stream().map(userRoleEntity -> userRoleEntity.getRole()).collect(Collectors.toList())));
//    }
//    private List<GrantedAuthority> mapRolesToAuthorities(List<RoleEntity> roleEntities){
//        return roleEntities.stream().map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getName())).collect(Collectors.toList());
//    }
}
