package com.example.portfolio.repository;
import com.example.portfolio.entity.IntroPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntroPlaceRepository extends JpaRepository<IntroPlaceEntity, Integer>{

    Optional<IntroPlaceEntity> findByName(String placeName);

    void deleteByName(String name);
}
