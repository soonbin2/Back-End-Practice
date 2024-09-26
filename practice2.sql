-- JOIN을 이용하여 여러 테이블을 조회 시에는 모든 컬럼에 테이블 별칭을 사용하는 것이 좋다.

-- 1. 직급이 대리이면서 아시아 지역에 근무하는 직원의 사번, 이름, 직급명, 부서명, 지역명, 급여를 조회하세요 테이블은 employee, job, department,location
SELECT
		A.EMP_ID,
        A.EMP_NAME,
        B.JOB_NAME,
        C.DEPT_TITLE,
        D.LOCAL_NAME,
        A.SALARY
   FROM EMPLOYEE A
   JOIN JOB B ON B.JOB_CODE = A.JOB_CODE
   JOIN DEPARTMENT C ON C.DEPT_ID = A.DEPT_CODE
   JOIN LOCATION D ON D.LOCAL_CODE = C.LOCATION_ID
   WHERE B.JOB_NAME = '대리' AND D.LOCAL_NAME LIKE 'ASIA%';

-- 2. 주민번호가 70년대 생이면서 성별이 여자이고, 성이 전씨인 직원의 이름, 주민등록번호, 부서명, 직급명을 조회하세요.
SELECT
		A.EMP_NAME,
        A.EMP_NO,
        C.DEPT_TITLE,
        B.JOB_NAME
   FROM EMPLOYEE A
   JOIN JOB B ON B.JOB_CODE = A.JOB_CODE
   JOIN DEPARTMENT C ON C.DEPT_ID = A.DEPT_CODE
   WHERE A.EMP_NO LIKE '7%' AND A.EMP_NO LIKE '_______2%' AND A.EMP_NAME LIKE '전%';

-- 3. 이름에 '형'자가 들어가는 직원의 사번, 이름, 직급명을 조회하세요.
SELECT
		A.EMP_ID,
        A.EMP_NAME,
        B.DEPT_TITLE
   FROM EMPLOYEE A
   JOIN DEPARTMENT B ON A.DEPT_CODE = B.DEPT_ID
   WHERE EMP_NAME LIKE '%형%';

-- 4. 해외영업팀에 근무하는 직원의 이름, 직급명, 부서코드, 부서명을 조회하세요.
SELECT
		A.EMP_NAME,
        B.JOB_NAME,
        C.DEPT_ID,
        C.DEPT_TITLE
   FROM EMPLOYEE A
   JOIN JOB B ON B.JOB_CODE = A.JOB_CODE
   JOIN DEPARTMENT C ON C.DEPT_ID = A.DEPT_CODE
   WHERE C.DEPT_TITLE LIKE '해외영업%';
        
-- 5. 보너스포인트를 받는 직원의 이름, 보너스, 부서명, 지역명을 조회하세요.
SELECT
		A.EMP_NAME,
        A.BONUS,
        B.DEPT_TITLE,
        C.LOCAL_NAME
   FROM EMPLOYEE A
   JOIN DEPARTMENT B ON B.DEPT_ID = A.DEPT_CODE
   JOIN LOCATION C ON C.LOCAL_CODE = B.LOCATION_ID
   WHERE BONUS IS NOT NULL;

-- 6. 부서코드가 D2인 직원의 이름, 직급명, 부서명, 지역명을 조회하세오.
SELECT
		A.EMP_NAME,
        B.JOB_NAME,
        C.DEPT_TITLE,
        D.LOCAL_NAME
   FROM EMPLOYEE A
   JOIN JOB B ON B.JOB_CODE = A.JOB_CODE
   JOIN DEPARTMENT C ON C.DEPT_ID = A.DEPT_CODE
   JOIN LOCATION D ON D.LOCAL_CODE = C.LOCATION_ID
   WHERE C.DEPT_ID LIKE 'D2';

-- 7. 한국(KO)과 일본(JP)에 근무하는 직원의 이름, 부서명, 지역명, 국가명을 조회하세요.
SELECT
		A.EMP_NAME,
        B.DEPT_TITLE,
        C.LOCAL_NAME,
        D.NATIONAL_NAME
FROM EMPLOYEE A
JOIN DEPARTMENT B ON B.DEPT_ID = A.DEPT_CODE
JOIN LOCATION C ON C.LOCAL_CODE = B.LOCATION_ID
JOIN NATION D ON D.NATIONAL_CODE = C.NATIONAL_CODE
WHERE D.NATIONAL_CODE = 'KO' OR D.NATIONAL_CODE = 'JP';	
