# Write your MySQL query statement below
SELECT      question_id AS survey_log
FROM        survey_log AS sl1
INNER JOIN  (SELECT question_id as qid,
             COUNT(answer_id) as num_ans
             FROM survey_log 
             WHERE action='answer' 
             GROUP BY question_id
            ) AS answers                                    --  Gets the number of answers per question
ON          answers.qid = sl1.question_id
LEFT JOIN  (SELECT question_id AS qid,
             COUNT(action)AS num_shows
             FROM survey_log 
             WHERE action='show' 
             GROUP BY question_id
            ) AS shows                                      -- Gets the number of showes per question
ON          shows.qid = sl1.question_id
ORDER BY    answers.num_ans/IFNULL(shows.num_shows,1) DESC  -- Avoid divide by 0 (zero)
LIMIT       1;