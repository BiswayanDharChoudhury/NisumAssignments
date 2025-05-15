-- Single column
SELECT name FROM Students;

-- Multiple columns
SELECT name, student_id FROM Students;

-- All columns
SELECT * FROM Students;

-- WHERE condition
SELECT * FROM Students WHERE course_id = 1;

-- ORDER BY
SELECT * FROM Students ORDER BY name DESC;

-- LIMIT / FETCH
SELECT * FROM Students LIMIT 5; 

SELECT * FROM Courses WHERE credits BETWEEN 3 AND 5;
SELECT * FROM Students WHERE name BETWEEN 'A' AND 'L';

SELECT * FROM Students WHERE course_id IN (1, 2, 3);

SELECT * FROM Students WHERE name LIKE 'A%';
