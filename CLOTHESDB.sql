DROP TABLE IF EXISTS tbl_clothes CASCADE;
DROP TABLE IF EXISTS tbl_category CASCADE;
DROP TABLE IF EXISTS tbl_order CASCADE;
DROP TABLE IF EXISTS tbl_order_clothes CASCADE;

CREATE TABLE IF NOT EXISTS tbl_category
(
	category_code	INT AUTO_INCREMENT COMMENT '카테고리코드',
    category_name	VARCHAR(30) NOT NULL COMMENT '카테고리명',
    
    CONSTRAINT pk_category_code PRIMARY KEY (category_code)
    
)ENGINE=INNODB COMMENT '카테고리';

CREATE TABLE IF NOT EXISTS tbl_clothes
(
	clothes_code	INT AUTO_INCREMENT COMMENT '옷코드',
    clothes_name	VARCHAR(30) NOT NULL COMMENT '옷이름',
    clothes_price	INT NOT NULL COMMENT '옷가격',
    category_code	INT NOT NULL COMMENT '카테고리코드',
    orderable_status	VARCHAR(30) NOT NULL COMMENT '주문가능상태',
    CONSTRAINT pk_clothes_code PRIMARY KEY (clothes_code),
    CONSTRAINT fk_category_code FOREIGN KEY (category_code) REFERENCES tbl_category (category_code)
) ENGINE=INNODB COMMENT '옷';

CREATE TABLE IF NOT EXISTS tbl_order
(
	order_code INT AUTO_INCREMENT COMMENT '주문코드',
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '주문날짜',
    clothes_code INT NOT NULL COMMENT '옷코드',
    order_clothes_price INT COMMENT '주문가격',
    order_clothes_amount INT COMMENT '주문수량',
    CONSTRAINT pk_order_code PRIMARY KEY (order_code),
	CONSTRAINT fk_clothes_code FOREIGN KEY (clothes_code) REFERENCES tbl_clothes (clothes_code)
)ENGINE=INNODB COMMENT '주문';


INSERT INTO tbl_category VALUES (null, '원피스');
INSERT INTO tbl_category VALUES (null, '정장');
INSERT INTO tbl_category VALUES (null, '드레스');
INSERT INTO tbl_category VALUES (null, '잠옷');

INSERT INTO tbl_category VALUES (null, '후드티');
INSERT INTO tbl_category VALUES (null, '셔츠');
INSERT INTO tbl_category VALUES (null, '외투');
INSERT INTO tbl_category VALUES (null, '티셔츠');
INSERT INTO tbl_category VALUES (null, '맨투맨');

INSERT INTO tbl_category VALUES (null, '바지');
INSERT INTO tbl_category VALUES (null, '치마');
INSERT INTO tbl_category VALUES (null, '멜빵');

INSERT INTO tbl_clothes VALUES (null,'로랑롱원피스',23400,1,'Y');
INSERT INTO tbl_clothes VALUES (null,'냉장고끈원피스',7900,1,'N');

INSERT INTO tbl_clothes VALUES (null,'트러수트정장',89000,2,'Y');
INSERT INTO tbl_clothes VALUES (null,'미라클정장',123000,2,'Y');

INSERT INTO tbl_clothes VALUES (null,'브이넥새틴드레스',38500,3,'Y');
INSERT INTO tbl_clothes VALUES (null,'한복드레스',43220,3,'N');

INSERT INTO tbl_clothes VALUES (null,'토토와모모잠옷',23980,4,'N');
INSERT INTO tbl_clothes VALUES (null,'산리오캐릭터즈',38390,4,'Y');

INSERT INTO tbl_clothes VALUES (null,'예일후드티',79000,5,'Y');
INSERT INTO tbl_clothes VALUES (null,'챔피온후드티',25000,5,'Y');

INSERT INTO tbl_clothes VALUES (null,'플란넬체크셔츠',39900,6,'Y');
INSERT INTO tbl_clothes VALUES (null,'크롭데님셔츠',71910,6,'N');

INSERT INTO tbl_clothes VALUES (null,'떡볶이코트',64990,7,'Y');
INSERT INTO tbl_clothes VALUES (null,'Ma-1블루종점퍼',19110,7,'Y');

INSERT INTO tbl_clothes VALUES (null,'크루넥반팔티셔츠',6560,8,'Y');
INSERT INTO tbl_clothes VALUES (null,'스투시반팔티셔츠',55000,8,'Y');

INSERT INTO tbl_clothes VALUES (null,'아미하트로고맨투맨',103200,9,'Y');
INSERT INTO tbl_clothes VALUES (null,'메종키츠네맨투맨',134000,9,'Y');

INSERT INTO tbl_clothes VALUES (null,'테이퍼드치노팬츠',20400,10,'N');
INSERT INTO tbl_clothes VALUES (null,'코듀로이버뮤다팬츠',19500,10,'Y');

INSERT INTO tbl_clothes VALUES (null,'카고포켓스커트',39900,11,'Y');
INSERT INTO tbl_clothes VALUES (null,'데님롱스커트',34390,11,'Y');

INSERT INTO tbl_clothes VALUES (null,'통바지데님멜빵바지',10040,12,'Y');
INSERT INTO tbl_clothes VALUES (null,'비치팜와이드점프수트',28800,12,'Y');

COMMIT;
