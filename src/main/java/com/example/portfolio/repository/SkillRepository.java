package com.example.portfolio.repository;

import com.example.portfolio.entity.DomainEntity;
import com.example.portfolio.entity.ProjectToolRefEntity;
import com.example.portfolio.entity.SkillEntity;
import com.example.portfolio.entity.SkillTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Integer> {
    Optional<List<SkillEntity>> findBySkillTypeId(Integer SkillTypeId);

    void deleteByName(String name);

    Optional<SkillEntity> findByName(String name);
}
