package app;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SapperUi {
  private static final int SIZE = 8;
  private static final int MINES_QUANTITY = 10;
  private static final String EMPTY = "#";

  private static final String[][] display = new String[SIZE][SIZE];
  private static final boolean[][] mines = new boolean[SIZE][SIZE];

  private static final JButton[][] buttons = new JButton[SIZE][SIZE];

  private static JFrame frame;

  static void main(String[] args) {
    createDisplay(display);
    createMines(mines);

    SwingUtilities.invokeLater(SapperUi::createUI);
  }

  private static void createUI() {
    frame = new JFrame("Sapper");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    JLabel title = new JLabel("Mines: " + MINES_QUANTITY, SwingConstants.CENTER);
    title.setFont(new Font("Arial", Font.BOLD, 18));

    JPanel field = new JPanel(new GridLayout(SIZE, SIZE));

    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        JButton button = new JButton();

        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);

        int rowCoordinate = row;
        int colCoordinate = col;

        button.addActionListener(event ->
            usersMove(rowCoordinate, colCoordinate)
        );

        buttons[row][col] = button;
        field.add(button);
      }
    }

    frame.add(title, BorderLayout.NORTH);
    frame.add(field, BorderLayout.CENTER);

    frame.setSize(500, 500);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  private static void usersMove(int rowCoordinate, int colCoordinate) {
    if (mines[rowCoordinate][colCoordinate]) {
      JOptionPane.showMessageDialog(
          frame,
          "Game is over! Here was bomb"
      );

      showMines();
      disableButtons();
      return;
    }

    updateDisplay(display, mines, rowCoordinate, colCoordinate);
    updateUI();

    boolean isFinished = isGameOver(display, mines);

    if (isFinished) {
      JOptionPane.showMessageDialog(
          frame,
          "Game is over! You won!"
      );

      showMines();
      disableButtons();
    }
  }

  private static int countMines(
      boolean[][] mines,
      int rowCoordinate,
      int colCoordinate
  ) {
    int bombCount = 0;

    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
      for (int colOffset = -1; colOffset <= 1; colOffset++) {

        if (rowOffset == 0 && colOffset == 0) {
          continue;
        }

        int currentRow = rowCoordinate + rowOffset;
        int currentCol = colCoordinate + colOffset;

        if (
            currentRow >= 0 &&
                currentRow < SIZE &&
                currentCol >= 0 &&
                currentCol < SIZE
        ) {
          if (mines[currentRow][currentCol]) {
            bombCount++;
          }
        }
      }
    }

    return bombCount;
  }

  private static void updateDisplay(
      String[][] display,
      boolean[][] mines,
      int rowCoordinate,
      int colCoordinate
  ) {
    if (!display[rowCoordinate][colCoordinate].equals(EMPTY)) {
      return;
    }

    int bombCount = countMines(
        mines,
        rowCoordinate,
        colCoordinate
    );

    display[rowCoordinate][colCoordinate] =
        bombCount > 0
            ? String.valueOf(bombCount)
            : " ";

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
            currentRow >= 0 &&
                currentRow < SIZE &&
                currentCol >= 0 &&
                currentCol < SIZE &&
                !mines[currentRow][currentCol]
        ) {
          updateDisplay(
              display,
              mines,
              currentRow,
              currentCol
          );
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

  private static boolean isGameOver(
      String[][] display,
      boolean[][] mines
  ) {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {

        if (
            !mines[row][col] &&
                display[row][col].equals(EMPTY)
        ) {
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

  private static void updateUI() {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {

        if (!display[row][col].equals(EMPTY)) {
          buttons[row][col].setText(display[row][col]);
          buttons[row][col].setEnabled(false);
        }
      }
    }
  }

  private static void showMines() {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {

        if (mines[row][col]) {
          buttons[row][col].setText("💣");
        }
      }
    }
  }

  private static void disableButtons() {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        buttons[row][col].setEnabled(false);
      }
    }
  }
}