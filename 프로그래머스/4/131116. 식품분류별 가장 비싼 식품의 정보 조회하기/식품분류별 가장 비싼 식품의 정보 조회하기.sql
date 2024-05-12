-- 코드를 입력하세요
SELECT category, price as max_price, product_name from 
food_product where (category, price) in 
(
    select category, max(price) from food_product
    group by category
    having category in ("국", "과자", "김치", "식용유")
)
group by category
order by max_price desc