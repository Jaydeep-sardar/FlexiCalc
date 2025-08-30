@echo off
echo ================================================
echo          FlexiCalc Build and Run Script
echo ================================================
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java JDK 8 or higher
    pause
    exit /b 1
)

echo Compiling Java files...
javac *.java

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERROR: Compilation failed!
    echo Please check for syntax errors in the Java files.
    pause
    exit /b 1
)

echo Compilation successful!
echo.
echo Starting FlexiCalc...
echo ================================================
echo.

java FlexiCalc

echo.
echo ================================================
echo FlexiCalc session ended.
pause
