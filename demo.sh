#!/bin/bash
# Demo script to test FlexiCalc with various inputs

echo "=== FlexiCalc Demo - Automated Testing ==="
echo ""

# Test 1: Basic arithmetic
echo "Test 1: Basic Arithmetic (15 * 4)"
echo -e "1\n15\n*\n4\n\n5" | java FlexiCalc | grep "Result:"

echo ""

# Test 2: Scientific calculation - Square root
echo "Test 2: Square Root of 25"
echo -e "2\n3\n1\n25\n\n5" | java FlexiCalc | grep "Result:"

echo ""

# Test 3: Unit conversion - Temperature
echo "Test 3: Temperature Conversion (100°C to Fahrenheit)"
echo -e "3\n1\n1\n100\n\n5" | java FlexiCalc | grep "Result:"

echo ""

# Test 4: Power calculation
echo "Test 4: Power Calculation (2^8)"
echo -e "1\n2\n^\n8\n\n5" | java FlexiCalc | grep "Result:"

echo ""
echo "=== All tests completed! ==="
