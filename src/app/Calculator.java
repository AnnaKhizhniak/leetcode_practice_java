package app;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

  static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] availableOperations = {"+", "-", "*", "/", "pow", "sqrt"};

    while (true) {
      System.out.println("Choose operation from available: " + Arrays.toString(availableOperations));
      String operation = scanner.nextLine();
      String valueA = "";
      String valueB = "";
      if (!Arrays.asList(availableOperations).contains(operation)) {
        System.out.println("This operation is not available. Select operation from list");
        continue;
      }
      while (true) {
        System.out.println("Enter operands below:");
        if (operation.equalsIgnoreCase("sqrt")) {
          System.out.println("Enter value (number): ");
          valueA = scanner.nextLine();

          if (valueA.isBlank()) {
            System.out.println("Entered empty values!");
            continue;
          }
          if (valueA.contains(".") || valueA.contains(",")) {
            Double valA = convertToDouble(valueA);
            if (valA != null) {
              calculate(operation, valA);
              break;
            }
            continue;

          } else {
            Integer intA = convertToInt(valueA);
            if (intA != null) {
              calculate(operation, intA);
              break;
            }
            continue;

          }
        }

        System.out.println("Enter first value (number): ");
        valueA = scanner.nextLine();

        System.out.println("Enter second value (number): ");
        valueB = scanner.nextLine();


        if (valueA.isBlank() || valueB.isBlank()) {
          System.out.println("Entered empty values!");
          continue;
        }
        if (valueA.contains(".") || valueA.contains(",") || valueB.contains(".") || valueB.contains(",")) {
          Double valA = convertToDouble(valueA);
          Double valB = convertToDouble(valueB);
          if (valA != null && valB != null) {
            calculate(operation, valA, valB);
            break;
          }
          continue;
        }

        Integer intA = convertToInt(valueA);
        Integer intB = convertToInt(valueB);
        if (intA != null && intB != null) {
          calculate(operation, intA, intB);
          break;
        }
      }

      while (true) {
        System.out.println("Want to continue? (enter \"Y\" or \"N\") ");
        String userAnswer = scanner.nextLine();
        if (userAnswer.equalsIgnoreCase("y")) {
          break;
        }
        if (userAnswer.equalsIgnoreCase("n")) {
          return;
        }
        System.out.println("Please enter only Y or N.");
      }

    }
  }

  public static Integer convertToInt(String value) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      System.out.println("Entered value is not a number");
      return null;
    }
  }

  public static Double convertToDouble(String value) {
    try {
      return Double.parseDouble(value.replace(",", "."));
    } catch (NumberFormatException e) {
      System.out.println("Entered value is not a number");
      return null;
    }
  }

  public static void calculate(String operation, int valueA, int valueB) {
    CalculatorMethods methods = new CalculatorMethods();
    switch (operation) {
      case "+" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.sumNumbers(valueA, valueB));
      case "-" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.subtractNumbers(valueA, valueB));
      case "*" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.multiplyNumbers(valueA, valueB));
      case "/" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.divideNumbers(valueA, valueB));
      case "pow" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.powNumbers(valueA, valueB));
      default -> System.out.println("This operation is not available. Select operation from list");
    }
  }

  public static void calculate(String operation, double valueA, double valueB) {
    CalculatorMethods methods = new CalculatorMethods();
    switch (operation) {
      case "+" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.sumNumbers(valueA, valueB));
      case "-" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.subtractNumbers(valueA, valueB));
      case "*" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.multiplyNumbers(valueA, valueB));
      case "/" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.divideNumbers(valueA, valueB));
      case "pow" ->
          System.out.println("Result: " + valueA + " " + operation + " " + valueB + " = " + methods.powNumbers(valueA, valueB));
      default -> System.out.println("This operation is not available. Select operation from list");
    }
  }

  public static void calculate(String operation, int valueA) {
    CalculatorMethods methods = new CalculatorMethods();
    if (operation.equalsIgnoreCase("sqrt")) {
      System.out.println("Result: " + valueA + " " + operation + " = " + methods.sqrtNumbers(valueA));
    }
  }

  public static void calculate(String operation, double valueA) {
    CalculatorMethods methods = new CalculatorMethods();
    if (operation.equalsIgnoreCase("sqrt")) {
      System.out.println("Result: " + valueA + " " + operation + " = " + methods.sqrtNumbers(valueA));
    }
  }
}
