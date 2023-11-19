package com.example.portfolio.form.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormSkill {
    private Integer id;

    private Integer skillTypeId;

    private String  name;
    private String  desc;
}
