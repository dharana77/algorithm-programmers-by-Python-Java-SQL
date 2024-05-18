-- 코드를 작성해주세요

select sum(score) as score, b.emp_no, a.emp_name, a.position, a.email from hr_employees a join hr_grade b on a.emp_no = b.emp_no group by b.emp_no order by sum(score) desc limit 1 