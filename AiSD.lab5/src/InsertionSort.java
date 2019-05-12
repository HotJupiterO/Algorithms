import java.util.Random;

public class InsertionSort extends SortingAlgorithm{
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] testedValue = {100000, 500000, 1000000, 2000000};
        Random r = new Random();
        for (int i = 0; i < testedValue.length; i++) {
            int N = testedValue[i];
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = r.nextInt(N);
            }
            System.out.printf("Average time for %7d random elements = %1.3f seconds\n", N, getAverageTime(arr));
        }
    }

    public static double getAverageTime(int[] arr) {
        int N = 100;
        long startTime, finishTime;
        long result = 0;
        for (int i = 0; i < N; i++) {
            startTime = System.currentTimeMillis();
            sort(arr);
            finishTime = System.currentTimeMillis();
            result += finishTime - startTime;
        }
        return (double) result / 1000;
    }

    public static double getTimeInSeconds(int[] array) {
        long startTime, finishTime, result = 0;
        startTime = System.currentTimeMillis();
        sort(array);
        finishTime = System.currentTimeMillis();
        result += finishTime - startTime;
        return (double) result / 1000;
    }

}
