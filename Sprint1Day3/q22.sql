-- INNER JOIN
SELECT s.name, c.course_name
FROM studentDetails s
JOIN Course c ON s.course_id = c.course_id;

-- LEFT JOIN
SELECT s.name, c.course_name
FROM studentDetails s
LEFT JOIN Course c ON s.course_id = c.course_id;

-- RIGHT JOIN
SELECT s.name, c.course_name
FROM studentDetails s
RIGHT JOIN Course c ON s.course_id = c.course_id;

-- FULL OUTER JOIN (PostgreSQL)
SELECT s.name, c.course_name
FROM studentDetails s
FULL OUTER JOIN Course c ON s.course_id = c.course_id;
