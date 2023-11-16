package com.example.portfolio.service;

import com.example.portfolio.repository.PostRepository;
import com.example.portfolio.service.dto.PostDTO;
import com.example.portfolio.service.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    public List<PostDTO> getAll(){
        return postMapper.toDTOS(postRepository.findAll());
    }
//    public List<PostDTO> getByTopicName(String){
//
//    }
}
