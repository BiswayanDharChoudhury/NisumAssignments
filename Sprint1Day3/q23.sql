CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Email VARCHAR(100)
);

CREATE TABLE Courses (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(100),
    Credits INT
);

CREATE TABLE Enrollments (
    EnrollmentID INT PRIMARY KEY,
    StudentID INT,
    CourseID INT,
    EnrollmentDate DATE,
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

-- Sample inserts (2-3 shown, you can extend with loops or CSVs)
INSERT INTO Students VALUES (1, 'Alice', 'Brown', '2002-01-10', 'alice@example.com'),
                            (2, 'Bob', 'Smith', '2001-06-15', 'bob@example.com');

INSERT INTO Courses VALUES (101, 'Math', 4), (102, 'Physics', 3);

INSERT INTO Enrollments VALUES (1, 1, 101, '2025-01-01'),
                               (2, 2, 102, '2025-01-02');
