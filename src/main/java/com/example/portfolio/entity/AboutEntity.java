package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "about")
@DynamicUpdate
public class AboutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="about_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",nullable = false)
    private UserEntity user;

    @Column(name = "about_type", columnDefinition = "NVARCHAR(10)", nullable = false)
    private String type;
    @Column(name = "about_header", columnDefinition = "NVARCHAR(10)", nullable = false)
    private  String header;
    @Column(name = "about_tag_1", columnDefinition = "NVARCHAR(10)", nullable = false)
    private  String tag_1;
    @Column(name = "about_tag_2", columnDefinition = "NVARCHAR(10)")
    private  String tag_2;
    @Column(name = "about_desc", columnDefinition = "TEXT", nullable = false)
    private  String desc;
    @Column(name = "about_date", nullable = false)
    private Date date;
    @Override
    public String toString() {
        return "AboutEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", header='" + header + '\'' +
                // Add other attributes or meaningful information to print
                '}';
    }
}
