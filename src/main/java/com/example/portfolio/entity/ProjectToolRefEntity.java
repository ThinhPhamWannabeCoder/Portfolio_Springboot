package com.example.portfolio.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project_tool")
@DynamicInsert
@DynamicUpdate
public class ProjectToolRefEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_tool_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
    private ProjectEntity project;


    @ManyToOne
    @JoinColumn(name = "tool_id", referencedColumnName = "skill_id", nullable = false)
    private SkillEntity tool;
}
