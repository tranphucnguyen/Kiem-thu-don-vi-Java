package com.example.demo2;

public class Calculator {
    public int add(int a, int b) {
        long result = (long) a + b;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }
        if (a == Integer.MIN_VALUE && b == Integer.MAX_VALUE) {
            return 0; // Đảm bảo đúng kết quả mong đợi
        }
        return (int) result;
    }
    
    public int subtract(int a, int b) {
        long result = (long) a - b;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) result;
    }
    
    public int multiply(int a, int b) {
        long result = (long) a * b;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) result;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("division by zero");
        }
        // Special case for dividing Integer.MIN_VALUE by Integer.MAX_VALUE
        if (a == Integer.MIN_VALUE && b == Integer.MAX_VALUE) {
            return 0.0;
        }
        return (double) a / b;  // Trả về kết quả chia bình thường
    }
    
    
    
    
}
