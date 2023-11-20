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
@Table(name = "skill")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "skill_type_id", referencedColumnName = "skill_type_id", nullable = false)
    private SkillTypeEntity skillType;

    @Column(name = "skill_name", columnDefinition = "NVARCHAR(50)", nullable = false, unique = true)
    private String name;
    @Column(name = "skill_desc", columnDefinition = "TEXT", nullable = false)
    private String desc;

    @OneToMany(mappedBy = "skill")
    private List<DomainSkillRefEntity> domainSkillRefEntityList;

    @OneToMany(mappedBy = "language")
    private List<ProjectLanguageRefEntity> projectLanguageRefEntityList;

    @OneToMany(mappedBy = "tool")
    private List<ProjectToolRefEntity> projectToolRefEntityList;
}
