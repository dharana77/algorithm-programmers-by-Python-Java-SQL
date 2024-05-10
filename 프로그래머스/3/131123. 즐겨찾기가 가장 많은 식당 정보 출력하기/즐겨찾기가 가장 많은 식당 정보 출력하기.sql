-- 코드를 입력하세요
# SELECT food_type, rest_id, rest_name, favorites from rest_info group by food_type having favorites = max(favorites) order by food_type desc


select r1.food_type, r1.rest_id, r1.rest_name, max(r1.favorites) as favorites from rest_info r1
join (
    select max(favorites) as mx, a.food_type from rest_info a
    group by a.food_type
) r2 on r1.favorites = r2.mx and r1.food_type = r2.food_type

group by r1.food_type order by r1.food_type desc