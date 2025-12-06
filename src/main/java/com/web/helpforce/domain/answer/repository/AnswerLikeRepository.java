package com.web.helpforce.domain.answer.repository;

import com.web.helpforce.domain.answer.entity.AnswerLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerLikeRepository extends JpaRepository<AnswerLike, AnswerLike.AnswerLikeId> {
    
    // 특정 답변의 좋아요 개수
    long countByAnswer_Id(Long answerId);
    
    // 특정 유저가 특정 답변에 좋아요 했는지 확인
    boolean existsByAnswer_IdAndUser_Id(Long answerId, Long userId);
    
    // 좋아요를 많이 받은 사용자 Top N 조회
    @Query("SELECT a.user.id, COUNT(al) " +
           "FROM AnswerLike al " +
           "JOIN al.answer a " +
           "GROUP BY a.user.id " +
           "ORDER BY COUNT(al) DESC")
    List<Object[]> findTopContributors();
}
