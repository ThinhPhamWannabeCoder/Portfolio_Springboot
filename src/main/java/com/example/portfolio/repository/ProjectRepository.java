package com.example.portfolio.repository;

import com.example.portfolio.entity.DomainEntity;
import com.example.portfolio.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {
    Optional<List<ProjectEntity>> findByTopicId(Integer topicId);

    void deleteByName(String name);

    Optional<ProjectEntity> findByName(String name);
}
