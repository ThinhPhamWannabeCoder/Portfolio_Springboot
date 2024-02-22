package com.example.portfolio.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "intro")
public class IntroEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="intro_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "intro_type_id", referencedColumnName = "intro_type_id", nullable = false)
    private  IntroTypeEntity introType;

    @ManyToOne
    @JoinColumn(name = "intro_place_id", referencedColumnName = "intro_place_id", nullable = false)
    private  IntroPlaceEntity introPlace;

    @ManyToOne
    @JoinColumn(name = "intro_topic_id", referencedColumnName = "intro_topic_id", nullable = false)
    private  IntroTopicEntity introTopic;


    @Column(name="intro_desc", columnDefinition = "TEXT", nullable = false)
    private String desc;
}
