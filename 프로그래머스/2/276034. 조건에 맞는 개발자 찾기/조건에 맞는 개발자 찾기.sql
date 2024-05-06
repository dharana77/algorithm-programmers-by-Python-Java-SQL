-- 코드를 작성해주세요
# set @stack = 10100000000




select id, email, first_name, last_name from developers d where (select code from skillcodes where name = "C#") & d.skill_code or (select code from skillcodes where name = "Python") & d.skill_code order by id asc