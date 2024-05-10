-- 코드를 입력하세요

select b.user_id, b.nickname, sum(price) as total_sales from used_goods_board a join used_goods_user b on a.writer_id = b.user_id where a.status = "DONE" group by b.user_id having total_sales >= 700000 order by total_sales asc