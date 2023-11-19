package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
@DynamicInsert
@DynamicUpdate
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id", nullable = false)
    private TopicEntity topic;

    @Column(name = "project_name", columnDefinition = "NVARCHAR(20)",nullable = false, unique = true)
    private String name;
    @Column(name = "project_desc", columnDefinition = "TEXT", nullable = false)
    private String desc;
    @Column(name = "project_date", nullable = false)
    private Date date;

    @OneToMany(mappedBy = "project")
    List<ProjectLanguageRefEntity> projectLanguageRefEntityList;
    @OneToMany(mappedBy = "project")
    List<ProjectToolRefEntity> projectToolRefEntityList;
//
    @OneToMany(mappedBy = "project")
    List<PostEntity> postEntityList;
}
