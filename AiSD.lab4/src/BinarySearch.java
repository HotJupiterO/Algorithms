import java.util.*;

public class BinarySearch {
    List<Integer> averageList, leftList, rightList;

    BinarySearch() {
        averageList = new ArrayList<>();
        leftList = new ArrayList<>();
        rightList = new ArrayList<>();
    }

    public void splitList(List<Integer> list) {
        Random random = new Random();
        int index = random.nextInt(15);
        int splitter = list.get(index);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == splitter) {
                averageList.add(list.get(i));
            } else if (list.get(i) < splitter) {
                leftList.add(list.get(i));
            } else if (list.get(i) > splitter) {
                rightList.add(list.get(i));
            }
        }
        System.out.println("Splitter = " + splitter);

        printList(leftList);
        printList(averageList);
        printList(rightList);
    }

    public void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public List<Integer> generateList(int size, int max) {
        List<Integer> generatedList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            generatedList.add(random.nextInt(max));
        }
        System.out.println("Generated List:");
        printList(generatedList);
        return generatedList;
    }

    public Integer getElement(int k) {
        Collections.sort(leftList);
        Collections.sort(rightList);
        if (k < leftList.size()) {
            return Objects.requireNonNull(leftList.get(k));
        } else if (k >= leftList.size() && k <= leftList.size() + averageList.size()) {
            return Objects.requireNonNull(averageList.get(0));
        } else if (k > leftList.size() + averageList.size()) {
            return Objects.requireNonNull(rightList.get(k - leftList.size() - averageList.size()));
        }
        return null;
    }
//

}
