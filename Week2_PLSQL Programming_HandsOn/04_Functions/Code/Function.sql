
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    dob DATE
);

CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    loan_amount NUMBER,
    interest_rate NUMBER,
    duration_years NUMBER
);

CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER
);
INSERT INTO customers VALUES (101, 'John Doe', DATE '1995-06-15');
INSERT INTO customers VALUES (102, 'Jane Smith', DATE '1980-12-10');
INSERT INTO loans VALUES (201, 101, 100000, 10, 5);
INSERT INTO loans VALUES (202, 102, 50000, 8, 3);
INSERT INTO accounts VALUES (301, 101, 25000);
INSERT INTO accounts VALUES (302, 102, 4000);

CREATE OR REPLACE FUNCTION CalculateAge(dob DATE)
RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, dob) / 12);
    RETURN v_age;
END;
/
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    loan_amount NUMBER,
    annual_interest_rate NUMBER,
    loan_duration_years NUMBER
)
RETURN NUMBER
IS
    r NUMBER; 
    n NUMBER; 
    emi NUMBER;
BEGIN
    r := annual_interest_rate / 12 / 100;
    n := loan_duration_years * 12;
    emi := (loan_amount * r * POWER(1 + r, n)) / (POWER(1 + r, n) - 1);
    RETURN ROUND(emi, 2);
END;
/
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id NUMBER,
    p_amount NUMBER
)
RETURN BOOLEAN
IS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance FROM accounts WHERE account_id = p_account_id;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/
DECLARE
    result BOOLEAN;
BEGIN
    result := HasSufficientBalance(101, 5000);
    IF result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance');
    END IF;
END;
/

SELECT CalculateAge(DATE '2000-05-15') AS age FROM dual;
SELECT CalculateMonthlyInstallment(100000, 10, 5) AS monthly_emi FROM dual;

SET SERVEROUTPUT ON;
