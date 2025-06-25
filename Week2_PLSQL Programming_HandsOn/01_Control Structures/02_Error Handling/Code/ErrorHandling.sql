SET SERVEROUTPUT ON;
DROP TABLE CUSTOMERS CASCADE CONSTRAINTS;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance INT,
    LastModified DATE,
    IsVIP CHAR(1)
);
CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR2(20),
    Balance INT,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    AccountID INT,
    TransactionDate DATE,
    Amount INT,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
DROP TABLE Loans CASCADE CONSTRAINTS;

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    LoanAmount INT,
    InterestRate INT,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
DROP TABLE Employees CASCADE CONSTRAINTS;
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary INT,
    Department VARCHAR2(50),
    DepartmentID INT,
    HireDate DATE
);
CREATE TABLE ErrorLogs (
    ErrorID INT PRIMARY KEY,
    ErrorMessage VARCHAR2(255),
    ErrorDate DATE
);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1963-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 10000, 5, SYSDATE, SYSDATE + 25);

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_acc_id IN NUMBER,
    p_to_acc_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
    v_err_msg VARCHAR2(512);
BEGIN
    SELECT Balance INTO v_balance FROM Accounts
    WHERE AccountID = p_from_acc_id FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_acc_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_acc_id;

    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        v_err_msg := SQLERRM;
        INSERT INTO ErrorLogs(ErrorID, ErrorMessage, ErrorDate)
        VALUES (ErrorLogSeq.NEXTVAL, v_err_msg, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || v_err_msg);
END;
/
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_emp_id IN NUMBER,
    p_percent IN NUMBER
) IS
    v_old_salary NUMBER;
    v_err_msg VARCHAR2(255);
BEGIN

    SELECT Salary INTO v_old_salary
    FROM Employees
    WHERE EmployeeID = p_emp_id;

    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_emp_id;

    DBMS_OUTPUT.PUT_LINE('Salary updated for Employee ID: ' || p_emp_id);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        v_err_msg := 'Employee not found: ' || p_emp_id;
        INSERT INTO ErrorLogs(ErrorID, ErrorMessage, ErrorDate)
        VALUES (ErrorLogSeq.NEXTVAL, v_err_msg, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || v_err_msg);

    WHEN OTHERS THEN
        v_err_msg := SQLERRM;
        INSERT INTO ErrorLogs(ErrorID, ErrorMessage, ErrorDate)
        VALUES (ErrorLogSeq.NEXTVAL, v_err_msg, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || v_err_msg);
END;
/
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_cust_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) IS
    v_err_msg VARCHAR2(255);
BEGIN
    INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_cust_id, p_name, p_dob, p_balance, SYSDATE);

    DBMS_OUTPUT.PUT_LINE('Customer inserted successfully. ID: ' || p_cust_id);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        v_err_msg := 'Duplicate Customer ID: ' || p_cust_id;
        INSERT INTO ErrorLogs(ErrorID, ErrorMessage, ErrorDate)
        VALUES (ErrorLogSeq.NEXTVAL, v_err_msg, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || v_err_msg);

    WHEN OTHERS THEN
        v_err_msg := SQLERRM;
        INSERT INTO ErrorLogs(ErrorID, ErrorMessage, ErrorDate)
        VALUES (ErrorLogSeq.NEXTVAL, v_err_msg, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || v_err_msg);
END;
/
SELECT AccountID, Balance FROM Accounts WHERE AccountID = 1;
UPDATE Accounts
SET Balance = 2000
WHERE AccountID = 1;

COMMIT;


BEGIN
    SafeTransferFunds(1, 2, 1000);
END;
/
BEGIN
    UpdateSalary(99, 15);  
END;
/
BEGIN
    AddNewCustomer(1, 'Test Customer', TO_DATE('1995-01-01', 'YYYY-MM-DD'), 2000); 
END;
/
