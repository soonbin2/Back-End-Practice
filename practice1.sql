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