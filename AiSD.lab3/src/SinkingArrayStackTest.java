import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SinkingArrayStackTest {
    SinkingArrayStack<Integer> stack;
    private static final int SIZE = 5;

    @BeforeEach
    void setUp() {
        stack = new SinkingArrayStack<>(SIZE);
        for (int i = 1; i <= 8; i++) {
            stack.push(i);
        }
    }

    @Test
    void isEmptyTest() {
        assertNotNull(stack.getElement(0));
    }

    @Test
    void isFullTest() {
        assertNotNull(stack.getElement(SIZE - 1));
    }

    @Test
    void popTest() throws EmptyStackException {
        assertEquals(8, stack.pop());
    }

    @Test
    void popExceptionTest() throws EmptyStackException {
        for (int i = 0; i < SIZE; i++) {
            stack.pop();
        }
        assertThrows(EmptyStackException.class, stack::pop); // == () -> stack.pop()
    }

    @Test
    void pushTest() {
        stack.push(9);
        assertEquals(9, stack.top());
    }

    @Test
    void sizeTest() {
        assertEquals(5, stack.size());
    }

    @Test
    void topTest() {
        assertEquals(8, stack.top());
    }
}