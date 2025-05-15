Queries
a) Retrieve all students

SELECT * FROM Students;
b) Display only the FirstName and Email of all students


SELECT FirstName, Email FROM Students;
c) List all courses with exactly 4 credits

SELECT * FROM Courses WHERE Credits = 4;
d) Show all students born after January 1, 2000

SELECT * FROM Students WHERE DateOfBirth > '2000-01-01';
e) List students whose first name starts with "J"

SELECT * FROM Students WHERE FirstName LIKE 'J%';
f) Find the number of students enrolled in each course

SELECT CourseID, COUNT(StudentID) AS StudentCount 
FROM Enrollments 
GROUP BY CourseID;
g) Display students and their enrollment dates

SELECT s.FirstName, s.LastName, e.EnrollmentDate 
FROM Students s 
JOIN Enrollments e ON s.StudentID = e.StudentID;
h) List unique course IDs from the Enrollments table

SELECT DISTINCT CourseID FROM Enrollments;
i) Find all students who are enrolled in CourseID 102

SELECT s.* 
FROM Students s 
JOIN Enrollments e ON s.StudentID = e.StudentID 
WHERE e.CourseID = 102;
j) Display students ordered by LastName alphabetically

SELECT * FROM Students ORDER BY LastName ASC;
k) List all students who have not enrolled in any course

SELECT * 
FROM Students 
WHERE StudentID NOT IN (SELECT StudentID FROM Enrollments);
l) Show the average number of credits across all courses

SELECT AVG(Credits) AS AverageCredits FROM Courses;
m) List the top 3 most recently enrolled students

SELECT s.* 
FROM Students s 
JOIN Enrollments e ON s.StudentID = e.StudentID 
ORDER BY e.EnrollmentDate DESC 
LIMIT 3;
n) Find all courses with names containing the word 'Data'

SELECT * FROM Courses WHERE CourseName LIKE '%Data%';
o) Display the youngest student in the database

SELECT * 
FROM Students 
ORDER BY DateOfBirth DESC 
LIMIT 1;
p) Count the number of students with the same last name

SELECT LastName, COUNT(*) AS Count 
FROM Students 
GROUP BY LastName 
HAVING COUNT(*) > 1;
q) List courses along with the total number of enrolled students, sorted by count descending

SELECT c.CourseName, COUNT(e.StudentID) AS StudentCount 
FROM Courses c 
LEFT JOIN Enrollments e ON c.CourseID = e.CourseID 
GROUP BY c.CourseID, c.CourseName 
ORDER BY StudentCount DESC;
r) Find students who share the same first name

SELECT FirstName, COUNT(*) AS Count 
FROM Students 
GROUP BY FirstName 
HAVING COUNT(*) > 1;
s) Display enrollments made in the current year

SELECT * 
FROM Enrollments 
WHERE YEAR(EnrollmentDate) = YEAR(CURDATE());
t) List students along with the names of the courses they are enrolled in

SELECT s.FirstName, s.LastName, c.CourseName 
FROM Students s 
JOIN Enrollments e ON s.StudentID = e.StudentID 
JOIN Courses c ON e.CourseID = c.CourseID;
