package com.example.portfolio.repository;
import com.example.portfolio.entity.IntroTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroTypeRepository extends JpaRepository<IntroTypeEntity, Integer>{

}
