import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinarySearch bsearch = new BinarySearch();
        List<Integer> list = bsearch.generateList(15, 25);

        bsearch.splitList(list);

        System.out.println("element: " + bsearch.getElement(2));
    }
}
