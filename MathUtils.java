import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Mathematical Utilities
 * Additional mathematical functions and utilities for the calculator
 */
public class MathUtils {
    
    /**
     * Calculate factorial using BigDecimal for large numbers
     */
    public static BigDecimal factorialBig(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        
        if (n <= 1) {
            return BigDecimal.ONE;
        }
        
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        
        return result;
    }
    
    /**
     * Calculate power using BigDecimal for precision
     */
    public static BigDecimal powerBig(double base, int exponent) {
        BigDecimal result = BigDecimal.ONE;
        BigDecimal baseDecimal = BigDecimal.valueOf(base);
        
        if (exponent < 0) {
            return BigDecimal.ONE.divide(powerBig(base, -exponent), MathContext.DECIMAL128);
        }
        
        for (int i = 0; i < exponent; i++) {
            result = result.multiply(baseDecimal);
        }
        
        return result;
    }
    
    /**
     * Calculate nth root of a number
     */
    public static double nthRoot(double number, int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Root cannot be zero");
        }
        
        if (n < 0) {
            return 1.0 / nthRoot(number, -n);
        }
        
        if (n == 1) {
            return number;
        }
        
        if (n == 2) {
            return Math.sqrt(number);
        }
        
        return Math.pow(number, 1.0 / n);
    }
    
    /**
     * Check if a number is prime
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        
        if (number <= 3) {
            return true;
        }
        
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Calculate Greatest Common Divisor (GCD)
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
    
    /**
     * Calculate Least Common Multiple (LCM)
     */
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd(a, b);
    }
    
    /**
     * Convert degrees to radians
     */
    public static double toRadians(double degrees) {
        return Math.toRadians(degrees);
    }
    
    /**
     * Convert radians to degrees
     */
    public static double toDegrees(double radians) {
        return Math.toDegrees(radians);
    }
    
    /**
     * Round to specified decimal places
     */
    public static double roundToDecimalPlaces(double value, int decimalPlaces) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    /**
     * Calculate percentage
     */
    public static double calculatePercentage(double value, double percentage) {
        return (value * percentage) / 100.0;
    }
    
    /**
     * Calculate percentage increase/decrease
     */
    public static double percentageChange(double oldValue, double newValue) {
        if (oldValue == 0) {
            throw new IllegalArgumentException("Old value cannot be zero for percentage change calculation");
        }
        return ((newValue - oldValue) / oldValue) * 100.0;
    }
    
    /**
     * Check if a number is even
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    /**
     * Check if a number is odd
     */
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
    
    /**
     * Calculate compound interest
     */
    public static double compoundInterest(double principal, double rate, double time, int compoundFrequency) {
        return principal * Math.pow((1 + rate / compoundFrequency), compoundFrequency * time);
    }
    
    /**
     * Calculate simple interest
     */
    public static double simpleInterest(double principal, double rate, double time) {
        return principal * rate * time / 100.0;
    }
}
