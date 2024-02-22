package com.example.portfolio.repository;
import com.example.portfolio.entity.IntroTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntroTopicRepository extends JpaRepository<IntroTopicEntity, Integer> {
    Optional<IntroTopicEntity> findByName(String placeName);
    void deleteByName(String name);
}
