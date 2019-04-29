import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SmallestElement smallestElement = new SmallestElement();
        int[] tab = new int[16];
        Random random = new Random();
        //Generate and print array
        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(30);
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        //--------------------------------------

        System.out.println();
        final int K = 5;
        System.out.printf("Kth smallest element in array: %d%n", smallestElement.getKthSmallest(tab, 0, tab.length - 1, K));
    }
}
