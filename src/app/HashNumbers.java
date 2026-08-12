package app;

import java.util.ArrayList;
import java.util.Scanner;

public class HashNumbers {
  private static final String NUMBER_SEQUENCE = "1234567890";

  static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashNumberBuilder numberBuilder = new HashNumberBuilder();
    System.out.println("Print your code dividing single numbers with spaces: ");

    OUTER_LOOP:
    while (true) {
      String userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");

      if (userInput.isEmpty()) {
        System.out.println("Input data is empty!");
        continue;
      }

      String[] inputArray = userInput.split(" ");
      ArrayList<char[][]> result = new ArrayList<>();

      for (String array : inputArray) {
        if (array.length() > 1 || !NUMBER_SEQUENCE.contains(array)) {
          System.out.println("Input data is not correct!");
          continue OUTER_LOOP;
        }
        
        result.add(numberBuilder.buildNumberByValue(array));
      }
      numberBuilder.printHashedNumbers(result);
      return;
    }
  }
}
