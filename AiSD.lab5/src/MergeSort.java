import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MergeSort extends SortingAlgorithm {
    public static void sort(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            rightArray[i - mid] = array[i];
        }
        sort(leftArray, mid);
        sort(rightArray, n - mid);

        merge(array, leftArray, rightArray, mid, n - mid);
    }

    public static void merge(
            int[] array, int[] start, int[] end, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (start[i] <= end[j]) {
                array[k++] = start[i++];
            } else {
                array[k++] = end[j++];
            }
        }
        while (i < left) {
            array[k++] = start[i++];
        }
        while (j < right) {
            array[k++] = end[j++];
        }
    }

    public static void main(String[] args) {
        int[] testedValue = {100000, 500000, 1000000, 2000000};
        Random r = new Random();
        for (int N : testedValue) {
            int[] arr = new int[N];
            //fill array
            for (int j = 0; j < N; j++) {
                arr[j] = r.nextInt(N);
            }
            int[] halfSortedArray = arr;
            Arrays.sort(halfSortedArray, 0, (halfSortedArray.length / 2));


            int[] sortedArray = arr;
            Arrays.sort(sortedArray);

            Integer[] reverseSortedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(reverseSortedArray, Collections.reverseOrder());
            int[] primitiveReverseArray = new int[reverseSortedArray.length];
            int i = 0;
            for (Integer x : reverseSortedArray) {
                primitiveReverseArray[i++] = x;
            }

            System.out.printf("Average time for %7d random elements %10s=  %20.3f seconds\n", N, "", getAverageTime(arr));
            System.out.printf("Average time for %7d half-sorted sorted elements %10s= %20.3f seconds\n", N, "", getAverageTime(halfSortedArray));
            System.out.printf("Average time for %7d sorted elements %10s= %20.3f seconds\n", N, "", getAverageTime(sortedArray));
            System.out.printf("Average time for %7d reverse elements% 10s = %20.3f seconds\n", N, " ", getAverageTime(primitiveReverseArray));

        }
    }

    public static double getAverageTime(int[] arr) {
        int N = 100;
        long startTime, finishTime;
        long result = 0;
        for (int i = 0; i < N; i++) {
            startTime = System.currentTimeMillis();
            sort(arr, arr.length);
            finishTime = System.currentTimeMillis();
            result += finishTime - startTime;
        }
        return (double) result / 1000;
    }

    public static double getTimeInSeconds(int[] array) {
        long startTime, finishTime, result = 0;
        startTime = System.currentTimeMillis();
        sort(array, array.length);
        finishTime = System.currentTimeMillis();
        result += finishTime - startTime;
        return (double) result / 1000;
    }
}
