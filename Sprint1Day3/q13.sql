-- Single update
UPDATE Employee
SET designation = 'Senior Manager'
WHERE employee_id = 1;

-- Multiple updates
UPDATE SalaryDetails
SET salary = salary + 5000
WHERE salary < 60000;
