package com.example.portfolio.form.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormIntro {
    private Integer id;
    private Integer userId;
    private Integer topicId;
    private Integer typeId;
    private Integer placeId;
    private String  desc;
}
