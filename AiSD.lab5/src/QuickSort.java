import java.util.Random;

/**
 * <b>Quicksort</b> (sometimes called partition-exchange sort) is an efficient sorting algorithm,
 * serving as a systematic method for placing the elements of a random access file or an array in order.
 * Developed by British computer scientist Tony Hoare in 1959 and published in 1961,
 * it is still a commonly used algorithm for sorting.
 * When implemented well, it can be about two or three times faster than its main competitors,
 * merge sort and heapsort.
 */
public class QuickSort extends Sort{
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
        int i = start - 1;
        int j = end + 1;
        while (true) {
            do {
                i++;
            } while (array[i] < pivot);
            do {
                j--;
            } while (array[j] > pivot);
            if (i >= j) return j;
            swap(array, i, j);
        }
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int q = partition(array, start, end);
            sort(array, start, q);
            sort(array, q + 1, end);
        }
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

    private static double getAverageTime(int[] arr) {
        int N = 100;
        long startTime, finishTime;
        long result = 0;
        for (int i = 0; i < N; i++) {
            startTime = System.currentTimeMillis();
            sort(arr, 0, arr.length - 1);
            finishTime = System.currentTimeMillis();
            result += finishTime - startTime;
        }
        return (double) result / 1000;
    }
}
