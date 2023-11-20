package com.example.portfolio.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "intro_place")
public class IntroPlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="intro_place_id")
    private Integer id;
    @Column(name="intro_place_name", columnDefinition = "NVARCHAR(20)", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "introPlace")
    private List<IntroEntity> introEntityList;
}
