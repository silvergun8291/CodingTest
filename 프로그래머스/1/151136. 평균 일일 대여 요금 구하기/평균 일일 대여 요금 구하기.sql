-- 코드를 입력하세요
SELECT
    ROUND(AVG(daily_fee)) AS AVERAGE_FEE
FROM
    CAR_RENTAL_COMPANY_CAR
WHERE
    car_type='SUV';