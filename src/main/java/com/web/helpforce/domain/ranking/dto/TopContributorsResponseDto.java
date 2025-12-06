package com.web.helpforce.domain.ranking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopContributorsResponseDto {
    private List<TopContributorDto> rankings;
    private LocalDateTime updatedAt;  // 랭킹 갱신 시간
}
