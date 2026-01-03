package com.web.helpforce.domain.answer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerCreateResponseDto {

    private Long id;
    private Long questionId;
    private Long userId;
    private String body;
    private Long parentAnswerId;
    private LocalDateTime createdAt;
}
