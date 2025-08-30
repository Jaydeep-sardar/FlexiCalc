# FlexiCalc - Enhanced Console-Based Calculator

## 🚀 Overview

FlexiCalc is a comprehensive console-based calculator that supports basic arithmetic operations, scientific functions, and unit conversions. Built with Java, it features modular design, robust error handling, and calculation history tracking.

## ✨ Features

### 🧮 Basic Arithmetic Operations
- Addition (+)
- Subtraction (-)
- Multiplication (*)
- Division (/)
- Modulo (%)
- Power (^)

### 🔬 Scientific Calculations
- **Trigonometric Functions**: sin, cos, tan
- **Logarithmic Functions**: log10, natural log (ln)
- **Mathematical Functions**: 
  - Square root
  - Factorial
  - Absolute value

### 🔄 Unit Conversions
- **Temperature**: Celsius ↔ Fahrenheit ↔ Kelvin
- **Length**: Meters ↔ Feet ↔ Inches
- **Weight**: Kilograms ↔ Pounds ↔ Ounces
- **Currency**: USD ↔ EUR ↔ INR (demo rates)

### 📜 Additional Features
- Calculation history with timestamps
- Input validation and error handling
- User-friendly interface with emojis
- Modular code organization

## 🏗️ Project Structure

```
FlexiCalc/
├── FlexiCalc.java          # Main calculator class
├── CalculationHistory.java # History management
├── MathUtils.java          # Additional math utilities
└── README.md              # This file
```

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line/terminal access

### Compilation and Execution

1. **Navigate to the project directory:**
   ```bash
   cd "c:\Users\JAYDEEP SARDAR\Desktop\FlexiCalc"
   ```

2. **Compile the Java files:**
   ```bash
   javac *.java
   ```

3. **Run the calculator:**
   ```bash
   java FlexiCalc
   ```

## 💡 Usage Guide

### Main Menu Navigation
When you start FlexiCalc, you'll see a main menu with the following options:

```
┌─────────────────────────────────────────┐
│              MAIN MENU                  │
├─────────────────────────────────────────┤
│ 1. Basic Arithmetic Operations         │
│ 2. Scientific Calculations             │
│ 3. Unit Conversions                    │
│ 4. Calculation History                 │
│ 5. Exit                                │
└─────────────────────────────────────────┘
```

### Basic Arithmetic Operations
- Select option 1 from the main menu
- Enter the first number
- Choose an operator: `+`, `-`, `*`, `/`, `%`, `^`
- Enter the second number
- View the result

**Example:**
```
Enter first number: 10
Enter operator (+, -, *, /, %, ^): *
Enter second number: 5
✅ Result: 10.0 * 5.0 = 50.0
```

### Scientific Calculations
Select option 2 and choose from:
1. **Trigonometric Functions** - Calculate sin, cos, tan for angles in degrees
2. **Logarithmic Functions** - Calculate log10 and natural logarithm
3. **Other Functions** - Square root, factorial, absolute value

### Unit Conversions
Select option 3 and choose from:
1. **Temperature Conversions** - Between Celsius, Fahrenheit, and Kelvin
2. **Length Conversions** - Between meters, feet, and inches
3. **Weight Conversions** - Between kilograms, pounds, and ounces
4. **Currency Conversions** - Between USD, EUR, and INR (demo rates)

### Calculation History
- Select option 4 to view your calculation history
- History includes timestamps and shows the last 10 calculations
- Maximum of 50 calculations are stored

## 🛡️ Error Handling

FlexiCalc includes comprehensive error handling for:

- **Division by zero** - Prevents crashes and shows appropriate error messages
- **Invalid input types** - Validates numeric inputs and operators
- **Mathematical domain errors** - Handles cases like square root of negative numbers
- **Out of range values** - Manages factorial of large numbers
- **Invalid menu choices** - Guides users back to valid options

## 🎯 Code Features

### Modular Design
- **FlexiCalc.java**: Main application logic and user interface
- **CalculationHistory.java**: Manages calculation history with timestamps
- **MathUtils.java**: Additional mathematical utilities and helper functions

### Object-Oriented Principles
- Encapsulation with private methods and data
- Separation of concerns across multiple classes
- Robust input validation methods

### Best Practices
- Consistent code formatting and documentation
- Meaningful variable and method names
- Exception handling with try-catch blocks
- Resource management (Scanner closing)

## 🔧 Extending the Calculator

### Adding New Operations
To add a new basic operation:
1. Update the `calculateBasicOperation()` method in `FlexiCalc.java`
2. Add the new operator to the validation logic
3. Update the help text in `performBasicArithmetic()`

### Adding New Unit Conversions
To add a new unit type:
1. Create a new method like `performNewUnitConversion()`
2. Add it to the conversion menu in `displayConversionMenu()`
3. Update the switch statement in `performUnitConversions()`

### Adding New Scientific Functions
To add new scientific functions:
1. Create a new method in the scientific calculations section
2. Update `displayScientificMenu()` and the corresponding switch statement
3. Consider adding helper methods to `MathUtils.java`

## 📝 Sample Usage Session

```
=================================================
         Welcome to FlexiCalc v1.0
    Enhanced Console-Based Calculator
=================================================

┌─────────────────────────────────────────┐
│              MAIN MENU                  │
├─────────────────────────────────────────┤
│ 1. Basic Arithmetic Operations         │
│ 2. Scientific Calculations             │
│ 3. Unit Conversions                    │
│ 4. Calculation History                 │
│ 5. Exit                                │
└─────────────────────────────────────────┘

Enter your choice: 1

🧮 BASIC ARITHMETIC OPERATIONS
Available operations: +, -, *, /, %, ^ (power)
Enter first number: 15
Enter operator (+, -, *, /, %, ^): ^
Enter second number: 2
✅ Result: 15.0 ^ 2.0 = 225.0
```

## 🤝 Contributing

To contribute to FlexiCalc:
1. Follow the existing code style and documentation patterns
2. Add appropriate error handling for new features
3. Update this README when adding new functionality
4. Test all new features thoroughly

## 📄 License

This project is created for educational purposes as part of a programming skills development exercise.

---

**Happy Calculating with FlexiCalc! 🧮✨**
