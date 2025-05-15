
SELECT * FROM Courses
WHERE credits = (SELECT MAX(credits) FROM Courses);

SELECT * FROM SalaryDetails
WHERE salary > (SELECT AVG(salary) FROM SalaryDetails);
