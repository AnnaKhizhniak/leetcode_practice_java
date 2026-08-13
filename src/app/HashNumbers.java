package app;

import java.util.ArrayList;
import java.util.Scanner;

public class HashNumbers {
  private static final String NUMBER_SEQUENCE = "1234567890";

  static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashNumberBuilder numberBuilder = new HashNumberBuilder();
    System.out.println("Print your code dividing single numbers with spaces: ");

    while (true) {
      String userInput = scanner.nextLine().trim().replaceAll("\\s+", " ");

      if (userInput.isEmpty()) {
        System.out.println("Input data is empty!");
        continue;
      }

      String[] inputArray = userInput.split(" ");
      ArrayList<String[]> result = new ArrayList<>();
      boolean isValid = true;

      for (String digit : inputArray) {
        if (digit.length() != 1 || !NUMBER_SEQUENCE.contains(digit)) {
          System.out.println("Input data is not correct!");
          isValid = false;
          break;
        }
        result.add(numberBuilder.findNumberByValue(digit));
      }
      if (!isValid) {
        continue;
      }
      numberBuilder.printHashedNumbers(result);
      return;
    }
  }
}


/*
1. input number sequence 1234567890
2. check is sequence number
3. draw number

   1       #    #####   #####  #       #######  #####  #######  #####   #####    ###
   2      ##   #     # #     # #    #  #       #     # #    #  #     # #     #  #   #
   3     # #         #       # #    #  #       #           #   #     # #     # #     #
   4       #    #####   #####  #    #  ######  ######     #     #####   ###### #     #
   5       #   #             # #######       # #     #   #     #     #       # #     #
   6       #   #       #     #      #  #     # #     #   #     #     # #     #  #   #
   7     ##### #######  #####       #   #####   #####    #      #####   #####    ###

 */