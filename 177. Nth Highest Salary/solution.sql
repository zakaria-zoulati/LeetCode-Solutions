CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE a INT;
    SET a = N - 1;
    RETURN (
        SELECT distinct salary
        FROM Employee
        order by salary DESC
        LIMIT 1 OFFSET a
    );
END;
