import java.util.Scanner;
import java.util.InputMismatchException;

public class FlexiCalc {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("         Welcome to FlexiCalc v1.0");
        System.out.println("    Enhanced Console-Based Calculator");
        System.out.println("=================================================");
        
        boolean continueCalculating = true;
        
        while (continueCalculating) {
            try {
                displayMainMenu();
                int choice = getIntInput("Enter your choice: ");
                
                switch (choice) {
                    case 1:
                        performBasicArithmetic();
                        break;
                    case 2:
                        performScientificCalculations();
                        break;
                    case 3:
                        performUnitConversions();
                        break;
                    case 4:
                        displayHistory();
                        break;
                    case 5:
                        continueCalculating = false;
                        System.out.println("Thank you for using FlexiCalc! Goodbye!");
                        break;
                    default:
                        System.out.println("ERROR: Invalid choice! Please select 1-5.");
                }
                
                if (continueCalculating) {
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }
                
            } catch (Exception e) {
                System.out.println("ERROR: An unexpected error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n+---------------------------------------+");
        System.out.println("|              MAIN MENU                |");
        System.out.println("+---------------------------------------+");
        System.out.println("| 1. Basic Arithmetic Operations       |");
        System.out.println("| 2. Scientific Calculations           |");
        System.out.println("| 3. Unit Conversions                  |");
        System.out.println("| 4. Calculation History               |");
        System.out.println("| 5. Exit                              |");
        System.out.println("+---------------------------------------+");
    }
    
    private static void performBasicArithmetic() {
        System.out.println("\nBASIC ARITHMETIC OPERATIONS");
        System.out.println("Available operations: +, -, *, /, %, ^ (power)");
        
        try {
            double num1 = getDoubleInput("Enter first number: ");
            String operator = getStringInput("Enter operator (+, -, *, /, %, ^): ");
            double num2 = getDoubleInput("Enter second number: ");
            
            double result = calculateBasicOperation(num1, operator, num2);
            String calculation = num1 + " " + operator + " " + num2 + " = " + result;
            
            System.out.println("Result: " + calculation);
            CalculationHistory.addToHistory(calculation);
            
        } catch (ArithmeticException e) {
            System.out.println("Math Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Operation: " + e.getMessage());
        }
    }
    
    private static double calculateBasicOperation(double num1, String operator, double num2) 
            throws ArithmeticException, IllegalArgumentException {
        
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed!");
                }
                return num1 / num2;
            case "%":
                if (num2 == 0) {
                    throw new ArithmeticException("Modulo by zero is not allowed!");
                }
                return num1 % num2;
            case "^":
                return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    
    private static void performScientificCalculations() {
        System.out.println("\nSCIENTIFIC CALCULATIONS");
        System.out.println("1. Trigonometric Functions (sin, cos, tan)");
        System.out.println("2. Logarithmic Functions (log, ln)");
        System.out.println("3. Other Functions (sqrt, factorial, abs)");
        
        try {
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    performTrigonometricFunctions();
                    break;
                case 2:
                    performLogarithmicFunctions();
                    break;
                case 3:
                    performOtherMathFunctions();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Error in scientific calculation: " + e.getMessage());
        }
    }
    
    private static void performTrigonometricFunctions() {
        System.out.println("\nTrigonometric Functions");
        
        double angle = getDoubleInput("Enter angle in degrees: ");
        double radians = Math.toRadians(angle);
        
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);
        
        String result = String.format("sin(%.2f°) = %.6f, cos(%.2f°) = %.6f, tan(%.2f°) = %.6f", 
                                    angle, sin, angle, cos, angle, tan);
        
        System.out.println("Results:");
        System.out.println(result);
        CalculationHistory.addToHistory(result);
    }
    
    private static void performLogarithmicFunctions() {
        System.out.println("\nLogarithmic Functions");
        
        double number = getDoubleInput("Enter a positive number: ");
        
        if (number <= 0) {
            System.out.println("Logarithm requires a positive number!");
            return;
        }
        
        double log10 = Math.log10(number);
        double logE = Math.log(number);
        
        String result = String.format("log10(%.2f) = %.6f, ln(%.2f) = %.6f", 
                                    number, log10, number, logE);
        
        System.out.println("Results:");
        System.out.println(result);
        CalculationHistory.addToHistory(result);
    }
    
