import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VelososTraversableStackTest {
    VelososTraversableStack<Integer> velososStack;
    private static final int SIZE = 5;

    /**
     * 8
     * 7
     * 6
     * 5
     * 4
     * |
     * 3
     * 2
     * 1
     * */
    @BeforeEach
    void setUp(){
        velososStack = new VelososTraversableStack<>(SIZE);
        for (int i = 1; i <= 8; i++) {
            velososStack.push(i);
        }
    }

    @Test
    void peek() {
        velososStack.cursorDown();
        velososStack.cursorDown();
        velososStack.cursorDown();
        assertEquals(5,velososStack.peek());
    }

    @Test
    void cursorDown() {
        velososStack.cursorDown();
        velososStack.cursorDown();
        assertEquals(6,velososStack.peek() );
    }

    @Test
    void cursorToTop() {
        velososStack.cursorDown();
        velososStack.cursorDown();
        velososStack.cursorToTop();
        assertEquals(8,velososStack.peek());
    }
}