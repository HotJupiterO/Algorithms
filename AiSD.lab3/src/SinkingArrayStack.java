public class SinkingArrayStack<T> implements IStack<T> {
    private static final int DEFAULT_CAPACITY = 16;
    protected T[] stack;
    protected int topIndex;

    @SuppressWarnings("unchecked")
    public SinkingArrayStack(int initialSize) {
        stack = (T[]) new Object[initialSize];
        topIndex = 0;
    }

    public SinkingArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return stack[0] == null;
    }

    @Override
    public boolean isFull() {
        return stack[stack.length - 1] != null;
    }

    @Override
    public T pop() throws EmptyStackException {
        T temp = stack[0];
        if (temp == null) {
            throw new EmptyStackException();
        }
        for (int i = 0; i < stack.length - 1; i++) {
            stack[i] = stack[i + 1];
        }
        stack[stack.length - 1] = null;
        topIndex--;
        return temp;
    }

    @Override
    public void push(T elem) {
        for (int i = stack.length - 1; i > 0; i--) {
            stack[i] = stack[i - 1];
        }
        stack[0] = elem;
        if (topIndex + 1 <= stack.length) {
            topIndex++;
        }

    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top() {
        return stack[0];
    }

    public void print() {
        for (T element : stack) {
            if (element != null) {
                System.out.println(element);
            }
        }
    }

    protected T peek() {
        return stack[0];
    }

    protected void cursorDown() {
    }

    protected void cursorToTop() {
    }

    public T getElement(int index) {
        return stack[index];
    }

}
