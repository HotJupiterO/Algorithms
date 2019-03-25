import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*MedianSearch bsearch = new MedianSearch();
        bsearch.generateList(15, 25);
        List<Integer> list = bsearch.getFirstList();
        Random random = new Random();
        int index = random.nextInt(list.size());

        bsearch.splitList(list, index);

        System.out.println("element: " + bsearch.getElement(2));*/
        //int K = 4;
        int[] A = {1, 3, 7, 9, 9};
        int[] B = {5, 6, 8, 9, 10};
        Solution sol = new Solution();
        System.out.println("Solution: " + sol.solution(A, B));

    }
}
