# shop-server
네이버 쇼핑 백엔드 시스템
# shop-server

네이버 쇼핑 백엔드 시스템

​목적
---
- 쇼핑 서비스를 구현하며 스프링, DB, 네트워크, 배포환경에 대한 이해를 높이자
- 대규모 트래픽에도 견고한 어플리케이션을 구현하자
- Git을 활용한 협업 환경에 익숙해지자

기획
---
- 쇼핑 서비스 이용자에게 다양한 제품을 보여주고 우너하는 제품이 있다면 구매할 수 있는 환경 제공
- [프로토타입](https://ovenapp.io/view/cLwgxkjSSGsOILGjDAxLfHc6orkbugOF/)

프로젝트 주요 기능
---
- 회원가입 및 로그인
  - 회원 탈퇴, 아이디 중복 체크, 비밀번호 암호화, 비밀번호 변경 등
- 판매자 제품관리 시스템
  - 제품 등록 기능
    - 카테고리, 수량, 가격, 상세페이지, 제품정보 등
    - 판매제품 정보(판매 수량, 액수 등)
- 리뷰 별점 시스템
  - 서비스 이용자들의 리뷰 좋아요 시스템
    - 최신순, 평점 높은순, 평점 낮은순, 좋아요순 정렬 기능
- 이용자-판매자 간의 쌍방 소통창구 채팅 시스템
- 제품 검색/분류 시스템
  - 카테고리에 의한 분류
  - 구매자순, 리뷰 별점 순, 배송비 유무, 가격 낮은순/높은순 정렬
- 제품 구매 시스템
  - 장바구니 기능
  - 배송지 등록
- 제품 구매내역 구현
  - 제품 이름, 수량, 가격
  - 리뷰 작성, 리뷰 작성 내역
  - 배송 정보
  - 기간별 구매내역
  - 반품/교환 신청

사용 기술
---
- Java8, Spring Boot, MyBatis, Jasypt ..(TBD)

ERD
---
![ERD](https://user-images.githubusercontent.com/47594043/202621330-08660c9f-e139-48de-bf9f-3fe369d33059.png)
