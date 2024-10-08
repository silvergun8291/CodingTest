WITH MAX_SIZE AS (
    SELECT
        YEAR(DIFFERENTIATION_DATE) AS YEAR,
        MAX(SIZE_OF_COLONY) AS MAX_SIZE
    FROM
        ECOLI_DATA
    GROUP BY
        YEAR
)

SELECT
    M.YEAR,
    M.MAX_SIZE - E.SIZE_OF_COLONY AS YEAR_DEV,
    E.ID
FROM
    MAX_SIZE AS M
JOIN
    ECOLI_DATA AS E
    ON M.YEAR = YEAR(E.DIFFERENTIATION_DATE)
ORDER BY
    M.YEAR,
    YEAR_DEV;