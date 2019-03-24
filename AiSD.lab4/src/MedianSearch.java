import java.lang.reflect.Field;
import java.util.*;

public class MedianSearch {
    private List<Integer> firstList, averageList, leftList, rightList;

    MedianSearch() {
        averageList = new ArrayList<>();
        leftList = new ArrayList<>();
        rightList = new ArrayList<>();
    }

    public void splitList(List<Integer> list, int index) {
        Random random = new Random();
        this.firstList = list;
        int splitter = this.firstList.get(index);
        for (int i = 0; i < this.firstList.size(); i++) {
            if (this.firstList.get(i) == splitter) {
                averageList.add(firstList.get(i));
            } else if (firstList.get(i) < splitter) {
                leftList.add(firstList.get(i));
            } else if (firstList.get(i) > splitter) {
                rightList.add(firstList.get(i));
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

    public void generateList(int size, int max) {
        firstList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            firstList.add(random.nextInt(max));
        }
        System.out.println("Generated List:");
        printList(firstList);
    }

    public Integer getElement(int k) {
        Collections.sort(leftList);
        Collections.sort(rightList);
        if (k < leftList.size()) {
            return Objects.requireNonNull(leftList.get(k));
        } else if (k <= leftList.size() + averageList.size()) {
            return Objects.requireNonNull(averageList.get(0));
        } else if (k > leftList.size() + averageList.size()) {
            return Objects.requireNonNull(rightList.get(k - leftList.size() - averageList.size()));
        }
        return null;
    }

    public List<Integer> getFirstList() {
        return firstList;
    }

    public List<Integer> getAverageList() {
        return averageList;
    }

    public List<Integer> getLeftList() {
        return leftList;
    }

    public List<Integer> getRightList() {
        return rightList;
    }

}
