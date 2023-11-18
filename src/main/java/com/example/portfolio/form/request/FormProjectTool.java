package com.example.portfolio.form.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormProjectTool {
    private Integer id;

    private Integer projectId;

    private Integer toolId;
}
