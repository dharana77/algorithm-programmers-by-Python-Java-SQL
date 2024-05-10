with dis as (
    select max(size_of_colony) as mx, year(differentiation_date) as year from ecoli_data group by year(differentiation_date)
)


select year(a.DIFFERENTIATION_DATE) AS year,
       (dis.mx - a.SIZE_OF_COLONY) AS year_dev,
       a.ID
FROM ecoli_data a
join dis on dis.year = year(a.differentiation_date)
order by year asc, year_dev asc

# select e.id, year(e.differentiation_date) as year from ecoli_data as e join dis on dis.year = e.year
