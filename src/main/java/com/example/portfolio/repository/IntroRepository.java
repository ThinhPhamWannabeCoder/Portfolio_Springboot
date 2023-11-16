package com.example.portfolio.repository;
import com.example.portfolio.entity.DomainSkillRefEntity;
import com.example.portfolio.entity.IntroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntroRepository extends JpaRepository<IntroEntity, Integer>{
    Optional<List<IntroEntity>> findByIntroPlaceId(Integer introPlaceId);
    Optional<List<IntroEntity>> findByIntroTopicId(Integer introTopicId);
    Optional<List<IntroEntity>> findByIntroTypeId(Integer introTypeId);

    Optional<List<IntroEntity>> findByIntroTopicIdAndIntroTypeIdAndIntroPlaceId(
            Integer introTopicId, Integer introTypeId, Integer introPlaceId
    );

}
