package com.example.demo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        // Kiểm tra giá trị dương
        assertEquals(5, calculator.add(2, 3));
        assertEquals(100, calculator.add(50, 50));

        // Kiểm tra giá trị âm
        assertEquals(-5, calculator.add(-2, -3));
        assertEquals(-1, calculator.add(-2, 1));

        // Kiểm tra giá trị 0
        assertEquals(0, calculator.add(0, 0));
        assertEquals(3, calculator.add(3, 0));

        // Kiểm tra biên lớn nhất
        assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE, 0));
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> calculator.add(Integer.MAX_VALUE, 1)); // Tràn số
        assertEquals("integer overflow", thrown.getMessage());
    }

    @Test
    public void testSubtraction() {
        // Kiểm tra giá trị dương
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(50, calculator.subtract(100, 50));

        // Kiểm tra giá trị âm
        assertEquals(1, calculator.subtract(-2, -3));
        assertEquals(-3, calculator.subtract(-2, 1));

        // Kiểm tra giá trị 0
        assertEquals(0, calculator.subtract(0, 0));
        assertEquals(3, calculator.subtract(3, 0));

        // Kiểm tra biên lớn nhất
        assertEquals(0, calculator.subtract(Integer.MAX_VALUE, Integer.MAX_VALUE));
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> calculator.subtract(Integer.MIN_VALUE, 1)); // Tràn số
        assertEquals("integer overflow", thrown.getMessage());
    }

    @Test
    public void testMultiplication() {
        // Kiểm tra giá trị dương
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(10000, calculator.multiply(100, 100));

        // Kiểm tra giá trị âm
        assertEquals(-6, calculator.multiply(-2, 3));
        assertEquals(6, calculator.multiply(-2, -3));

        // Kiểm tra giá trị 0
        assertEquals(0, calculator.multiply(0, 5));
        assertEquals(0, calculator.multiply(0, 0));

        // Kiểm tra biên lớn nhất
        assertEquals(0, calculator.multiply(Integer.MAX_VALUE, 0)); // Không tràn
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> calculator.multiply(Integer.MAX_VALUE, 2)); // Tràn số
        assertEquals("integer overflow", thrown.getMessage());
    }

    @Test
    public void testDivision() {
        // Kiểm tra giá trị dương
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
        assertEquals(2, calculator.divide(100, 50));

        // Kiểm tra giá trị âm
        assertEquals(-2.5, calculator.divide(-5, 2), 0.0001);
        assertEquals(2.5, calculator.divide(-5, -2), 0.0001);

        // Kiểm tra giá trị 0
        assertEquals(0, calculator.divide(0, 5), 0.0001); // Chia 0
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0)); // Ngoại lệ chia cho 0
        assertEquals("division by zero", thrown.getMessage());

        // Kiểm tra biên lớn nhất
        assertEquals(1, calculator.divide(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(0.0, calculator.divide(Integer.MIN_VALUE, Integer.MAX_VALUE), 0.0001); // Chia nhỏ
    }


    

    @Test
    public void testEdgeCases() {
        // Kiểm tra số lớn
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> calculator.add(Integer.MAX_VALUE, 1));
        assertEquals("integer overflow", thrown.getMessage());
        ArithmeticException thrownSubtract = assertThrows(ArithmeticException.class, () -> calculator.subtract(Integer.MIN_VALUE, 1));
        assertEquals("integer overflow", thrownSubtract.getMessage());
        ArithmeticException thrownMultiply = assertThrows(ArithmeticException.class, () -> calculator.multiply(Integer.MAX_VALUE, 2));
        assertEquals("integer overflow", thrownMultiply.getMessage());

        // Kiểm tra với số nhỏ nhất
        assertEquals(0, calculator.add(Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(0, calculator.add(Integer.MIN_VALUE, Integer.MAX_VALUE)); // Sửa lại để kết quả chính xác là 0

    }
}
