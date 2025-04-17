SELECT
(
    SELECT DISTINCT salary As secondHighestsalary
    From Employee
    Order by SALARY Desc
    LIMIT 1, 1
)As secondHighestsalary;