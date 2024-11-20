package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchTimeCard_TestRegularPay() {
        //arrange
        Employee employee = new Employee(1, "John Doe", "IT", 85.00);
        //act
        employee.punchTimeCard(9);
        employee.punchTimeCard(17);

        double expectedPay = 8 * 85.00;
        //assertion
        assertEquals(expectedPay, employee.getTotalPay());
    }

}