package com.web.helpforce.domain.ranking.service;

import com.web.helpforce.domain.answer.repository.AnswerLikeRepository;
import com.web.helpforce.domain.ranking.dto.TopContributorDto;
import com.web.helpforce.domain.ranking.dto.TopContributorsResponseDto;
import com.web.helpforce.domain.user.entity.User;
import com.web.helpforce.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RankingService {

    private final AnswerLikeRepository answerLikeRepository;
    private final UserRepository userRepository;

    /**
     * 좋아요를 많이 받은 상위 5명 조회
     */
    public TopContributorsResponseDto getTopContributors() {
        System.out.println("=== Top Contributors Query Debug ===");

        try {
            // 1. 좋아요를 많이 받은 사용자 조회
            List<Object[]> topUsers = answerLikeRepository.findTopContributors();
            System.out.println("조회된 사용자 수: " + topUsers.size());

            // 2. 데이터가 없으면 빈 리스트 반환
            if (topUsers.isEmpty()) {
                System.out.println("⚠️ 좋아요 데이터가 없습니다.");
                return TopContributorsResponseDto.builder()
                        .rankings(new ArrayList<>())
                        .updatedAt(LocalDateTime.now())
                        .build();
            }

            // 3. 상위 5명만 선택
            int limit = Math.min(5, topUsers.size());
            List<TopContributorDto> rankings = new ArrayList<>();

            for (int i = 0; i < limit; i++) {
                Object[] result = topUsers.get(i);
                
                // 타입 안전한 변환
                Long userId = ((Number) result[0]).longValue();
                Long likeCount = ((Number) result[1]).longValue();

                System.out.println("Rank " + (i + 1) + ": userId=" + userId + ", likes=" + likeCount);

                // 4. 사용자 정보 조회
                User user = userRepository.findById(userId)
                        .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

                // 5. DTO 생성
                TopContributorDto.UserInfoDto userInfo = TopContributorDto.UserInfoDto.builder()
                        .id(user.getId())
                        .nickname(user.getNickname())
                        .department(user.getDepartment())
                        .crmGeneration(user.getCrmGeneration())
                        .build();

                TopContributorDto contributor = TopContributorDto.builder()
                        .rank(i + 1)
                        .user(userInfo)
                        .totalLikes(likeCount)
                        .build();

                rankings.add(contributor);
            }

            System.out.println("✅ Top Contributors 조회 완료");

            // 6. 응답 DTO 생성
            return TopContributorsResponseDto.builder()
                    .rankings(rankings)
                    .updatedAt(LocalDateTime.now())
                    .build();
                    
        } catch (Exception e) {
            System.out.println("❌ Top Contributors 조회 중 오류 발생");
            System.out.println("에러 타입: " + e.getClass().getName());
            System.out.println("에러 메시지: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("랭킹 조회 중 오류가 발생했습니다.", e);
        }
    }
}
