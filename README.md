# 🚀 My Hotple - 장소 기록 및 공유 웹 애플리케이션
## 💻 1. 프로젝트 소개
- ### 프로젝트 소개
  - 사용자가 기록하고 싶은 장소를 저장하고, 다른 사람들과 공유할 수 있는 웹 페이지입니다. REST API를 구현하고자 공부한 내용을 프로젝트에 적용했습니다.

- ### 프로젝트 기능
  - 회원가입 및 로그인
    - Spring Security를 통한 회원가입 및 로그인 기능 구현
    - 회원가입 시 유효성 검사 기능
  - 마이페이지
    - 사용자의 계정 정보, 작성한 댓글, 좋아요 누른 글을 확인할 수 있는 페이지
  - 게시판(myplace)
    - 장소 정보를 CRUD(Create, Read, Update, Delete)할 수 있는 기능 구현
    - 자신이 작성한 글 목록을 페이징 처리하여 제공
    - 게시물의 공유 여부를 표시하는 기능 추가
  - 게시판(shared)
    - 공유된 장소 정보를 확인할 수 있는 게시판
    - 페이징 처리 및 조회수 기능
    - 좋아요 기능
  - 댓글 기능
    - 게시물에 대한 댓글을 CRUD(Create, Read, Update, Delete)할 수 있는 기능
  - 주소와 지도 매핑
    - 저장된 주소를 지도에 매핑하여 시각적으로 확인 가능
    - Kakao API를 활용하여 지도 서비스 구현


  
- ### 사용 기술
  ✔ Front-End</br>
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
  <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">


  ✔ Back-End</br>
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white">
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">

- ### 실행화면
  <details>
  <summary>😋 메인 페이지</summary>
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/55f96f88-927d-4d7b-9fe0-4d3c2f804509)
  </details>
  </br>
  
  <details>
  <summary>👥 회원 관련</summary>
  - 회원 관련
  </details>
  </br>

  <details>
  <summary>📖 게시글 관련</summary>
  - 게시글 관련
  </details>
  </br>

  <details>
  <summary>🌟 댓글 관련</summary>
  - 댓글 관련
  </details>
  </br>

    <details>
  <summary>🏠 마이 페이지</summary>
  - 마이 페이지
  </details>
  </br>



</br></br>

## 📄 2. 시스템 구조
  <details>
  <summary>패키지 구조</summary>
  
  ``` 
 📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂restaurant
 ┃ ┃ ┃ ┗ 📂restaurant
 ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JoinController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JoinDTO.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomAuthenticationFailureHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomAuthenticationSuccessHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JoinService.java
 ┃ ┃ ┃ ┃ ┣ 📂comment
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommentController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommentDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommentEntity.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommentRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommentService.java
 ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WebConfig.java
 ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┣ 📜MainController.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜MypageController.java
 ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┗ 📜BaseEntity.java
 ┃ ┃ ┃ ┃ ┣ 📂likes
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LikesController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LikesDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LikesEntity.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LikesRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LikesService.java
 ┃ ┃ ┃ ┃ ┣ 📂myplace
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyplaceController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyplaceDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyplaceEntity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyplaceFileEntity.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyplaceFileRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyplaceRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyplaceFileService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyplaceService.java
 ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┣ 📂shared
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SharedController.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SharedService.java
 ┃ ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CustomUserDetails.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserEntity.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CustomUserDetailsService.java
 ┃ ┃ ┃ ┃ ┗ 📜RestaurantApplication.java
 ┃ ┗ 📂resources
 ┃ ┃ ┣ 📂static
 ┃ ┃ ┃ ┣ 📂css
 ┃ ┃ ┃ ┃ ┣ 📜bootstrap.min.css
 ┃ ┃ ┃ ┃ ┗ 📜mainMap.css
 ┃ ┃ ┃ ┗ 📂js
 ┃ ┃ ┃ ┃ ┣ 📜join.js
 ┃ ┃ ┃ ┃ ┣ 📜mainMap.js
 ┃ ┃ ┃ ┃ ┗ 📜write.js
 ┃ ┃ ┣ 📂templates
 ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┣ 📜join.html
 ┃ ┃ ┃ ┃ ┗ 📜login.html
 ┃ ┃ ┃ ┣ 📂layout
 ┃ ┃ ┃ ┃ ┣ 📜head.html
 ┃ ┃ ┃ ┃ ┣ 📜nav.html
 ┃ ┃ ┃ ┃ ┗ 📜write-edit-form.html
 ┃ ┃ ┃ ┣ 📂myplace
 ┃ ┃ ┃ ┃ ┣ 📜detail.html
 ┃ ┃ ┃ ┃ ┣ 📜edit.html
 ┃ ┃ ┃ ┃ ┣ 📜list.html
 ┃ ┃ ┃ ┃ ┗ 📜write.html
 ┃ ┃ ┃ ┣ 📂shared
 ┃ ┃ ┃ ┃ ┣ 📜detail.html
 ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┣ 📜main.html
 ┃ ┃ ┃ ┗ 📜mypage.html
 ┃ ┃ ┗ 📜application.properties
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂restaurant
 ┃ ┃ ┃ ┗ 📂restaurant
 ┃ ┃ ┃ ┃ ┗ 📜RestaurantApplicationTests.java
  ```

  </details>
  </br>


- ### 패키지 구조


- ### DB 설계


- ### API 설계
  
</br></br>


## 😊 3. 마치며
- ### 프로젝트 후기

