# Write your MySQL query statement below
select w1.id as Id
from Weather w1, Weather w2
where w1.Temperature > w2.Temperature and TO_DAYS(w1.Date) - TO_DAYS(w2.Date) = 1;


TO_DAYS and subdate