create table employees
(
    employee_id integer,
    first_name varchar(20),
    last_name varchar(25) not null,
    email varchar(25) not null
        constraint emp_email_uk
            unique,
    phone_number varchar(20),
    hire_date date not null,
    salary numeric(8, 2)
        constraint emp_salary_min
            check (salary > (0)::numeric),
    commission_pct numeric(2, 2),
    department_id integer
);



INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, salary, commission_pct, department_id)
VALUES
-- Сотрудники для отдела 50 (задания 1, 3)
(1,  'Anna',               'Smith',      'anna@comp.com',       '123.456.7890', '2023-05-10', 5000.00,  NULL,  50),  -- подходит под 1 (>4000), под 2 (посл. 'a')
(2,  'John',               'Johnson',    'john@comp.com',       '222.333.4444', '2023-05-10', 4000.00,  NULL,  50),  -- не подходит под 1 (ровно 4000)
(3,  'Eva',                'Williams',   'eva@comp.com',        '555.1234',     '2023-05-10', 3000.00,  0.10,  50),  -- подходит под 2 ('a'), под 3 (бонус)
(4,  'Bob',                'Brown',      'bob@comp.com',        '111.222.3333', '2023-05-10', 4500.00,  NULL,  50),  -- подходит под 1
(5,  'Mike',               'Jones',      'mike@comp.com',       '999.888.7777', '2023-05-10', 5000.00,  NULL,  50),  -- подходит под 1, дубликат зарплаты с emp1 (задание 6)

-- Сотрудники для отдела 80 (задания 3, 6)
(6,  'Maria',              'Garcia',     'maria@comp.com',      '333.444.5555', '2023-05-10', 6000.00,  0.20,  80),  -- подходит под 2 ('a'), под 3 (бонус)
(7,  'Nikita',             'Miller',     'nikita@comp.com',     '666.777.8888', '2023-05-10', 6000.00,  NULL,  80),  -- подходит под 2 ('a'), дубликат зарплаты с emp6 (задание 6)
(8,  'Alex',               'Davis',      'alex@comp.com',       '000.000.0000', '2023-05-10', 7000.00,  0.15,  80),  -- подходит под 3 (бонус)

-- Сотрудники для отдела 10 (задания 4, 6, 7, 2 – заглавная 'A')
(9,  'ANNA',               'Rodriguez',  'anna2@comp.com',      '111.222.3333', '2023-05-10', 10000.00, 0.30,  10),  -- бонус есть, но отдел не 50/80 (не попадёт в 3), посл. 'A' (строчная?)
(10, 'VeryLongName12345678','Martinez',  'long1@comp.com',      '222.333.4444', '2023-05-10', 10000.00, NULL,  10),  -- дубликат зарплаты 10000 в 10 отделе, самое длинное имя (20) – задание 7
(11, 'VeryLongName12345678','Hernandez', 'long2@comp.com',      '333.444.5555', '2023-05-10', 10000.00, NULL,  10),  -- дубликат зарплаты 10000, самое длинное имя (20) – задание 7
(12, 'Katherine',          'Lopez',      'katherine@comp.com',  'no_dots_here', '2023-05-10', 8500.00,  NULL,  10),  -- подходит под 4 (между 8k-9k), без точек в телефоне
(13, 'Zoe',                'Gonzalez',   'zoe@comp.com',        '1234567890',   '2023-05-10', 8000.00,  NULL,  10),  -- подходит под 4 (граница 8000)
(14, 'Max',                'Wilson',     'max@comp.com',        '111.222.3333', '2023-05-10', 9000.00,  NULL,  10),  -- подходит под 4 (граница 9000)
(15, 'Sam',                'Anderson',   'sam@comp.com',        '999.000.1111', '2023-05-10', 9000.01,  NULL,  10),  -- не подходит под 4 (вне диапазона)
(16, 'Lucy',               'Thomas',     'lucy@comp.com',       '888.777.6666', '2023-05-10', 7999.99,  NULL,  50),  -- зарплата вне 4, но для отдела 50
(17, 'Tiny',               'Taylor',     'tiny@comp.com',       '123.123.1234', '2023-05-10', 0.01,     NULL,  80);  -- минимальная допустимая зарплата, отдел 80

SELECT * FROM employees WHERE department_id = 50 AND salary > 4000;
--1. Получить список всех сотрудников из 50го отдела (department_id) с зарплатой(salary), большей 4000.

SELECT * FROM employees WHERE first_name LIKE '%a';
--2. Получить список всех сотрудников у которых последняя буква в имени равна 'a'.

SELECT * FROM employees WHERE department_id IN (50,80) AND commission_pct IS NOT NULL;
--3. Получить список всех сотрудников из 50го и из 80го отдела (department_id) у которых есть бонус
-- (значение в колонке commission_pct не пустое).

SELECT * FROM employees WHERE salary BETWEEN 8000 AND 9000;
--4. Получить список всех сотрудников у которых зарплата находится в промежутке от 8000 до 9000 (включительно).

SELECT *, REPLACE(phone_number, '.', '-') AS formatted_phone FROM employees;
--5. Получить список всех сотрудников заменив в значении PHONE_NUMBER все '.' на '-'.

SELECT department_id, salary, COUNT(*) AS employees_count FROM employees GROUP BY department_id, salary HAVING COUNT(*) > 1;
--6. Сколько сотрудников, которые работают в одном и том же отделе и получают одинаковую зарплату?

SELECT * FROM employees WHERE LENGTH(first_name) = (SELECT MAX(LENGTH(first_name)) FROM employees);
--7. Получить список сотрудников с самым длинным именем.
