package app;

public class Timer {
    public static void main(String[] args) {
        Timer loop = new Timer();
        loop.runTimer();
    }

    public void runTimer() {
        for (int h = 0; h <24; h++) {
            for (int m = 0; m <=59; m++) {
                for (int s = 0; s <=59; s++) {
                    System.out.printf("Time: %02d/%02d/%02d%n", h, m, s);
                }
            }
        }
    }
}