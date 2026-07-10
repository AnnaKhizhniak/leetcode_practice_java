package app;

public class BubbleSorting {
    int array[] = { 10, 1, 6, -8, 9, 34, 124, 0, -5, -2, 98 };
    int sortedArray [] = new int[array.length];

    public void sortArray(int[] arr) {
        int currentValue = 0;
        for (int k = 0; k <= arr.length - 1; k++) {
            for (int i = 0; i <= arr.length - 1; i++) {
                if (i + 1 <= arr.length - 1 && arr[i] > arr[i+1]) {
                    currentValue = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = currentValue;
                }
                sortedArray[i] = arr[i];
            }
        }

        System.out.print("Sorted: ");
        for (int j = 0; j <= sortedArray.length - 1; j++) {

            System.out.print(sortedArray[j] + (j != sortedArray.length - 1 ? ", " : ""));
        }
    }

    public static void main(String[] args) {
        BubbleSorting arr = new BubbleSorting();
        arr.sortArray(arr.array);
    }
}
