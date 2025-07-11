CREATE TABLE CUSTOMERS (
    CUSTOMER_ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(50),
    AGE NUMBER,
    BALANCE NUMBER(10,2),
    LOAN_INTEREST_RATE NUMBER(5,2),
    ISVIP CHAR(1) DEFAULT 'N'
);
INSERT INTO CUSTOMERS VALUES (101, 'Alic', 65, 12000, 7.5, 'N');
INSERT INTO CUSTOMERS VALUES (102, 'Bob', 58, 9500, 8.2, 'N');
INSERT INTO CUSTOMERS VALUES (103, 'Charlie', 72, 20000, 6.9, 'N');
INSERT INTO CUSTOMERS VALUES (104, 'David', 45, 10500, 7.3, 'N');

COMMIT;
CREATE TABLE LOANS (
    LOAN_ID NUMBER PRIMARY KEY,
    CUSTOMER_ID NUMBER,
    DUE_DATE DATE,
    FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID)
);
INSERT INTO LOANS VALUES (201, 101, SYSDATE + 10);  -- due in 10 days
INSERT INTO LOANS VALUES (202, 102, SYSDATE + 40);  -- due in 40 days
INSERT INTO LOANS VALUES (203, 103, SYSDATE + 25);  -- due in 25 days

COMMIT;
BEGIN
    FOR rec IN (SELECT CUSTOMER_ID, AGE, LOAN_INTEREST_RATE FROM CUSTOMERS) LOOP
        IF rec.AGE > 60 THEN
            UPDATE CUSTOMERS
            SET LOAN_INTEREST_RATE = rec.LOAN_INTEREST_RATE - 1
            WHERE CUSTOMER_ID = rec.CUSTOMER_ID;
        END IF;
    END LOOP;
    COMMIT;
END;
BEGIN
    FOR rec IN (SELECT CUSTOMER_ID, BALANCE FROM CUSTOMERS) LOOP
        IF rec.BALANCE > 10000 THEN
            UPDATE CUSTOMERS
            SET ISVIP = 'Y'
            WHERE CUSTOMER_ID = rec.CUSTOMER_ID;
        END IF;
    END LOOP;
    COMMIT;
END;
BEGIN
    FOR rec IN (
        SELECT LOAN_ID, CUSTOMER_ID, DUE_DATE
        FROM LOANS
        WHERE DUE_DATE <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ID ' || rec.CUSTOMER_ID ||
                             ', your loan ID ' || rec.LOAN_ID ||
                             ' is due on ' || TO_CHAR(rec.DUE_DATE, 'DD-MON-YYYY'));
    END LOOP;
END;

SET SERVEROUTPUT ON;






