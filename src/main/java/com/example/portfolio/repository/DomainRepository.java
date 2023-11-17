package com.example.portfolio.repository;

import com.example.portfolio.entity.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomainRepository extends JpaRepository<DomainEntity, Integer> {

    Optional<DomainEntity> findByName(String name);
}
