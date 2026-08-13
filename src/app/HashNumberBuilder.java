package app;

import java.util.ArrayList;

public class HashNumberBuilder {
  private static final int SIZE = 7;
  private static final String[][] DIGITS = {
      {
          "  ###  ",
          " #   # ",
          "#     #",
          "#     #",
          "#     #",
          " #   # ",
          "  ###  ",
      },
      {
          "   #   ",
          "  ##   ",
          " # #   ",
          "   #   ",
          "   #   ",
          "   #   ",
          " ##### "
      },
      {
          " ##### ",
          "#     #",
          "      #",
          " ##### ",
          "#      ",
          "#      ",
          "#######"
      },
      {
          " ##### ",
          "#     #",
          "      #",
          " ##### ",
          "      #",
          "#     #",
          " ##### "
      },
      {
          "#      ",
          "#     #",
          "#     #",
          "#     #",
          "#######",
          "      #",
          "      #"
      },
      {
          "#######",
          "#      ",
          "#      ",
          "###### ",
          "      #",
          "#     #",
          " ##### "
      },
      {
          " ##### ",
          "#     #",
          "#      ",
          "###### ",
          "#     #",
          "#     #",
          " ##### "
      },
      {
          "#######",
          "#    # ",
          "    #  ",
          "   #   ",
          "  #    ",
          "  #    ",
          "  #    "
      },
      {
          " ##### ",
          "#     #",
          "#     #",
          " ##### ",
          "#     #",
          "#     #",
          " ##### "
      },
      {
          " ##### ",
          "#     #",
          "#     #",
          " ######",
          "      #",
          "#     #",
          " ##### "
      }
  };

  public String[] findNumberByValue(String userInput) {
    int digit = Integer.parseInt(userInput);
    return DIGITS[digit];
  }

  public void printHashedNumbers(ArrayList<String[]> numbers) {
    for (int row = 0; row < SIZE; row++) {
      for (String[] number : numbers) {
        System.out.print(number[row]);
        System.out.print("   ");
      }
      System.out.println();
    }
  }
}
