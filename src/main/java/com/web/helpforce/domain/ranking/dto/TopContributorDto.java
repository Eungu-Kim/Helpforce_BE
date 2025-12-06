package com.web.helpforce.domain.ranking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopContributorDto {
    private Integer rank;           // 순위
    private UserInfoDto user;       // 사용자 정보
    private Long totalLikes;        // 총 좋아요 수

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfoDto {
        private Long id;
        private String nickname;
        private String department;
        private String crmGeneration;
    }
}
