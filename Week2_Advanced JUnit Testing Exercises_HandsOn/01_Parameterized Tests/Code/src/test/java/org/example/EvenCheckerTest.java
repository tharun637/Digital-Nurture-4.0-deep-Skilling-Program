package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {
    private final EvenChecker even=new EvenChecker();
    @ParameterizedTest
    @ValueSource(ints={2,4,6,8,10,0,-2,-6})
    void testEven(int number){
        Assertions.assertTrue(even.iseven(number),number+"should be even..");
    }
    @ParameterizedTest
    @ValueSource(ints={1,3,5,7,9,-3,-5})
    void testodd(int number){
        Assertions.assertFalse(even.iseven(number),number+"should be odd...");
    }
}