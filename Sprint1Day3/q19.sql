
SELECT COUNT(*) FROM Students;
SELECT AVG(credits) FROM Courses;
SELECT MAX(salary) FROM SalaryDetails;

SELECT course_id, COUNT(*) AS student_count
FROM studentDetails
GROUP BY course_id
HAVING COUNT(*) > 1;
