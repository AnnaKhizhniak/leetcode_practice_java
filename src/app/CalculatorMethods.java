package app;

public class CalculatorMethods {
  // multiplication
  public int multiplyNumbers(int a, int b) {
    return a * b;
  }

  public double multiplyNumbers(double a, double b) {
    return a * b;
  }

  // sum
  public int sumNumbers(int a, int b) {
    return a + b;
  }

  public double sumNumbers(double a, double b) {
    return a + b;
  }

  // subtraction
  public int subtractNumbers(int a, int b) {
    return a - b;
  }

  public double subtractNumbers(double a, double b) {
    return a - b;
  }

  // division
  public double divideNumbers(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Division by 0 is prohibited!");
    }
    
    return (double) a / b;
  }

  public double divideNumbers(double a, double b) {
    if (b == 0) {
      throw new ArithmeticException("Division by 0 is prohibited!");
    }
    return a / b;
  }

  //pow
  public double powNumbers(double a, double b) {
    return Math.pow(a, b);
  }

  //sqr
  public double sqrtNumbers(double a) {
    return Math.sqrt(a);
  }
}
