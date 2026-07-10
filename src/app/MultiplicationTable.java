package app;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("===== Multiplication table =====");

        for (int k = 1; k <= 10; k++) {
            System.out.printf("%-20s", "- " + k + " -");
        }

        System.out.println();

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <=10; j++) {
                System.out.printf("%-20s", j + " * " + i + " = " + i*j);
            }
            System.out.println();
        }
    }
}
