
REPLACE INTO Employee (employee_id, name, email, department, designation)
VALUES (2, 'Jane Smith', 'jane_new@example.com', 'HR', 'Lead Analyst');

INSERT INTO Course (course_id, course_name, credits)
VALUES (2, 'OS', 5)
ON DUPLICATE KEY UPDATE credits = 5;
