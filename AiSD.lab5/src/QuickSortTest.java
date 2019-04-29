import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    int[] actual = {6, 3, 7, 5, 2, 1, 4};

    @Test
    public void sort() {
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        MergeSort.sort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }
}