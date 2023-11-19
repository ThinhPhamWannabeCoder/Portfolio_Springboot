package com.example.portfolio.service;

import com.example.portfolio.entity.AboutEntity;
import com.example.portfolio.repository.AboutRepository;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.service.dto.AboutDTO;
import com.example.portfolio.service.mapper.AboutMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutService {
    private final AboutRepository aboutRepository;
    private final AboutMapper aboutMapper;
    private final UserRepository userRepository;
    public List<AboutDTO> getAll(){
        return aboutMapper.toDTOS(aboutRepository.findAll());
    }
//    public List<AboutDTO> getByTopicName(String){
//
//    }
    public AboutDTO getById(Integer id){
        return aboutMapper.toDTO(aboutRepository.findById(id).orElse(null));
    }
    @Transactional
    public boolean deleteById(Integer id){
        try{
            aboutRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin intro place theo id" + e.getMessage());
            return false;
        }
    }
    @Transactional
    public boolean create(AboutDTO aboutDTO){
        try{
            AboutEntity entity = aboutMapper.toEntity(aboutDTO);
            aboutRepository.save(entity);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro place" + e.getMessage());
            return false;
        }
    }
    @Transactional
    public boolean update(Integer id,AboutDTO dto){
        try{
            AboutEntity entity = aboutRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Khong tim duoc thong tin about entity"));
            entity.setUser(userRepository.findById(dto.getUserId()).orElseThrow(()-> new EntityNotFoundException("kHONG TIM DUOC USER THEO ID DA CHINH SUA")));
            entity.setType(dto.getType());
            entity.setHeader(dto.getHeader());
            entity.setTag_1(dto.getTag_1());
            entity.setTag_2(dto.getTag_2());
            entity.setDesc(dto.getDesc());
            entity.setDate(dto.getDate());
            aboutRepository.save(entity);
            return  true;
        }
        catch(Exception e){
            System.out.println(("Khong update duoc thong tin about" + e.getMessage()));
            return false;
        }
    }
}
