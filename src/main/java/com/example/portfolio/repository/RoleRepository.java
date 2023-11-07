package com.example.portfolio.repository;

import com.example.portfolio.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByName(String name);
}
