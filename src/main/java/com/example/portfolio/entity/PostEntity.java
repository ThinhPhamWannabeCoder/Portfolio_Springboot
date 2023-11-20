package com.example.portfolio.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
    private ProjectEntity project;

    @Column(name = "post_desc", columnDefinition = "TEXT", nullable = false)
    private String desc;
    @Column(name = "post_like_num", nullable = false)
    private Integer like_num;
    @Column(name = "post_cmt_num", nullable = false)
    private Integer cmt_num;
    @Column(name = "post_date", nullable = false)
    private Date date;

    @OneToMany(mappedBy = "post")
    List<LikeHolderEntity> likeHolderEntityList;

//    @OneToMany(mappedBy = "post")
//    List<Comment> commentList;
}
