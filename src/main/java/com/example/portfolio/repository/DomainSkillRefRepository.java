package com.example.portfolio.repository;

import com.example.portfolio.entity.DomainSkillRefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DomainSkillRefRepository extends JpaRepository<DomainSkillRefEntity, Integer> {
    Optional<List<DomainSkillRefEntity>> findByDomainId(Integer domainId);
    Optional<List<DomainSkillRefEntity>> findBySkillId(Integer SkillId);

}
