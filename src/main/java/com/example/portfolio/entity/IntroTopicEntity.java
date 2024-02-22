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
@Table(name = "intro_topic")
public class IntroTopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="intro_topic_id")
    private Integer id;
    @Column(name="intro_topic_name", columnDefinition = "NVARCHAR(20)", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "introTopic")
    private List<IntroEntity> introEntityList;
}
