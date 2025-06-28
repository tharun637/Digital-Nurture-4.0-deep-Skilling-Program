package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationTest {
    private Calculation cal;

    @BeforeEach
    public void setup() {
        System.out.println("Setting Up Calculator...");
        cal = new Calculation();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down Calculator...");
        cal = null;
    }

    @Test
    public void testAddition() {
        int sum = cal.addition(10, 20);
        assertEquals(30, sum, "10 + 20 should be 30...");
    }

    @Test
    public void testSubtraction() {
        int sub = cal.subtraction(20, 10);
        assertEquals(10, sub, "20 - 10 should be 10...");
    }

    @Test
    public void testMultiplication() {
        int mul = cal.multiply(2, 5);
        assertEquals(10, mul, "2 * 5 should be 10...");
    }

    @Test
    public void testDivision() {
        int divide = cal.divide(10, 2);
        assertEquals(5, divide, "10 / 2 should be 5...");
    }

    @Test
    public void testDivideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cal.divide(10, 0);
        }, "Division by zero should throw IllegalArgumentException");
    }
}
