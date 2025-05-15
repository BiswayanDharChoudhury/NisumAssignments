-- Sample for employee
INSERT INTO Employee (employee_id, name, email, department, designation)
VALUES (1, 'John Doe', 'john@example.com', 'IT', 'Manager'),
       (2, 'Jane Smith', 'jane@example.com', 'HR', 'Analyst');

-- Sample for studentDetails
INSERT INTO studentDetails (student_id, course_id, email, name)
VALUES (101, 1, 'stu1@example.com', 'Alice'),
       (102, 2, 'stu2@example.com', 'Bob');

-- Sample for salary
INSERT INTO SalaryDetails (salary_id, employee_id, salary)
VALUES (1, 1, 70000.00),
       (2, 2, 50000.00);

-- Sample for course
CREATE TABLE Course (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    credits INT
);

INSERT INTO Course (course_id, course_name, credits)
VALUES (1, 'Database Systems', 3),
       (2, 'Operating Systems', 4);
