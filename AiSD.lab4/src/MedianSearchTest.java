import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedianSearchTest {
    MedianSearch medianSearch;
    List<Integer> myList;

    @BeforeEach
    void setUp(){
        medianSearch = new MedianSearch();
        myList = new ArrayList<>(15);
        myList.add(4);  myList.add(0);  myList.add(19);  myList.add(13);  myList.add(1);
        myList.add(12);  myList.add(15);  myList.add(17);  myList.add(2);  myList.add(21);
        myList.add(21);  myList.add(22);  myList.add(7);  myList.add(8);  myList.add(0);

//         4, 0, 19, 13, 1, 12, 15, 17, 2, 21, 21, 22, 7, 8, 0
// sorted: 0, 0, 1, 2, 4, 7, 8, 12, 13, 15, 17, 19, 21, 21, 22
//          LL = 0, 0, 1, 2, 4   |   AL = 7   |   RL = 8, 12, 13, 15, 17, 19, 21, 21, 22
    }

    @Test
    void splitListTest() {
        medianSearch.splitList(myList,0);
        medianSearch.sortLists();
        Integer actual = medianSearch.getLeftList().get(3);
        assertEquals(2, actual);
    }


    @Test
    void getElementTest() {
        medianSearch.splitList(myList,0);
        medianSearch.sortLists();
        assertEquals(8, medianSearch.getElement(6));
    }
}