package com.example.portfolio.service.dto;

import com.example.portfolio.entity.LikeHolderEntity;
import com.example.portfolio.entity.ProjectEntity;
import com.example.portfolio.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Integer id;

    private UserDTO userDTO;

    private ProjectDTO projectDTO;

    private String desc;

    private Integer like_num;

    private Integer cmt_num;

    private Date date;

    List<LikeHolderDTO> likeHolderDTOList;

}
