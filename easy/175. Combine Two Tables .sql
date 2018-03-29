# Write your MySQL query statement below
SELECT p.FirstName as FirstName, p.LastName as LastName, a.City as City, a.State as State
FROM Person as p
LEFT JOIN Address as a
ON p.PersonId = a.PersonId;