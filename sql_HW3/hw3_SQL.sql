USE a0726209_bank;

-- SQL_Part1
-- Упражнение 1
SELECT 
emp_id
, fname
, lname
FROM employee
ORDER BY lname, fname
 ;

-- Упражнение 2
SELECT account_id, cust_id, avail_balance 
FROM account 
WHERE status = 'ACTIVE' and avail_balance > 2500
; 

-- Упражнение 3
SELECT DISTINCT open_emp_id 
FROM account
;

-- Упражнение 4
SELECT * 
FROM account
WHERE open_date >= '2002-01-01' AND open_date <= '2002-12-31'
;

-- Упражнение 5
SELECT e.emp_id, e.fname, e.lname,
	(SELECT d.name FROM department d
    WHERE e.dept_id = d.dept_id) Department,
    (SELECT b.name FROM branch b
    WHERE e.assigned_branch_id = b.branch_id) Branch
FROM employee e
;

-- SQL_Part2
-- Упражнение 1
SELECT * FROM individual
WHERE lname LIKE '_a%e%'
;

-- Упражнение 2
SELECT e.emp_id, e.fname, e.lname
FROM employee e
INNER JOIN employee mgr ON e.superior_emp_id = mgr.emp_id
WHERE e.department_id <> mgr.department_id
;

-- Упражнение 3
SELECT a.account_id, c.fed_id, p.name product_name
FROM customer c 
JOIN account a ON c.cust_id = a.cust_id 
JOIN product p ON a.product_cd = p.product_cd
WHERE cust_type_cd = 'I'
;

-- Упражнение 4
SELECT c.cust_id, concat(i.fname, ' ', i.lname) 'fname lname', b.name name_department
FROM customer c
LEFT JOIN individual i ON c.cust_id = i.cust_id
LEFT JOIN business b ON c.cust_id = b.cust_id
;

-- Упражнение 5
SELECT a.account_id, concat(e.fname, ' ', e.lname) 'fname lname', open_date 
FROM account a
JOIN employee e ON a.open_emp_id = e.emp_id
WHERE e.lname = 'Markham' AND  Dayname(a.open_date) = 'Wednesday'
;
