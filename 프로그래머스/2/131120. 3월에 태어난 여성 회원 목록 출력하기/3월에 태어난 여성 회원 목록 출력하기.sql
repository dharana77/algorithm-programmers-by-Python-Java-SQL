-- 코드를 입력하세요
SELECT member_id, member_name, gender,date_format(date_of_birth, "%Y-%m-%d") from member_profile where gender = "W" and month(date_of_birth) = 3 and tlno != "" order by member_id asc