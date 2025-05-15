CREATE TABLE Employee (
    employee_id INT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE SalaryDetails (
    salary_id INT PRIMARY KEY,
    employee_id INT,
    salary DECIMAL(10,2),
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);
