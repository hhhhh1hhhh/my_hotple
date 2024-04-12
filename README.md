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
    
    **- 메인 페이지(로그인되지 않은 상태)**
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
    - 로그인이 실패하면 실패 원인 메시지로 표시하며, 로그인에 성공하면 메인 페이지("/")로 redirect 된다.
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
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/fbdc6edf-e75c-4eb4-bbb7-5980d9c3d6f2)
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/9c9894d4-a008-4303-a8c2-60dfa18ff782)
    - 게시글 수정 시, 첨부된 파일을 삭제할 수 있다.
    - 파일 삭제 시,  Confirm 으로 파일 삭제 여부를 물어보며, '확인'을 누르면 파일은 즉시 삭제된다.
    - 게시글 수정 시, 수정된 시간이 표시된다.
    </br>

    **- My place 글 삭제하기**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/d8cd5baf-d410-4b66-802d-78eb16b92b1c)
    - 게시글 삭제 시, Confirm 창으로 파일 삭제 여부를 물어보며, '확인'을 누르면 my place 게시글 목록으로 redirect 된다.

  </details>
  </br>

  <details>
  <summary>🎡 게시판(Shared) 관련</summary>
      
    **- Shared 페이지**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/b0b559cf-255f-4168-adfc-76c7ccd501d2)
    - 사용자들이 작성한 게시글 중 공유가 허용된 게시글(공유 여부 = true) 목록을 페이징 처리하여 보여준다.
    </br>
    
    **- 좋아요 기능**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/81014e71-a246-429f-bdf4-97c433792a01)
    - 로그인 한 사용자가 처음으로 '좋아요'를 누르면, 좋아요가 등록된다.
    - 이미 '좋아요'를 누른 게시글에 다시 '좋아요'를 누르면, 좋아요가 취소된다.
    - 로그인하지 않은 사용자가 '좋아요'를 누르면, 로그인이 필요하다는 알림 창이 표시된다.
  </details>
  </br>

   <details>
  <summary>🌟 댓글 관련</summary>

    **- 댓글 작성 페이지(로그인되지 않은 상태)**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/b2e9032f-a7b7-4422-8f2b-a3e53243ed0c)
    </br>

    **- 댓글 작성 페이지(로그인 상태)**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/4f9531fb-6881-4fa6-9241-0c0d169d5179)
    - 사용자가 로그인한 경우, 로그인한 유저의 이름이 댓글 창에 표시된다.
    - 자신이 작성한 댓글인 경우, 수정 및 삭제를 할 수 있다.
    </br>

    **- 댓글 수정하기**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/2d9d8dbc-7165-460d-8855-d6c655e95136)
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/c9f43a47-985e-411d-b735-1d5bfa2f8fee)
    - 댓글 수정 시, 수정된 시간이 표시된다.
    </br>
 
    **- 댓글 삭제하기**
    ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/d8cd5baf-d410-4b66-802d-78eb16b92b1c)
    - 댓글 삭제 시, Confirm 창으로 댓글 삭제 여부를 물어보며, '확인'을 누르면 댓글을 작성한 게시글로 redirect 된다.

  </details>
  </br>

    <details>
  <summary>🏠 마이 페이지</summary>
      
  **- 마이 페이지**
  ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/554c520b-ec75-4319-84cf-cc4516eb6996)
  ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/648ace62-c6e3-47c8-8e7c-ba176f07e7a1)
  ![image](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/3040b54d-89f5-4812-82bc-b8fe778ea891)
  - 로그인한 사용자는 자신의 계정 정보를 확인할 수 있다.
  - comment 탭을 클릭하면, 작성한 댓글에 대한 정보를 확인할 수 있다.
  - likes 탭을 클릭하면, 좋아요 누른 게시글을 확인할 수 있다.
  
  </details>
  </br>

## 📄 2. 시스템 구조

### - 패키지 구조

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