    private static void performOtherMathFunctions() {
        System.out.println("\nOther Mathematical Functions");
        System.out.println("1. Square Root");
        System.out.println("2. Factorial");
        System.out.println("3. Absolute Value");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1:
                double num = getDoubleInput("Enter a number: ");
                if (num < 0) {
                    System.out.println("Square root of negative number is not real!");
                    return;
                }
                double sqrt = Math.sqrt(num);
                String sqrtResult = String.format("sqrt(%.2f) = %.6f", num, sqrt);
                System.out.println("Result: " + sqrtResult);
                CalculationHistory.addToHistory(sqrtResult);
                break;
                
            case 2:
                int factNum = getIntInput("Enter a non-negative integer: ");
                if (factNum < 0) {
                    System.out.println("Factorial is not defined for negative numbers!");
                    return;
                }
                long factorial = calculateFactorial(factNum);
                String factResult = factNum + "! = " + factorial;
                System.out.println("Result: " + factResult);
                CalculationHistory.addToHistory(factResult);
                break;
                
            case 3:
                double absNum = getDoubleInput("Enter a number: ");
                double abs = Math.abs(absNum);
                String absResult = String.format("abs(%.2f) = %.2f", absNum, abs);
                System.out.println("Result: " + absResult);
                CalculationHistory.addToHistory(absResult);
                break;
                
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static long calculateFactorial(int n) {
        if (n <= 1) return 1;
        return n * calculateFactorial(n - 1);
    }
    
    private static void performUnitConversions() {
        System.out.println("\nUNIT CONVERSIONS");
        System.out.println("1. Temperature (Celsius, Fahrenheit, Kelvin)");
        System.out.println("2. Length (Meters, Feet, Inches)");
        System.out.println("3. Weight (Kilograms, Pounds, Ounces)");
        System.out.println("4. Currency (USD, EUR, INR)");
        
        try {
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    performTemperatureConversion();
                    break;
                case 2:
                    performLengthConversion();
                    break;
                case 3:
                    performWeightConversion();
                    break;
                case 4:
                    performCurrencyConversion();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Error in unit conversion: " + e.getMessage());
        }
    }
    
    private static void performTemperatureConversion() {
        System.out.println("\nTemperature Conversion");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        
        int choice = getIntInput("Enter your choice: ");
        double temperature = getDoubleInput("Enter temperature value: ");
        double result = 0;
        String conversionText = "";
        
        switch (choice) {
            case 1:
                result = (temperature * 9/5) + 32;
                conversionText = String.format("%.2fC = %.2fF", temperature, result);
                break;
            case 2:
                result = (temperature - 32) * 5/9;
                conversionText = String.format("%.2fF = %.2fC", temperature, result);
                break;
            case 3:
                result = temperature + 273.15;
                conversionText = String.format("%.2fC = %.2fK", temperature, result);
                break;
            case 4:
                result = temperature - 273.15;
                conversionText = String.format("%.2fK = %.2fC", temperature, result);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("Result: " + conversionText);
        CalculationHistory.addToHistory(conversionText);
    }
    
    private static void performLengthConversion() {
        System.out.println("\nLength Conversion");
        System.out.println("1. Meters to Feet");
        System.out.println("2. Feet to Meters");
        System.out.println("3. Meters to Inches");
        System.out.println("4. Inches to Meters");
        
        int choice = getIntInput("Enter your choice: ");
        double length = getDoubleInput("Enter length value: ");
        double result = 0;
        String conversionText = "";
        
        switch (choice) {
            case 1:
                result = length * 3.28084;
                conversionText = String.format("%.2f m = %.2f ft", length, result);
                break;
            case 2:
                result = length / 3.28084;
                conversionText = String.format("%.2f ft = %.2f m", length, result);
                break;
            case 3:
                result = length * 39.3701;
                conversionText = String.format("%.2f m = %.2f in", length, result);
                break;
            case 4:
                result = length / 39.3701;
                conversionText = String.format("%.2f in = %.2f m", length, result);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("Result: " + conversionText);
        CalculationHistory.addToHistory(conversionText);
    }
    
    private static void performWeightConversion() {
        System.out.println("\nWeight Conversion");
        System.out.println("1. Kilograms to Pounds");
        System.out.println("2. Pounds to Kilograms");
        System.out.println("3. Kilograms to Ounces");
        System.out.println("4. Ounces to Kilograms");
        
        int choice = getIntInput("Enter your choice: ");
        double weight = getDoubleInput("Enter weight value: ");
        double result = 0;
        String conversionText = "";
        
        switch (choice) {
            case 1:
                result = weight * 2.20462;
                conversionText = String.format("%.2f kg = %.2f lbs", weight, result);
                break;
            case 2:
                result = weight / 2.20462;
                conversionText = String.format("%.2f lbs = %.2f kg", weight, result);
                break;
            case 3:
                result = weight * 35.274;
                conversionText = String.format("%.2f kg = %.2f oz", weight, result);
                break;
            case 4:
                result = weight / 35.274;
                conversionText = String.format("%.2f oz = %.2f kg", weight, result);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("Result: " + conversionText);
        CalculationHistory.addToHistory(conversionText);
    }
    
    private static void performCurrencyConversion() {
        System.out.println("\nCurrency Conversion (Demo rates)");
        System.out.println("1. USD to EUR");
        System.out.println("2. EUR to USD");
        System.out.println("3. USD to INR");
        System.out.println("4. INR to USD");
        
        int choice = getIntInput("Enter your choice: ");
        double amount = getDoubleInput("Enter amount: ");
        double result = 0;
        String conversionText = "";
        
        switch (choice) {
            case 1:
                result = amount * 0.85;
                conversionText = String.format("$%.2f = €%.2f", amount, result);
                break;
            case 2:
                result = amount * 1.18;
                conversionText = String.format("€%.2f = $%.2f", amount, result);
                break;
            case 3:
                result = amount * 82.5;
                conversionText = String.format("$%.2f = Rs%.2f", amount, result);
                break;
            case 4:
                result = amount / 82.5;
                conversionText = String.format("Rs%.2f = $%.2f", amount, result);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("Result: " + conversionText);
        System.out.println("Note: These are demo exchange rates");
        CalculationHistory.addToHistory(conversionText);
    }
    
    private static void displayHistory() {
        System.out.println("\nCALCULATION HISTORY");
        CalculationHistory.displayHistory();
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer!");
                scanner.nextLine();
            }
        }
    }
    
    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
            }
        }
    }
    
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
