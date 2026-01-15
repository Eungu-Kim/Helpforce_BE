<p align="middle">
  <img width="260px" src="https://github.com/Eungu-Kim/helpforce/releases/download/v1.0/helpforce.png"/>
</p>

<h1 align="middle">Helpforce</h1>
<h3 align="middle">CRM 학습자를 위한 Q&A · 태그 · 랭킹 기반 커뮤니티 백엔드 시스템</h3>

<br/>

## 📝 작품 소개

Helpforce는 Salesforce 및 CRM 학습자들이  
실무에서 겪는 질문과 문제를 서로 해결할 수 있도록 설계된  
**Q&A 기반 커뮤니티 백엔드 웹 서비스**입니다.

질문, 답변, 태그, 좋아요, 채택, 랭킹 등  
커뮤니티에 필요한 핵심 기능을 RESTful API로 제공하여  
웹·모바일 클라이언트와 연동 가능한 **확장형 API 서버**를 목표로 구현했습니다.

---

## 🖥 서비스 화면

### 메인 페이지
![Main](https://github.com/Eungu-Kim/helpforce/releases/download/v1.0/main_page.png)

### 로그인
![Login](https://github.com/Eungu-Kim/helpforce/releases/download/v1.0/login_page.png)

---

## ⭐ 주요 기능

### 1️⃣ 회원가입 & 로그인
![Signup](https://github.com/Eungu-Kim/helpforce/releases/download/v1.0/signup_speedup.gif)

JWT 기반 인증을 통해  
사용자 계정 생성 및 로그인 세션을 관리합니다.

---

### 2️⃣ 질문 등록
![Create Question](https://github.com/Eungu-Kim/helpforce/releases/download/v1.0/createQuestion_speedup.gif)

사용자는 질문을 작성하고,  
태그와 함께 등록하여 커뮤니티에 공유할 수 있습니다.

---

### 3️⃣ 답변 · 대댓글 · 채택 · 좋아요
![Answer](https://github.com/Eungu-Kim/helpforce/releases/download/v1.0/accept_speedup.gif)

질문에 대해 답변과 대댓글을 작성할 수 있으며,  
질문자는 하나의 답변을 **채택**하여 해결책을 명확히 표시할 수 있습니다.  
답변에는 좋아요가 적용되어 품질 높은 답변이 자연스럽게 상위 노출됩니다.

---

### 4️⃣ 태그 기반 탐색
![Tag](https://github.com/Eungu-Kim/helpforce/releases/download/v1.0/tag_speedup.1.gif)

태그를 통해 질문을 필터링하고  
관심 분야의 질문만 빠르게 탐색할 수 있습니다.

---

### 5️⃣ 북마크 & 마이페이지
![Bookmark](https://github.com/Eungu-Kim/helpforce/releases/download/v1.0/bookmark_speedup.gif)

사용자는 질문을 북마크하고,  
마이페이지에서 **내 질문 · 내 답변 · 북마크 목록**을 관리할 수 있습니다.

---

## 🏗 시스템 아키텍처

![Architecture](https://github.com/Eungu-Kim/helpforce/releases/download/v1.0/structure.png)

Helpforce는 단일 AWS EC2 서버에 다음 구성으로 운영됩니다.

GitHub에서 빌드한 JAR 파일을  
AWS EC2(Ubuntu)에 직접 배포하여 운영했습니다.

---

## 🔐 인증 & 보안 구조

- JWT 기반 인증 (Access / Refresh Token)
- BCrypt 비밀번호 해싱
- Stateless API 구조
- CORS 허용 Origin 제어
- 업로드 파일 `/uploads/**` 경로로 정적 제공

---

## 🔧 Stack

**Backend**
- Java
- Spring MVC, Spring Security
- JPA (Hibernate)
- JWT (Access / Refresh Token)

**Infrastructure**
- AWS EC2 (Ubuntu)
- MySQL (EC2 직접 설치)
- Nginx (Reverse Proxy)

**Tools**
- GitHub

---

## 💡 기대 효과

- **학습 데이터 통합** : 질문·답변·태그를 구조화하여 CRM 학습 지식을 축적
- **지식 품질 개선** : 채택·좋아요·랭킹을 통해 우수한 답변이 자연스럽게 상위 노출
- **확장성** : 웹·모바일 프론트엔드와 연동 가능한 API 서버 구조
- **운영 가능성** : 인증·파일·검색·집계 기능을 포함한 실서비스형 백엔드

---

## 🙋‍♂️ Team

| 역할 | 이름 |
|------|------|
| PL | 서승아 |
| PL | 성원호 |
| Backend | 김은수 |
| Backend | 김규남 |
| Frontend | 이영호 |

