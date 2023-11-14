package com.example.portfolio.repository;

import com.example.portfolio.entity.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<DomainEntity, Integer> {

}
