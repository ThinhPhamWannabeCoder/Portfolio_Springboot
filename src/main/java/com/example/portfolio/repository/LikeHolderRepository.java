package com.example.portfolio.repository;

import com.example.portfolio.entity.LikeHolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeHolderRepository extends JpaRepository<LikeHolderEntity, Integer>{
}
