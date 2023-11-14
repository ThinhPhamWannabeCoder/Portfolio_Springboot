package com.example.portfolio.repository;

import com.example.portfolio.entity.DomainEntity;
import com.example.portfolio.entity.DomainSkillRefEntity;
import com.example.portfolio.entity.ProjectLanguageRefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectLanguageRefRepository extends JpaRepository<ProjectLanguageRefEntity, Integer> {
    Optional<List<ProjectLanguageRefEntity>> findByProjectId(Integer projectId);
    Optional<List<ProjectLanguageRefEntity>> findByLanguageId(Integer languageId);
}
