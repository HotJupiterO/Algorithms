import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmallestElementTest {
    SmallestElement sE;
    int[] a = {4, 2, 1, 7, 5, 3, 8, 10, 9};
    @BeforeEach
    public void setUp() throws Exception {
        sE = new SmallestElement();
    }

    @Test
    public void kthSmallest() {
        assertEquals(7, sE.getKthSmallest(a,0,8,6));
    }

    @Test
    public void firstSmallest() {
        assertEquals(1, sE.getKthSmallest(a,0,8,1));
    }

    @Test
    public void lastSmallest() {
        assertEquals(10, sE.getKthSmallest(a,0,8,9));
    }

    @Test
    public void kGreaterThanSize() {
        assertEquals(Integer.MAX_VALUE, sE.getKthSmallest(a,0,8,15));
    }
}
