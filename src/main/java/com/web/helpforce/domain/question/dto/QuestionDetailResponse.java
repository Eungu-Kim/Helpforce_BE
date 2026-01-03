package com.web.helpforce.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDetailResponse {

    private Long id;
    private String title;
    private String body;
    private String status;
    private Integer views;

    private Boolean isBookmarked;
    private Long acceptedAnswerId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UserSummary user;

    private List<Long> tagIds;
    private List<AttachmentDto> attachments;
    private List<AnswerDto> answers;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserSummary {
        private Long id;
        private String nickname;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class AttachmentDto {
        private Long id;
        private String fileUrl;
        private String mimeType;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class AnswerDto {
        private Long id;
        private String body;

        private Boolean isAccepted;

        private Long likeCount;
        private Boolean isLiked;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private UserSummary user;

        private List<AnswerDto> childAnswers;

        private Long parentAnswerId;
    }
}
