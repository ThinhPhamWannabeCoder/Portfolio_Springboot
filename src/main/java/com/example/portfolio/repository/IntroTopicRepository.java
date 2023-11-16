package com.example.portfolio.repository;
import com.example.portfolio.entity.IntroTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroTopicRepository extends JpaRepository<IntroTopicEntity, Integer> {
}