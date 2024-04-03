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
    
    **- 메인 페이지(로그인 되지 않은 상태)**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/1907176a-f5e8-4d2d-b157-651a72c6e67c)
    </br>

    **- 메인 페이지(로그인 상태)**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/ef5d2d82-8f96-45e8-81e2-cbc865ba931e)
    - 사용자가 로그인한 경우, 상단에 로그인한 사용자의 정보가 표시된다.
  </details>
  </br>
  
  <details>
  <summary>👥 회원 관련</summary>

    **- 회원가입 페이지**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/b8c3c167-8de8-4458-8cee-549860f5bb4a)
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/e541c64c-3a08-41cb-a7d2-32943d1914f7)
    - 회원가입 시, 입력한 정보의 유효성을 검사한 후, 정상적으로 입력되었을 경우 회원 정보를 저장하고 로그인 페이지로 이동한다.
    </br>
    
    **- 로그인 페이지**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/4dd59a33-b68a-4b4f-b2d8-96075f1a62f6)
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/a1f03335-e0af-4ba0-9541-8b52fdae679e)
    - 로그인이 실패한 경우 실패 이유를 메시지로 표시하며, 로그인에 성공하면 메인 페이지("/")로 redirect된다.
  </details>
  </br>

  <details>
  <summary>📖 게시판(My Place) 관련</summary>

    **- My Place 페이지**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/91a1c08e-563f-4696-bf7e-57ec8ee2a387)
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/5097a9ee-9201-42f0-be11-46d4b9ac17d3)
    - 자신이 작성한 글 목록을 페이징 처리하여 보여준다.
    </br>

    **- 내 장소 저장하기**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/3b6765ef-2b61-41ac-913e-c6cf0fe65d96)
    - 로그인한 사용자는 장소 정보와 파일을 저장할 수 있으며, 공유 여부를 설정할 수 있다.
    - 장소 이름과 주소는 필수 입력 사항으로 입력하지 않으면 저장할 수 없다.
    - 글 작성을 완료하면, 글 목록(myplace/list)으로 redirect된다.
    </br>
 
    **- My place 글 상세보기**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/e58867ad-195c-4398-a150-b31f87a9a668)
    - Kakao API를 사용하여 저장된 주소를 지도에 매핑하여 위치를 확인할 수 있다.
    </br>
    
    **- My place 글 수정하기**

  </details>
  </br>

    <details>
  <summary>🎡 게시판(Shared) 관련</summary>
    **- Shared 페이지**


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

