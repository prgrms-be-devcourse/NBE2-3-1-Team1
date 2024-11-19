# programmers_coffee
programmers side project
프로그래머스 프로머스 1차 과제 클론(사이렌 오더)å

---

## 프로젝트 개요

- 24.11.11 ~ 24.12.10 [약 한달]
- 

---

## 기획의도 - 다같이

- 
- 
- 

---

## 주요 기능

- `세부기능`
    
    회색은 우선순위 매우 낮음 💡
    
    ### 사용자 (User)
    
    1. **회원 등록**
        - **회원 가입**
            - 이메일/전화번호 기반의 회원 가입
            - 필수 정보 (이메일/ 비밀번호/ 이름) 등
            - 이메일 인증/ 전화번호 인증 절차
            
    2. **비밀번호 리셋/ 회원 탈퇴/ 비활성화/ 아이디 변경**
        - **비밀번호 리셋**
            - 이메일 또는 SMS 비밀번호 재 설정 링크 발송
            - 보안 질문/ 이메일 확인 등을 통한 인증
        - **회원 탈퇴**
            - 사용자가 직접 요청하거나 관리자가 강제 탈퇴 시킬 수 있는 기능
            - 탈퇴 시 데이터 삭제 처리
        - **비활성화**
            - 비 활성화된 계정은 로그인이 불가능
            - 사용자에게 알림을 보내며, 관리자만 활성화 가능
        
    3. **회원 정보 조회 및 수정**
        - **회원 정보 조회**
            - 사용자 본인만 본인의 정보 조회 가능(이름, 이메일. 연락처 등)
        - **회원 정보 수정**
            - 이름 연락처, 주소 등 수정 가능
        - **프로필 사진 변경**
            - 사용자가 프로필 사진을 업로드 하거나 수정
    
    1. **로그인**
        - **로그인 및 자동 로그인**
            - 이메일/전화번호 기반 로그인 및 소셜 로그인.
    2. **주문 및 결제**
        - **메뉴 조회**
            - 카테고리 별 메뉴 보기
            - 제품의 상세 정보(재료, 영양 성분, 알레르기 정보)
        - **주문 기능**
            - 커스텀 옵션 선택
                - 샷 추가, 시럽 변경 등
            - 장바구니 관리
                - 선택한 메뉴의 추가, 제거 및 옵션 변경
            - 빠른 재주문
                - 이전 주문 내역을 기반으로 빠르게 재주문
        - **결제**
            - 결제 옵션 ( 카드, 간편 결제, 포인트 사용 등 )
            - 할인 및 쿠폰
            - 결제 내역 관리
        - **주문 상태 확인 및 알림**
            - 주문 진행 상황 확인
            - 주문 상태 업데이트 알림
    
    ### 관리자 (Admin)
    
    1. **회원 관리**
        - 회원 탈퇴 및 비활성화 처리
    2. **메뉴 및 주문 관리**
        - 메뉴 추가 및 수정
        - 옵션 관리 (추가 옵션)
        - 주문 모니터링
        - 결제 확인
    

---

## 팀소개

- 팀장: 유아현 [ 총괄, 아키텍쳐 설계, API 명세서, 나머지 페이지 혹은 너무 양이 많으면 나눠 갖기, 초기데이터 ]
- 팀원: 김소연 [ 시퀀스 다이어그램, API 명세서, 주문 및 결제 ]
- 팀원: 정도현[ DB 설계, API 명세서, 회원관리(가입 및 수정) ]
- 팀원: 최지영 [ 시퀀스 다이어그램, API 명세서, 메뉴조회, 주문상태 확인 ]
- 팀원: 허정현 [ 프로젝트 순서도, 시퀀스 다이어그램, API 명세서, 관리자 권한 및 전용페이지 ]

---

## 아키텍쳐

- `아키텍쳐`
    <img width="785" alt="image" src="https://github.com/user-attachments/assets/7c12bd1b-a304-46b9-8b12-98a1ebc2c69c">


---

## 개발환경

- 앱 : JAVA
- 서버 : Apache, html
- DB : Mysql
- postman

---

## 구성 라이브러리 -차차채우는걸로 정리

- 

---

## 프로젝트 순서도 - 허정현

