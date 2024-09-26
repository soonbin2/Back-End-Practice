-- employees 
-- 테이블:
-- id
-- name
-- department_id


-- departments 
-- 테이블:
-- id
-- department_name


-- employees 테이블과 departments 테이블을 JOIN하여 각 직원의 이름과 소속 부서명을 가져오는 SQL 쿼리를 작성해 보세요. 

SELECT
		E.NAME,
        D.DEPARTMENT_NAME
   FROM EMPLOYEES E
   JOIN DEPARTMENTS D ON E.DEPARTMNET_ID = D.ID;
   
-- orders 테이블:

-- id
-- customer_id
-- total_amount

-- customers 테이블:

-- id
-- name
-- 각 고객의 총 주문 금액이 1000 이상인 고객의 이름을 가져오는 서브쿼리를 사용해 작성해 보세요.

SELECT
		C.NAME
   FROM CUSTOMERS C
   WHERE C.ID IN (
		SELECT
				O.CUSTOMER_ID
		   FROM ORDERS O
           GROUP BY O.CUSTOMER_ID
           HAVING SUM(O.TOTAL_AMOUNT) >=1000
   );

								
                                
                                