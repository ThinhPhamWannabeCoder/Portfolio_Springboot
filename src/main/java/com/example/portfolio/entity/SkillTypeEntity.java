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
@Table(name = "skill_type")
public class SkillTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_type_id")
    private Integer id;
    @Column(name = "skill_type_name", columnDefinition = "NVARCHAR(10)", nullable = false, unique = true)
    private String name;
    @Column(name = "skill_type_desc", columnDefinition = "TEXT", nullable = false)
    private String desc;

    @OneToMany(mappedBy = "skillType")
    List<SkillEntity> skillEntityList;
}
