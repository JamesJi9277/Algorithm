# Write your MySQL query statement below

SELECT
Score, (SELECT COUNT(*) FROM (SELECT DISTINCT Score s FROM Scores s2) TMP WHERE s >= Score) as Rank
FROM Scores s1
ORDER BY Score desc