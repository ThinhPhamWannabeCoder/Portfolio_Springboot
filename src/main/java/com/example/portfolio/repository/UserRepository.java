package com.example.portfolio.repository;

import com.example.portfolio.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);


    boolean existsByEmail(String email);

    void deleteByEmail(String email);
}
