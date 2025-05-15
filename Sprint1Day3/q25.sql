Using JOINS
a) List all students along with the courses they are enrolled in.

SELECT s.FirstName, s.LastName, c.CourseName 
FROM Students s 
JOIN Enrollments e ON s.StudentID = e.StudentID 
JOIN Courses c ON e.CourseID = c.CourseID;
b) List all courses and the students enrolled in them (include courses with no enrollments)

SELECT c.CourseName, s.FirstName, s.LastName 
FROM Courses c 
LEFT JOIN Enrollments e ON c.CourseID = e.CourseID 
LEFT JOIN Students s ON e.StudentID = s.StudentID;
c) Show all students who have not enrolled in any course

SELECT s.* 
FROM Students s 
LEFT JOIN Enrollments e ON s.StudentID = e.StudentID 
WHERE e.EnrollmentID IS NULL;
d) List course names along with the count of enrolled students using JOIN

SELECT c.CourseName, COUNT(e.StudentID) AS StudentCount 
FROM Courses c 
LEFT JOIN Enrollments e ON c.CourseID = e.CourseID 
GROUP BY c.CourseName;

e) Show each students full name and all course names they are enrolled in, ordered by student name

SELECT CONCAT(s.FirstName, ' ', s.LastName) AS FullName, c.CourseName 
FROM Students s 
JOIN Enrollments e ON s.StudentID = e.StudentID 
JOIN Courses c ON e.CourseID = c.CourseID 
ORDER BY FullName;
f) List students and enrollment details using INNER JOIN

SELECT s.FirstName, s.LastName, e.EnrollmentDate 
FROM Students s 
INNER JOIN Enrollments e ON s.StudentID = e.StudentID;
g) List all courses with student names using LEFT JOIN

SELECT c.CourseName, s.FirstName, s.LastName 
FROM Courses c 
LEFT JOIN Enrollments e ON c.CourseID = e.CourseID 
LEFT JOIN Students s ON e.StudentID = s.StudentID;
h) List student names and their course names using RIGHT JOIN

SELECT s.FirstName, s.LastName, c.CourseName 
FROM Courses c 
RIGHT JOIN Enrollments e ON c.CourseID = e.CourseID 
RIGHT JOIN Students s ON e.StudentID = s.StudentID;
i) Show students and courses using FULL OUTER JOIN

SELECT s.FirstName, c.CourseName 
FROM Students s 
LEFT JOIN Enrollments e ON s.StudentID = e.StudentID 
LEFT JOIN Courses c ON e.CourseID = c.CourseID

UNION

SELECT s.FirstName, c.CourseName 
FROM Courses c 
LEFT JOIN Enrollments e ON c.CourseID = e.CourseID 
LEFT JOIN Students s ON e.StudentID = s.StudentID;

j) Find students who are enrolled in both 'Database Systems' and 'Data Structures'

SELECT s.FirstName, s.LastName 
FROM Students s
JOIN Enrollments e1 ON s.StudentID = e1.StudentID
JOIN Courses c1 ON e1.CourseID = c1.CourseID
JOIN Enrollments e2 ON s.StudentID = e2.StudentID
JOIN Courses c2 ON e2.CourseID = c2.CourseID
WHERE c1.CourseName = 'Database Systems'
  AND c2.CourseName = 'Data Structures';
