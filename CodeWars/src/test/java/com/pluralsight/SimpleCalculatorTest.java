package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @org.junit.jupiter.api.Test
    void divideTwoNumbers_positiveResults() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        double result = simpleCalculator.divideTwoNumbers(6,2);
        assertEquals(3, result);
    }

    @Test
    void divideTwoNumbers_positiveNegative(){
        //arrange
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        //act
        double result = simpleCalculator.divideTwoNumbers(6,-2);
        //assert
        assertEquals(-3, result);
    }

    @Test
    void divideTwoNumbers_divisionByZero(){
        //arrange
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        //act
        double result = simpleCalculator.divideTwoNumbers(6,0);

        if (Double.isInfinite(result)){
            System.out.println("The result is infinity");
        } else {
            System.out.println("Result is : " + result);
        }
        //assert
        assertEquals(Double.POSITIVE_INFINITY, result);
    }


}