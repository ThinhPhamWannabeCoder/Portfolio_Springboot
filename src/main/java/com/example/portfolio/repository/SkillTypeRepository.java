package com.example.portfolio.repository;

import com.example.portfolio.entity.DomainEntity;
import com.example.portfolio.entity.ProjectToolRefEntity;
import com.example.portfolio.entity.SkillTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillTypeRepository extends JpaRepository<SkillTypeEntity, Integer> {

}
