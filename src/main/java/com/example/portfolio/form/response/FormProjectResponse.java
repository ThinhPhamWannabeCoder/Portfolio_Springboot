package com.example.portfolio.form.response;

import com.example.portfolio.service.dto.DomainDTO;
import com.example.portfolio.service.dto.SkillDTO;
import com.example.portfolio.service.dto.TopicDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormProjectResponse {
    private Integer id;
    private String name;
    private String desc;
    private String topicName;
    private String domainName;
    private Date date;
    List<String> languages; // lấy thông tin name và thong tin url
    List<String> tools;


}
