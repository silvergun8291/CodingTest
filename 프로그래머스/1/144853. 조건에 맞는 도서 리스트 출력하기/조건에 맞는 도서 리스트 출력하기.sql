-- 코드를 입력하세요
SELECT
    BOOK_ID,
    SUBSTR(PUBLISHED_DATE, 1, 10) AS PUBLISHED_DATE
FROM
    BOOK
WHERE
    CATEGORY='인문' AND SUBSTR(PUBLISHED_DATE, 1, 4) = '2021';