package com.example.portfolio.service;

import com.example.portfolio.entity.SkillTypeEntity;
import com.example.portfolio.entity.TopicEntity;
import com.example.portfolio.repository.DomainRepository;
import com.example.portfolio.repository.TopicRepository;
import com.example.portfolio.service.dto.SkillTypeDTO;
import com.example.portfolio.service.dto.TopicDTO;
import com.example.portfolio.service.mapper.DomainMapper;
import com.example.portfolio.service.mapper.TopicMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;
    private final DomainRepository domainRepository;

    public TopicDTO getById(Integer id){
        return topicMapper.toDTO(topicRepository.findById(id).orElse(null));
    }
    public TopicDTO getByName(String name){return topicMapper.toDTO(topicRepository.findByName(name));}
    public List<TopicDTO> getAll(){
        return topicMapper.toDTOS(topicRepository.findAll());
    }
    public List<TopicDTO> getAllByDomainId(Integer domainId){
        return topicMapper.toDTOS(topicRepository.findByDomainId(domainId).orElse(null));
    }
    public boolean deleteById(Integer id){
        try{
            topicRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin topic theo id" + e.getMessage());
            return false;
        }
    }
    public boolean deleteByName(String name){
        try{
            topicRepository.deleteByName(name);
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the xoa thong tin Topic theo name" + e.getMessage());
            return false;
        }
    }
    public boolean create(TopicDTO topicDTO){
        try{
            topicRepository.save(topicMapper.toEntity(topicDTO));
            return true;
        }
        catch (Exception e){
            System.out.println("Khong the luu thong tin topic" + e.getMessage());
            return false;
        }
    }
    public boolean update(Integer id,TopicDTO dto){
        try{
            TopicEntity entity  = topicRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Failed to find Topic by Id"));
            entity.setName(dto.getName());
            entity.setDesc(dto.getDesc());
            entity.setDomain(domainRepository.findById(dto.getDomainId()).orElseThrow(()-> new EntityNotFoundException("Failed to get Domain by Id")));

            topicRepository.save(entity);
            return true;
        }
        catch (Exception e){
            System.out.println("Failed to update Topic" + e.getMessage());
            return false;
        }
    }

}
