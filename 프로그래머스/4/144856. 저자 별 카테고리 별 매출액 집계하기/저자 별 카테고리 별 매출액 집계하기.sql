-- 코드를 입력하세요
SELECT a.author_id, c.author_name, a.category, sum(b.sales * a.price) as total_sales from book a join book_sales b on a.book_id = b.book_id join author c on a.author_id = c.author_id where year(b.sales_date) =2022 and month(b.sales_date) = 1 group by a.author_id, a.category order by a.author_id asc, a.category desc

