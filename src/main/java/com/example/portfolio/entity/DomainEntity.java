package com.example.portfolio.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "domain")
@DynamicInsert
@DynamicUpdate
public class DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private Integer id;
    @Column(name = "domain_name", columnDefinition = "NVARCHAR(10)",nullable = false, unique = true)
    private String name;
    @Column(name = "domain_desc", columnDefinition = "TEXT", nullable = false)
    private String desc;

    @OneToMany(mappedBy = "domain")
    private List<TopicEntity> topicEntityList;
    @OneToMany(mappedBy = "domain")
    private List<DomainSkillRefEntity> domainSkillRefEntityList;
}
