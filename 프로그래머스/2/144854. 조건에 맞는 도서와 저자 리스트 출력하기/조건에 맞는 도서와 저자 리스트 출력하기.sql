select  
    B.BOOK_ID, 
    A.AUTHOR_NAME, 
    DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
from 
    book as b 
join author as a on b.author_id=a.author_id
where category='경제'
ORDER BY
    PUBLISHED_DATE;