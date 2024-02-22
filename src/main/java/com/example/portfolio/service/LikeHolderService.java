package com.example.portfolio.service;

import com.example.portfolio.repository.LikeHolderRepository;
import com.example.portfolio.service.dto.LikeHolderDTO;
import com.example.portfolio.service.mapper.LikeHolderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LikeHolderService {
    private final LikeHolderRepository likeHolderRepository;
    private final LikeHolderMapper likeHolderMapper;
    public List<LikeHolderDTO> getAll(){
        return likeHolderMapper.toDTOS(likeHolderRepository.findAll());
    }
//    public List<LikeHolderDTO> getByTopicName(String){
//
//    }
}
