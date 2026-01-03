package com.web.helpforce.domain.user.dto;

import com.web.helpforce.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupResponseDto {

    private Long id;
    private String email;
    private String nickname;
    private String crmGeneration;
    private String department;
    private LocalDateTime createdAt;

    public static SignupResponseDto of(User user) {
        return SignupResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .crmGeneration(user.getCrmGeneration())
                .department(user.getDepartment())
                .createdAt(user.getCreatedAt())
                .build();
    }
}