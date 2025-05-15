CREATE TABLE studentDetails (
    student_id INT,
    course_id INT NOT NULL,
    email VARCHAR(100) UNIQUE,
    name VARCHAR(100),
    PRIMARY KEY (student_id, course_id)
);
