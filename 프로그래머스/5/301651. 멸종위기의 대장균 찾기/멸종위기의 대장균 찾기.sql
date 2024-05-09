-- 코드를 작성해주세요
with recursive cte as (
    select id, parent_id, 1 as generation 
    from ecoli_data
    where parent_id is null
    
    union all
    
    select a.id, a.parent_id, 1 + B.generation generaton
    from ecoli_data a
    join cte b on a.parent_id = b.id
)

select count(cte.id) as count, cte.generation from cte left join ecoli_data b on cte.id = b.parent_id where b.parent_id is null group by cte.generation order by cte.generation