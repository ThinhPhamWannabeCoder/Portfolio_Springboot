package com.example.portfolio.repository;
import com.example.portfolio.entity.AboutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<AboutEntity, Integer>{
}
