import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        ExtendedOneWayLinkedListWithHead<Integer> linkedList = new ExtendedOneWayLinkedListWithHead<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        ListIterator<Integer> li = linkedList.listIterator();

//        System.out.println(linkedList.get(1));

        System.out.println();

        LinkedList<Integer> tmpLlist = new LinkedList<>();
        tmpLlist.add(1);
        tmpLlist.add(2);
        tmpLlist.add(3);
        ListIterator lIter = tmpLlist.listIterator();
        while (lIter.hasNext()) {
            lIter.next();
            lIter.remove();
        }


        System.out.println("----------------TEST----------------");
        /*while (li.hasNext()) {
//            li.next();
            li.remove();
        }*/
        System.out.println("------------------------------------");


        li = linkedList.listIterator();
        while (li.hasNext()) {
            System.out.print(li.next() + " ");
        }
    }
}
