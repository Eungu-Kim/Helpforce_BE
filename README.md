<p align="middle">
  <img src="https://github.com/Eungu-Kim/Helpforce_BE/releases/download/v1.0/helpforce.png" width="300"/>
</p>

<h1 align="middle">Helpforce</h1>
<h3 align="middle">CRM 학습자를 위한 Q&A · 태그 · 랭킹 기반 커뮤니티 백엔드 시스템</h3>

<br/>

## 📝 작품 소개

Helpforce는 Salesforce 및 CRM 수료생들이  
실무에서 겪는 질문과 문제를 서로 해결할 수 있도록 설계된  
**Q&A 기반 커뮤니티 백엔드 웹 서비스**입니다.

질문, 답변, 태그, 좋아요, 채택, 랭킹 등  
커뮤니티에 필요한 핵심 기능을 RESTful API로 제공하여  
웹·모바일 클라이언트와 연동 가능한 **확장형 API 서버**를 목표로 구현했습니다.

---

## 🖥 서비스 화면

### 메인 페이지
![main](https://github.com/Eungu-Kim/Helpforce_BE/releases/download/v1.0/main_page.png)

### 로그인
![login](https://github.com/Eungu-Kim/Helpforce_BE/releases/download/v1.0/login_page.png)

---

## ⭐ 주요 기능

### 1️⃣ 회원가입 & 로그인
![signup](https://github.com/Eungu-Kim/Helpforce_BE/releases/download/v1.0/signup_speedup.gif)

- JWT 기반 로그인
- 비밀번호 암호화
- 인증 세션 유지

---

### 2️⃣ 질문 등록 (Q&A 핵심 기능)
![create](https://github.com/Eungu-Kim/Helpforce_BE/releases/download/v1.0/createQuestion_speedup.gif)

- 질문 작성
- 태그 연결
- 파일 첨부 가능

---

### 3️⃣ 답변, 채택, 좋아요
![accept](https://github.com/Eungu-Kim/Helpforce_BE/releases/download/v1.0/accept_speedup.gif)

- 답변 등록
- 질문자가 답변 채택
- 추천(좋아요) 기능

---

### 4️⃣ 태그 기반 필터링
![tag](https://github.com/Eungu-Kim/Helpforce_BE/releases/download/v1.0/tag_speedup.1.gif)

- 기술 스택별 질문 탐색
- 태그 기반 검색

---

### 5️⃣ 북마크 & 개인 활동 관리
![bookmark](https://github.com/Eungu-Kim/Helpforce_BE/releases/download/v1.0/bookmark_speedup.gif)

- 관심 질문 저장
- 내가 쓴 질문 / 답변 / 북마크 관리

---

## 🧱 핵심 도메인

| 도메인 | 역할 |
|--------|------|
| User | 회원, 인증, 프로필 |
| Question | 질문 게시글 |
| Answer | 답변 |
| Tag | 질문 분류 |
| Bookmark | 관심글 저장 |
| Ranking | 활동 기반 랭킹 |
| Attachment | 파일 업로드 |

각 도메인은  
**Controller – Service – Repository – Entity – DTO** 구조로 분리 설계되었습니다.

---

## 🏗 시스템 아키텍처

![architecture](https://github.com/Eungu-Kim/Helpforce_BE/releases/download/v1.0/structure.png)

**구성**

- 사용자는 브라우저로 서비스 접근
- Nginx → Spring MVC 서버(JAR) → MySQL(DB)
- 파일 업로드는 서버 로컬 `/uploads` 디렉토리 사용
- JWT 기반 인증 처리

---

## 🔐 인증 & 보안 구조

Helpforce는 **Stateless JWT 인증 구조**로 설계되었습니다.

### 인증 흐름

1. 사용자가 로그인 → JWT 발급
2. 이후 모든 요청에 `Authorization: Bearer <token>` 포함
3. `JwtAuthenticationFilter`가 토큰 검증
4. 사용자 ID를 SecurityContext에 주입

### 보안 구현 요소

- BCrypt 비밀번호 암호화
- Access Token / Refresh Token 분리
- Spring Security + Custom JWT Filter
- CORS 정책 적용
- Stateless Session 구조

---

## 🔧 Stack

### Backend
- Java 21
- Spring MVC
- Spring Security
- JPA (Hibernate)
- JWT (io.jsonwebtoken)
- MySQL

### Infra
- AWS EC2 (Ubuntu)
- Nginx (Reverse Proxy)
- MySQL (EC2 내 직접 설치)
- SCP + SSH 기반 배포

### DevOps
- GitHub
- Manual JAR 배포

---

## 🎯 프로젝트 성과

- **계층 분리 기반 아키텍처 설계**
- JWT 인증/인가 시스템 직접 구현
- 실사용 가능한 게시판 + Q&A 서비스 완성
- AWS EC2 + Nginx 실서버 배포
- Salesforce CRM 구조 이해를 위한 사전 백엔드 역량 확보

---

## 🙋‍♂️ Team

| 역할 | 이름 |
|------|------|
| PM | 서승아 |
| PL | 성원호 |
| Backend | **김은수** |
| Backend | 김규남 |
| Frontend | 이영호 |

