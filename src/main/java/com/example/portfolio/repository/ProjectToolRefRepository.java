package com.example.portfolio.repository;

import com.example.portfolio.entity.DomainEntity;
import com.example.portfolio.entity.ProjectLanguageRefEntity;
import com.example.portfolio.entity.ProjectToolRefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectToolRefRepository extends JpaRepository<ProjectToolRefEntity, Integer> {
    Optional<List<ProjectToolRefEntity>> findByProjectId(Integer projectId);
    Optional<List<ProjectToolRefEntity>> findByToolId(Integer toolId);
}
