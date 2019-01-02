# Write your MySQL query statement below
SELECT p.FirstName as FirstName, p.LastName as LastName, a.City as City, a.State as State
from Person p
left join Address a
on p.PersonId = a.PersonId;

The LEFT JOIN keyword returns all records from the left table (table1), and the matched records from the right table (table2). The result is NULL from the right side, if there is no match.

FULL OUTER JOIN