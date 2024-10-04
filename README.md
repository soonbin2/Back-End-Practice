옷 판매 시스템 모델링 tbl_clothes clothes_code , clothes_name, clothes_price , category_code, orderable_status tbl_category category_code, category_name

테이블 구조

tbl_clothes (옷 테이블) clothes_code: VARCHAR (Primary Key) 각 옷의 고유 식별자. clothes_name: VARCHAR 옷의 이름. clothes_price: DECIMAL 옷의 가격. category_code: VARCHAR (Foreign Key) 옷의 카테고리를 식별하는 외래 키. tbl_category 테이블의 category_code를 참조. orderable_status: BOOLEAN 주문 가능 여부 (TRUE: 주문 가능, FALSE: 주문 불가).
tbl_category (카테고리 테이블) category_code: VARCHAR (Primary Key) 각 카테고리의 고유 식별자. category_name: VARCHAR 카테고리의 이름. 하나의 카테고리(tbl_category)는 여러 개의 옷(tbl_clothes)을 가질 수 있습니다. tbl_clothes.category_code는 tbl_category.category_code를 참조합니다.




![화면 캡처 2024-10-04 144101](https://github.com/user-attachments/assets/d25d7cb0-eb56-4015-b87c-13f1418622b2)
![화면 캡처 2024-10-04 170545](https://github.com/user-attachments/assets/ae37d6c3-a6a6-4751-8f92-bca847ccac92)
