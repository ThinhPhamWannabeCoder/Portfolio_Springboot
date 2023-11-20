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
@Table(name = "intro_type")
public class IntroTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="intro_type_id")
    private Integer id;
    @Column(name="intro_type_name", columnDefinition = "NVARCHAR(20)", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "introType")
    private List<IntroEntity> introEntityList;
}