### - DB 설계
![db table](https://github.com/hhhhh1hhhh/my_hotple/assets/93113812/9c161672-a593-44c8-b177-c06f9197f7ea)

<details>

  <summary>테이블</summary>

  **- user_entity**
  |칼럼명|데이터 타입|조건|설명|
  |:---|:---|:---|:---|
  |id|int|PK, Not Null, Auto Increment|기본 키|
  |nickname|varchar||이름|
  |nickname|varchar||이메일|Unique|
  |password|varchar||비밀번호|
  |role|varchar||역할|

  </br>

  **- myplace_entity**
  |칼럼명|데이터 타입|조건|설명|
  |:---|:---|:---|:---|
  |id|int|PK, Not Null, Auto Increment|기본 키|
  |fileAttached|int|Not Null|파일 첨부 여부|
  |share|bit|Not Null|게시글 공유 여부|
  |userId|int|FK|사용자 번호|
  |view|int|Not Null|조회수|
  |createTime|datetime||작성 시간|
  |updateTime|datetime||수정 시간|
  |contents|varchar||내용|
  |address|varchar|Not Null|주소|
  |category|varchar||카테고리|
  |placeName|varchar|Not Null|장소 이름|

  </br>

  **- myplace_file_entity**
  |칼럼명|데이터 타입|조건|설명|
  |:---|:---|:---|:---|
  |id|bigint|PK, Not Null, Auto Increment|기본 키|
  |myplace_id|int|FK|게시글 번호|
  |createTime|datetime||작성 시간|
  |updateTime|datetime||수정 시간|
  |originalFileName|varchar||파일 이름|
  |storedFileName|varchar||서버 저장용 파일이름|

   </br>

  **- comment_entity**
  |칼럼명|데이터 타입|조건|설명|
  |:---|:---|:---|:---|
  |id|int|PK, Not Null, Auto Increment|기본 키|
  |myplace_id|int|FK|게시글 번호|
  |createTime|datetime||작성 시간|
  |updateTime|datetime||수정 시간|
  |commentWriter|varchar|Not Null|댓글 작성자|
  |commentContents|varchar||댓글 내용|
  |commentWriterEmail|varchar||댓글 작성자 이메일|

  </br>

  **- like_entity**
  |칼럼명|데이터 타입|조건|설명|
  |:---|:---|:---|:---|
  |id|int|PK, Not Null, Auto Increment|기본 키|
  |myplaceId|int|FK|게시글 번호|
  |userId|int|FK|사용자 번호|

</details>

</br>

### - API 설계
|Method|URL|Description|
|------|---|---|
|GET|/|메인 페이지|
|GET|/join|회원가입 페이지|
|POST|/joinProc|회원가입 정보 처리|
|GET|/login|로그인 페이지|
|POST|/loginProc|로그인 처리|
|GET|/logout|로그아웃 처리|
|GET|/mypage|마이 페이지|
|GET|/myplace/list?page={번호}|myplace 페이징 목록|
|GET|/myplace/{id}?page={번호}|myplace 게시글 상세보기|
|GET|/myplace/write|myplace 저장하기 페이지|
|POST|/myplace/save|myplace 게시글 저장 처리|
|GET|/myplace/edit/{id}|myplace 게시글 수정 페이지|
|PUT|/myplace/edit|myplace 게시글 수정 처리|
|DELETE|/myplace/delete/{id}|myplace 게시글 삭제 처리|
|DELETE|/myplace/deleteFile|첨부 파일 삭제 처리|
|GET|/shared/list?page={번호}|shared(공유된 게시글) 페이징 목록|
|GET|/shared/{id}?page={번호}|shared(공유된 게시글) 상세보기|
|POST|/ike/add|게시글 좋아요 토글|
|POST|/comment/save|댓글 저장 처리|
|PUT|/comment/edit/{id}|댓글 수정 처리|
|DELETE|/delete/{id}|댓글 삭제 처리|

</br></br>
