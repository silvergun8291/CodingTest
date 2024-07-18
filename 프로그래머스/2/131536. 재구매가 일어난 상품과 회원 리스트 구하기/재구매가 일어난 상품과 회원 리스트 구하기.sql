SELECT 
    user_id, 
    product_id
FROM
    ONLINE_SALE
GROUP BY
    user_id, 
    product_id
HAVING
    COUNT(*) > 1
ORDER BY
    user_id,
    product_id DESC;