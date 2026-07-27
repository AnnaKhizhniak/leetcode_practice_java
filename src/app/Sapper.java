package app;

import java.util.Random;
import java.util.Scanner;

public class Sapper {
  private static final int SIZE = 8;
  private static final int MINES_QUANTITY = 10;
  private static final String EMPTY = "#";

  static void main(String[] args) {
    String[][] display = new String[SIZE][SIZE];
    boolean[][] mines = new boolean[SIZE][SIZE];
    createDisplay(display);
    createMines(mines);
    printDisplay(display);
    printMines(mines);
    usersMove(mines, display);
  }

  private static void usersMove(boolean[][] mines, String[][] display) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Enter coordinates as numbers between 0 and 7, one by one, by using space separator: ");
      String[] move = scanner.nextLine().trim().split(" ");
      try {
        int rowCoordinate = Integer.parseInt(move[0]);
        int colCoordinate = Integer.parseInt(move[1]);

        if (rowCoordinate < 0 || rowCoordinate > 7 || colCoordinate < 0 || colCoordinate > 7) {
          System.out.println("Coordinates out of display size!");
          continue;
        }

        if (mines[rowCoordinate][colCoordinate]) {
          System.out.println("Game is over! Here was bomb");
          printMines(mines);
          break;
        }

        countMines(mines, rowCoordinate, colCoordinate);
        updateDisplay(display, mines, rowCoordinate, colCoordinate);
        printDisplay(display);

        boolean isFinished = isAllEmptyCells(display, mines);
        if (isFinished) {
          System.out.println("Game is over! You won!");
          printMines(mines);
          break;
        }

      } catch (NumberFormatException e) {
        System.out.println("Enter both coordinates as numbers!");
      }
    }
  }

  private static int countMines(boolean[][] mines, int rowCoordinate, int colCoordinate) {
    int bombCount = 0;

    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
      for (int colOffset = -1; colOffset <= 1; colOffset++) {
        if (rowOffset == 0 && colOffset == 0) {
          continue;
        }

        int currentRow = rowCoordinate + rowOffset;
        int currentCol = colCoordinate + colOffset;

        if (currentRow >= 0 && currentRow < SIZE && currentCol >= 0 && currentCol < SIZE) {
          if (mines[currentRow][currentCol]) {
            bombCount++;
          }
        }
      }
    }
    return bombCount;
  }

  private static void updateDisplay(String[][] display, boolean[][] mines, int rowCoordinate, int colCoordinate) {
    if (!display[rowCoordinate][colCoordinate].equals(EMPTY)) {
      return;
    }

    int bombCount = countMines(mines, rowCoordinate, colCoordinate);

    display[rowCoordinate][colCoordinate] = bombCount > 0 ? String.valueOf(bombCount) : " ";

    if (bombCount != 0) {
      return;
    }

    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
      for (int colOffset = -1; colOffset <= 1; colOffset++) {
        if (rowOffset == 0 && colOffset == 0) {
          continue;
        }

        int currentRow = rowCoordinate + rowOffset;
        int currentCol = colCoordinate + colOffset;

        if (
            currentRow >= 0 && currentRow < SIZE &&
                currentCol >= 0 && currentCol < SIZE &&
                !mines[currentRow][currentCol]
        ) {
          updateDisplay(display, mines, currentRow, currentCol);
        }
      }
    }
  }

  private static void createDisplay(String[][] display) {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        display[row][col] = EMPTY;
      }
    }
  }

  private static boolean isAllEmptyCells(String[][] display, boolean[][] mines) {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (!mines[row][col] && display[row][col].equals(EMPTY)) {
          return false;
        }
      }
    }
    return true;
  }

  private static void createMines(boolean[][] mines) {
    Random random = new Random();
    byte count = 1;
    while (count <= MINES_QUANTITY) {
      int randomRow = random.nextInt(SIZE);
      int randomCol = random.nextInt(SIZE);
      if (mines[randomRow][randomCol]) {
        continue;
      }
      mines[randomRow][randomCol] = true;
      count++;
    }
  }

  private static void printDisplay(String[][] display) {
    System.out.println("Updated display: ");
    System.out.println("    1   2   3   4   5   6   7   8");
    System.out.println("  +---+---+---+---+---+---+---+---+");
    for (int row = 0; row < SIZE; row++) {
      System.out.print(row + 1 + " |");
      for (int col = 0; col < SIZE; col++) {
        System.out.print(" " + display[row][col] + " |");
      }
      System.out.println();
      System.out.println("  +---+---+---+---+---+---+---+---+");
    }
    System.out.println();
  }

  private static void printMines(boolean[][] mines) {
    System.out.println("Field with mines: ");
    System.out.println("    1   2   3   4   5   6   7   8");
    System.out.println("  +---+---+---+---+---+---+---+---+");
    for (int row = 0; row < SIZE; row++) {
      System.out.print(row + 1 + " |");
      for (int col = 0; col < SIZE; col++) {
        System.out.print(" " + (mines[row][col] == true ? "1" : " ") + " |");
      }
      System.out.println();
      System.out.println("  +---+---+---+---+---+---+---+---+");
    }
    System.out.println();
  }
}
