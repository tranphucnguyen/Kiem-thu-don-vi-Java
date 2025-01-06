package com.example.demo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-2, 1));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-3, calculator.subtract(-2, 1));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(2, 0));
    }

    @Test
    public void testDivision() {
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
        
        // Kiểm tra ngoại lệ khi chia cho 0
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        
        // Chỉnh sửa thông báo lỗi mong đợi thành "Cannot divide by zero"
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
