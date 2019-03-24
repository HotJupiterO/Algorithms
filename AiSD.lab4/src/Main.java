import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MedianSearch bsearch = new MedianSearch();
        bsearch.generateList(15, 25);
        List<Integer> list = bsearch.getFirstList();
        Random random = new Random();
        int index = random.nextInt(list.size());

        bsearch.splitList(list, index);

        System.out.println("element: " + bsearch.getElement(2));
    }
}
