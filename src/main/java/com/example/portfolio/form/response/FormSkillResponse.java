package com.example.portfolio.form.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormSkillResponse {
    private Integer id;
    private String name;
    private String desc;
    private List<String> domainName;
}
