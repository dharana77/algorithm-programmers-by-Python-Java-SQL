-- 코드를 입력하세요
select round(sum(daily_fee)/ count(car_id)) as AVERAGE_FEE from car_rental_company_car where car_type = 'SUV'

# select sum(daily_fee) from car_rental_company_car where car_type = "SUV"