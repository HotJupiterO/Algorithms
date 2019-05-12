import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner sc = new Scanner(System.in);
        String exit = "";
        while (!exit.equals("exit")) {
            int length = lengthChooser();
            int type = typeChooser();
            int algorithmID = algorithmChooser();
            int[] array = new int[length];
            double time = 0;
            for (int i = 0; i < 100; i++) {
                fillArray(array);
                transform(array, type);
                time += sortViaChoosenAlgorithm(array, algorithmID);
            }
            System.out.printf("-- Average time for choosen algorithm = %1.3f sec --   ", time / 100);
            System.out.println("Type \"exit\" for close the program or any symbols for continue");

            exit = sc.next();
        }

      /*  System.out.println();
        for (int x : array) {
            System.out.print(x + " ");
        }*/


    }

    private static int lengthChooser() {
        System.out.println("Choose array length.");
        System.out.println("1.   100 000.\n2.   500 000.\n3. 1 000 000.\n4. 2 000 000");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        while (option < 1 || option > 4) {
            System.out.println("Expected value: 1, 2, 3, 4.");
            option = sc.nextInt();
        }
        switch (option) {
            case 1 -> {
                return 100000;
            }
            case 2 -> {
                return 500000;
            }
            case 3 -> {
                return 1000000;
            }
            case 4 -> {
                return 2000000;
            }
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    private static int typeChooser() {
        System.out.println("Which type of array?");
        System.out.println("1.Random\n2.Sorted in half\n3.Sorted\n4.Reverse Sorting");
        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        return opt;
    }

    private static void transform(int[] array, int type) {
        switch (type) {
            case 1 -> {
            }
            case 2 -> Arrays.sort(array, 0, array.length / 2); // half
            case 3 -> Arrays.sort(array); // sorted
            case 4 -> { // reverse
                Integer[] reverseSortedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
                Arrays.sort(reverseSortedArray, Collections.reverseOrder());
                int i = 0;
                for (Integer x : reverseSortedArray) {
                    array[i++] = x;
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            Random r = new Random();
            array[i] = r.nextInt(array.length);
        }
    }

    private static int algorithmChooser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose algorithm.");
        System.out.println("1.Insertion Sort.\n2.Merge Sort.\n3.Quick Sort");
        int algorithmID = sc.nextInt();
        return algorithmID;
    }

    private static double sortViaChoosenAlgorithm(int[] array, int alorithmID) {
        switch (alorithmID) { // 1.Insertion Sort. 2.Merge Sort. 3.Quick Sort
            case 1 -> {
                return InsertionSort.getTimeInSeconds(array);//InsertionSort.sort(array);
            }
            case 2 -> {
                return MergeSort.getTimeInSeconds(array);
            }//MergeSort.sort(array, array.length);
            case 3 -> {
                return QuickSort.getTimeInSeconds(array);
            }//QuickSort.sort(array, 0, array.length - 1);
            default -> throw new IllegalStateException("Unexpected value: " + alorithmID);
        }
    }


}


