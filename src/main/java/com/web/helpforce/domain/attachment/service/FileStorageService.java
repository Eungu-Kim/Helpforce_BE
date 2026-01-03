package com.web.helpforce.domain.attachment.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.UUID;

@Service
@Slf4j
public class FileStorageService {

    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    @Value("${app.base-url}")
    private String baseUrl;

    public String storeFile(MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) {
                throw new IllegalArgumentException("업로드할 파일이 없습니다.");
            }

            // 파일 크기 검증 (10MB)
            if (file.getSize() > 10 * 1024 * 1024) {
                throw new IllegalArgumentException("파일 크기는 10MB를 초과할 수 없습니다.");
            }

            log.info("파일 저장 시작: {}, 크기: {}", file.getOriginalFilename(), file.getSize());

            // 업로드 디렉토리 생성
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
                log.info("업로드 디렉토리 생성: {}", uploadPath);
            }

            // 파일명 안전 처리 (경로 제거, 공백/특수문자 대응)
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                originalFilename = "file";
            }
            originalFilename = Paths.get(originalFilename).getFileName().toString(); // 경로 제거
            originalFilename = originalFilename.replace("..", ""); // 기본 방어

            // UUID + 원본 파일명
            String filename = UUID.randomUUID() + "_" + originalFilename;

            // 저장
            Path targetLocation = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            log.info("파일 저장 완료: {}", targetLocation);

            // ✅ 절대 URL 반환 (프론트가 어디 있든 접근 가능)
            String encodedFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8)
                    .replace("+", "%20"); // 공백 처리

            String normalizedBase = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;

            return normalizedBase + "/uploads/" + encodedFilename;

        } catch (IOException e) {
            log.error("파일 저장 중 오류 발생: {}", e.getMessage(), e);
            throw new RuntimeException("파일 저장에 실패했습니다.", e);
        }
    }
}
