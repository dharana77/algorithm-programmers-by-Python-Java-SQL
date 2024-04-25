-- 코드를 입력하세요
SELECT a.title, a.board_id, b.reply_id, b.writer_id, b.contents, date_format(b.created_date, "%Y-%m-%d")
from used_goods_board as a join used_goods_reply as b on a.board_id = b.board_id
where year(a.created_date) = 2022 and month(a.created_date) = 10
order by b.created_date asc, a.title asc 