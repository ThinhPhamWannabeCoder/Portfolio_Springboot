package com.example.portfolio.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntroDTO {
    private Integer id;

    private UserDTO userDTO;

    private IntroTypeDTO introTypeDTO;

    private IntroPlaceDTO introPlaceDTO;

    private IntroTopicDTO introTopicDTO;

    private String desc;
}
