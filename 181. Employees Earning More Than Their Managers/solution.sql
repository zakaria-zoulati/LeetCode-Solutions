SELECT e.name AS Employee FROM Employee e INNER JOIN Employee m ON e.managerid = m.id WHERE e.salary > m.salary;

