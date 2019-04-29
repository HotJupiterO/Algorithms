import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose algorithm.");
            System.out.println("1.Insertion Sort.\n2.Merge Sort.\n3.Quick Sort");
            int mainOption = sc.nextInt();
            int subOption1, subOption2, subOption3;
            if (mainOption == 1) {
                System.out.println("Which type of arrays?");
                System.out.println("1.Random\n2.Sorted in half\n3.Sorted\n4.Reverse Sorting");
                subOption1 = sc.nextInt();


            }
        }
        */
    }

    public static void start(){
        Sort[] sortingMethods = new Sort[3];
        sortingMethods[0] = new InsertionSort();
        sortingMethods[1] = new MergeSort();
        sortingMethods[2] = new QuickSort();

        Scanner sc = new Scanner(System.in);
        int option1 = sc.nextInt();
        sortingMethods[option1]
        System.out.println("Which type of arrays?");
        System.out.println("1.Random\n2.Sorted in half\n3.Sorted\n4.Reverse Sorting");
//        subOption1 = sc.nextInt();
    }

    private static int lengthChooser() {
        System.out.println("Choose array length.");
        System.out.println("1. 100 000.\n2. 500 000.\n3. 1 000 000.\n4. 2 000 000");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
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
}
