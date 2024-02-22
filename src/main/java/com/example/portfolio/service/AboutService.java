package com.example.portfolio.service;

import com.example.portfolio.repository.AboutRepository;
import com.example.portfolio.service.dto.AboutDTO;
import com.example.portfolio.service.mapper.AboutMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutService {
    private final AboutRepository aboutRepository;
    private final AboutMapper aboutMapper;
    public List<AboutDTO> getAll(){
        return aboutMapper.toDTOS(aboutRepository.findAll());
    }
//    public List<AboutDTO> getByTopicName(String){
//
//    }
    public AboutDTO getById(Integer id){
        return aboutMapper.toDTO(aboutRepository.findById(id).orElse(null));
    }
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

    public boolean create(AboutDTO aboutDTO){
        try{
            aboutRepository.save(aboutMapper.toEntity(aboutDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin intro place" + e.getMessage());
            return false;
        }
    }
}
