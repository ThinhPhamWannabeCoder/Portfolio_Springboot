package com.example.portfolio.repository;

import com.example.portfolio.entity.DomainEntity;
import com.example.portfolio.entity.SkillEntity;
import com.example.portfolio.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {
    Optional<List<TopicEntity>> findByDomainId(Integer domainId);

    TopicEntity findByName(String name);

    void deleteByName(String name);
}
