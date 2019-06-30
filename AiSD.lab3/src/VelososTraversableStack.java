/**
 * Veloso's Traversable Stack jest to stos, który poza zwykłymi
 * operacjami ma możliwość nieniszczącego odczytu z pozycji
 * wskazywanej przez kursor (peek). Kursor można ustawić na
 * wierzchołek stosu (top) i przesuwać o jedną pozycję w dół
 * stosu (down - potrzebna jest sygnalizacja osiągnięcia dna
 * stosu ). Normalne operacje (push i pop ) automatycznie
 * ustawiają kursor na wierzchołek.
 */
public class VelososTraversableStack<T> extends SinkingArrayStack<T> {
    private int cursor;

    VelososTraversableStack(int size) {
        super(size);
        this.cursor = topIndex;
    }

    VelososTraversableStack() {
        super();
        this.cursor = topIndex;
    }

    @Override
    public T top() {
        cursorToTop();
        return super.top();
    }

    @Override
    public void push(T elem) {
        cursorToTop();
        super.push(elem);
    }

    @Override
    public int size() {
        return topIndex;
    }


    public T peek() {
        return stack[cursor];
    }

    public void cursorDown() {
        if (cursor + 1 > stack.length - 1) {
            throw new IndexOutOfBoundsException();
        } else cursor++;
    }

    public void cursorToTop() {
        cursor = 0;
    }
}