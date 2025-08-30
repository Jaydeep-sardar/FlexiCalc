/**
 * Test class for FlexiCalc functionality
 * This class demonstrates how to test various calculator functions
 */
public class FlexiCalcTest {
    
    public static void main(String[] args) {
        System.out.println("FlexiCalc Functionality Tests");
        System.out.println("==================================");
        
        // Test MathUtils functions
        testMathUtils();
        
        // Test CalculationHistory
        testCalculationHistory();
        
        System.out.println("\nAll tests completed!");
    }
    
    /**
     * Test MathUtils functionality
     */
    private static void testMathUtils() {
        System.out.println("\nTesting MathUtils functions:");
        
        // Test factorial
        try {
            int factorialResult = MathUtils.factorialBig(5).intValue();
            System.out.println("Factorial of 5: " + factorialResult);
            assert factorialResult == 120 : "Factorial test failed";
        } catch (Exception e) {
            System.out.println("Factorial test failed: " + e.getMessage());
        }
        
        // Test GCD
        try {
            int gcdResult = MathUtils.gcd(48, 18);
            System.out.println("GCD of 48 and 18: " + gcdResult);
            assert gcdResult == 6 : "GCD test failed";
        } catch (Exception e) {
            System.out.println("GCD test failed: " + e.getMessage());
        }
        
        // Test LCM
        try {
            int lcmResult = MathUtils.lcm(12, 15);
            System.out.println("LCM of 12 and 15: " + lcmResult);
            assert lcmResult == 60 : "LCM test failed";
        } catch (Exception e) {
            System.out.println("LCM test failed: " + e.getMessage());
        }
        
        // Test prime checking
        try {
            boolean isPrime17 = MathUtils.isPrime(17);
            boolean isPrime18 = MathUtils.isPrime(18);
            System.out.println("Is 17 prime? " + isPrime17);
            System.out.println("Is 18 prime? " + isPrime18);
            assert isPrime17 == true : "Prime test failed for 17";
            assert isPrime18 == false : "Prime test failed for 18";
        } catch (Exception e) {
            System.out.println("Prime test failed: " + e.getMessage());
        }
        
        // Test percentage calculation
        try {
            double percentage = MathUtils.calculatePercentage(200, 15);
            System.out.println("15% of 200: " + percentage);
            assert Math.abs(percentage - 30.0) < 0.001 : "Percentage test failed";
        } catch (Exception e) {
            System.out.println("Percentage test failed: " + e.getMessage());
        }
        
        // Test nth root
        try {
            double cubeRoot = MathUtils.nthRoot(27, 3);
            System.out.println("Cube root of 27: " + cubeRoot);
            assert Math.abs(cubeRoot - 3.0) < 0.001 : "Cube root test failed";
        } catch (Exception e) {
            System.out.println("Nth root test failed: " + e.getMessage());
        }
    }
    
    /**
     * Test CalculationHistory functionality
     */
    private static void testCalculationHistory() {
        System.out.println("\nTesting CalculationHistory functions:");
        
        try {
            // Clear history and test empty state
            CalculationHistory.clearHistory();
            int initialSize = CalculationHistory.getHistorySize();
            System.out.println("Initial history size: " + initialSize);
            assert initialSize == 0 : "History should be empty initially";
            
            // Add some calculations
            CalculationHistory.addToHistory("5 + 3 = 8");
            CalculationHistory.addToHistory("10 * 2 = 20");
            CalculationHistory.addToHistory("sqrt(16) = 4");
            
            int newSize = CalculationHistory.getHistorySize();
            System.out.println("History size after adding 3 entries: " + newSize);
            assert newSize == 3 : "History size should be 3";
            
            String lastCalculation = CalculationHistory.getLastCalculation();
            System.out.println("Last calculation: " + lastCalculation);
            assert lastCalculation.equals("sqrt(16) = 4") : "Last calculation incorrect";
            
            // Test null input handling
            CalculationHistory.addToHistory(null);
            CalculationHistory.addToHistory("");
            CalculationHistory.addToHistory("   ");
            
            int sizeAfterInvalid = CalculationHistory.getHistorySize();
            System.out.println("History size after invalid entries: " + sizeAfterInvalid);
            assert sizeAfterInvalid == 3 : "Invalid entries should not be added";
            
        } catch (Exception e) {
            System.out.println("History test failed: " + e.getMessage());
        }
    }
}
