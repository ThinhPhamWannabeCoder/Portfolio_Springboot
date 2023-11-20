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
@Table(name = "topic")
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "domain_id", referencedColumnName = "domain_id", nullable = false)
    private DomainEntity domain;

    @Column(name = "topic_name", columnDefinition = "NVARCHAR(10)",nullable = false, unique = true)
    private String name;
    @Column(name = "topic_desc", columnDefinition = "TEXT", nullable = false)
    private String desc;

    @OneToMany(mappedBy = "topic")
    private List<ProjectEntity> projectEntityList;
}
