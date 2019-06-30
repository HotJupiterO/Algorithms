import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmallestElementTest {
    private SmallestElement sE;
    private int[] array = {4, 2, 1, 7, 5, 3, 8, 10, 9};

    @BeforeEach
    void setUp() {
        sE = new SmallestElement();
    }

    @Test
    void kthSmallest() {
        assertEquals(7, sE.getKthSmallest(array,0,8,6));
    }

    @Test
    void firstSmallest() {
        assertEquals(1, sE.getKthSmallest(array,0,8,1));
    }

    @Test
    void lastSmallest() {
        assertEquals(10, sE.getKthSmallest(array,0,8,9));
    }

    @Test
    void kGreaterThanSize() {
        assertEquals(Integer.MAX_VALUE, sE.getKthSmallest(array,0,8,15));
    }
}
