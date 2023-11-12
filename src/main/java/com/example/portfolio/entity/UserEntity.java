package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
//@ToString(exclude = "userroleList") // Exclude the userroleList from toString to avoid LazyInitializationException
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name ="user_email", columnDefinition = "NVARCHAR(255)", nullable = false, unique = true)
    private String email;
    @Column(name = "user_password", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String password;
    @Column(name = "user_name", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String fullName;
//    @Column(name="user_intro", columnDefinition = "TEXT", nullable = false)
//    private String user_intro;
//    @Column(name="user_avatar", columnDefinition = "TEXT", nullable = false)
//    private String user_avatar;
//    @Column(name="createdDate", nullable = false)
//    private Date createdDate;

    //    One to Many
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoleEntity> userroleList;

//    @OneToMany(mappedBy = "user")
//    private List<About> aboutList;
//
//    @OneToMany(mappedBy = "user")
//    private List<Post> postList;
//
//    @OneToMany(mappedBy = "user")
//    private List<LikeHolder> likeHolderList;
//
//    @OneToMany(mappedBy = "user")
//    private List<Comment> commentList;

}
