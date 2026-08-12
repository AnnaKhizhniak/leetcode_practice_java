package app;

import java.util.ArrayList;

public class HashNumberBuilder {
  private static final int SIZE = 7;
  private static final char EMPTY_CELL = ' ';
  private static final char FILLED_CELL = '#';

  public char[][] buildNumberByValue(String userInput) {
    return switch (userInput) {
      case "1" -> buildNumberOne();
      case "2" -> buildNumberTwo();
      case "3" -> buildNumberThree();
      case "4" -> buildNumberFour();
      case "5" -> buildNumberFive();
      case "6" -> buildNumberSix();
      case "7" -> buildNumberSeven();
      case "8" -> buildNumberEight();
      case "9" -> buildNumberNine();
      case "0" -> buildNumberZero();
      default -> null;
    };
  }

  public void printHashedNumbers(ArrayList<char[][]> numbers) {
    for (int row = 0; row < SIZE; row++) {
      for (char[][] number : numbers) {
        for (int col = 0; col < SIZE; col++) {
          System.out.print(number[row][col]);
        }
        System.out.print("   ");
      }
      System.out.println();
    }
  }

  private static char[][] buildBoard() {
    char[][] board = new char[SIZE][SIZE];
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        board[row][col] = EMPTY_CELL;
      }
    }
    return board;
  }

  private static char[][] buildNumberOne() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (col == 3) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 1 && col > 1 && col < 4) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 2 && col == 1) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 6 && col > 0 && col < 6) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }

  private static char[][] buildNumberTwo() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if ((row == 0 || row == 3) && col > 0 && col < 6) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 6) {
          board[row][col] = FILLED_CELL;
        }
        if ((row == 1 || row == 4 || row == 5) && col == 0) {
          board[row][col] = FILLED_CELL;
        }
        if ((row == 1 || row == 2) && col == 6) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }

  private static char[][] buildNumberThree() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if ((row == 0 || row == 3 || row == 6) && col > 0 && col < 6) {
          board[row][col] = FILLED_CELL;
        }
        if ((row == 1 || row == 5) && col == 0) {
          board[row][col] = FILLED_CELL;
        }
        if ((row == 1 || row == 2 || row == 4 || row == 5) && col == 6) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }

  private static char[][] buildNumberFour() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (row < 5 && col == 0) {
          board[row][col] = FILLED_CELL;
        }
        if (row > 0 && col == 6) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 4) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }

  private static char[][] buildNumberFive() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if ((row == 1 || row == 2 || row == 5) && col == 0) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 3 && col < 6) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 0) {
          board[row][col] = FILLED_CELL;
        }
        if ((row == 4 || row == 5) && col == 6) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 6 && col > 0 && col < 6) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }

  private static char[][] buildNumberSix() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if ((row == 0 || row == 6) && col > 0 && col < 6) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 3 && col < 6) {
          board[row][col] = FILLED_CELL;
        }
        if (row > 0 && row < 6 && col == 0) {
          board[row][col] = FILLED_CELL;
        }
        if ((row == 1 || row == 4 || row == 5) && col == 6) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }

  private static char[][] buildNumberSeven() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (row == 0) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 1 && (col == 0 || col == 5)) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 3 && col == 3) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 2 && col == 4) {
          board[row][col] = FILLED_CELL;
        }
        if (row > 3 && col == 2) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }

  private static char[][] buildNumberEight() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if ((row == 0 || row == 3 || row == 6) && col > 0 && col < 6) {
          board[row][col] = FILLED_CELL;
        }
        if (row > 0 && row < 6 && row != 3 && col == 6) {
          board[row][col] = FILLED_CELL;
        }
        if ((row == 1 || row == 4 || row == 5 || row == 2) && col == 0) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }

  private static char[][] buildNumberNine() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if ((row == 0 || row == 6) && col > 0 && col < 6) {
          board[row][col] = FILLED_CELL;
        }
        if (row == 3 && col > 0) {
          board[row][col] = FILLED_CELL;
        }
        if (row > 0 && row < 6 && col == 6) {
          board[row][col] = FILLED_CELL;
        }
        if ((row == 1 || row == 5 || row == 2) && col == 0) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }

  private static char[][] buildNumberZero() {
    char[][] board = buildBoard();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if ((row == 0 || row == 6) && col > 1 && col < 5) {
          board[row][col] = FILLED_CELL;
        }
        if ((row == 1 || row == 5) && (col == 1 || col == 5)) {
          board[row][col] = FILLED_CELL;
        }
        if (row > 1 && row < 5 && (col == 0 || col == 6)) {
          board[row][col] = FILLED_CELL;
        }
      }
    }
    return board;
  }
}
