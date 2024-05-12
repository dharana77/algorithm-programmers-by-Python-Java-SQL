# -- 코드를 입력하세요
# SELECT car_id, case when min(start_date) > "2022-10-16" or max(end_date) < "2022-10-16" then "대여가능" else "대여중" end as status from car_rental_company_rental_history group by car_id order by car_id desc

select car_id,  max(case when "2022-10-16" between start_date and end_date then "대여중" else "대여 가능" end) as availability from car_rental_company_rental_history group by car_id order by car_id desc