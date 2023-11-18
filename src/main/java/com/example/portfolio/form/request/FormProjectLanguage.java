package com.example.portfolio.form.request;

import com.example.portfolio.service.dto.SkillDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormProjectLanguage {
    private Integer id;

    private Integer projectId;

    private Integer languageId;
}
