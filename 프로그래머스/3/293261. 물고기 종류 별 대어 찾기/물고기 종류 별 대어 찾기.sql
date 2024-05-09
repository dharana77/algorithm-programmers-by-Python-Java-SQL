-- 코드를 작성해주세요

with mx as(
    select fish_type, max(fi.length) as mx_length from fish_info fi group by fi.fish_type 
)

select fi.id, fni.fish_name, mx.mx_length as length from fish_info fi join fish_name_info fni on fni.fish_type = fi.fish_type join mx on mx.mx_length = fi.length and fi.fish_type = mx.fish_type order by id