- `순서도`
  ![image2](https://github.com/user-attachments/assets/a60df83c-bb6f-4391-8a21-af842047d2f8)
  ![image3](https://github.com/user-attachments/assets/b3d3e9ee-4a5c-4c5a-bd92-6e994d5d0ab1)

    


**수정사항이 생기면 추가로 적거나 추가할게여** 

- 적어주세여

---

## usecase

- `USECASE`
    ![image4](https://github.com/user-attachments/assets/ec47c362-b521-416c-a71c-fb33918ab057)

---

## ERD

- `도면`
    
    ![ima![image5](https://github.com/user-attachments/assets/9095b18f-be44-4e0b-95ec-44a686488f17)

---

## 시퀀스 다이어그램 - 김소연, 최지영, 허정현

- `다이어그램`
    
    
    - 회원가입
        
        ![회원가입.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/4e8002c6-4a05-4cf5-a091-6a4d394b3af5/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85.png)
        
    - 비밀번호 리셋
        
        ![비밀번호 리셋.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/2d0d94dc-a57a-45c2-8a18-0ca49c87924a/%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8_%EB%A6%AC%EC%85%8B.png)
        
    - 계정 비활성화
        
        ![계정 비활성화.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/764639b9-65dd-487c-ad60-741b4d6c17c1/%EA%B3%84%EC%A0%95_%EB%B9%84%ED%99%9C%EC%84%B1%ED%99%94.png)
        
    
    - 메뉴 조회
        
        ![메뉴 조회.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/26eb2245-5c82-4dc6-9003-d67aacdc4a2c/83df5236-f0d2-4458-b67d-78de3322af96.png)
        
    - 장바구니 관리
        
        ![장바구니.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/0e07ec96-ae4e-4f99-b7b9-c11821fe2ff3/de7827d7-ef3b-46fd-b4d5-f1c1ecab2b15.png)
        
    - 주문 및 결제
        
        ![주문 및 결제 (1).png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/bc0d5eb4-d63f-4f7c-99b0-f13c78ffcbba/%EC%A3%BC%EB%AC%B8_%EB%B0%8F_%EA%B2%B0%EC%A0%9C_(1).png)
        
    - 옵션 추가 및 수정 (관리자)
        
        ![관리자 옵션 추가 및 수정.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/9b2dd0f2-2812-48bb-8fd1-d8420b39f327/81ac47fa-5785-4b81-bab3-40b63d5ff7cc.png)
        
    - 쿠폰 발행(관리자)
        
        ![쿠폰 발행.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/380b25ae-4a1a-4996-a34a-a211ffa4b7a4/48770108-f6c2-441b-872e-37ae21e404c4.png)
        
    
    - 로그인/로그아웃
        
        ![로그인_로그아웃.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/9450088c-c637-433e-957c-1b78bd627eb0/%EB%A1%9C%EA%B7%B8%EC%9D%B8_%EB%A1%9C%EA%B7%B8%EC%95%84%EC%9B%83.png)
        
    - 회원 탈퇴
        
        ![회원탈퇴.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/2dfee99a-7489-42a0-a69c-9492f16a59ce/%ED%9A%8C%EC%9B%90%ED%83%88%ED%87%B4.png)
        
    - 회원정보 조회/수정
        
        ![회원정보 조회_수정.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/d284545b-6ccf-426b-8553-d59d7c90fb08/%ED%9A%8C%EC%9B%90%EC%A0%95%EB%B3%B4_%EC%A1%B0%ED%9A%8C_%EC%88%98%EC%A0%95.png)
        
    
    - 커스텀 옵션 선택
        
        ![옵션 선택.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/91016372-0b59-4b60-9f90-e44f92726200/79eb49a7-1b6e-45c9-83c0-eaef5eb908d2.png)
        
    - 재주문 요청
        
        ![빠른 재주문.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/ebd63c10-1f79-4c7b-aec9-01779fa6b59b/357a0d09-90d1-4e92-80f2-02b91e294407.png)
        
    - 메뉴 추가 및 수정 (관리자)
        
        ![관리자 메뉴 추가 및 수정.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/5f1e18ea-8e8e-4a23-97ae-e5432f5de67e/aeba6a4e-d849-4214-b71a-e9aebf61c944.png)
        
    - 주문 모니터링 (관리자)
        
        ![주문 처리.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/89fde35f-d786-48b7-a620-56fc17eb00d5/3cb28fa1-1650-4c7a-b126-958c2412b94d/0ae2bb23-1076-4b45-bd40-08aa8911eebc.png)
        
    

---

## API 명세서 - 각자

- `API`
    

---

# 기타
