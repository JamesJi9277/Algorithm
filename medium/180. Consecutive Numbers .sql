# Write your MySQL query statement below
select distinct log1.Num as ConsecutiveNums
from Logs log1, Logs log2, Logs log3
where log1.Id = log2.Id - 1 and log2.Id = log3.Id - 1 and log1.Num = log2.Num and log2.Num = log3.Num;