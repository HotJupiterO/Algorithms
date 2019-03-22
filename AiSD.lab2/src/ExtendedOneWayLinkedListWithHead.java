import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ExtendedOneWayLinkedListWithHead<T> extends AbstractList<T> implements Iterable<T> {
    private OneWayLinkedListWithHead<T> innerList = new OneWayLinkedListWithHead<T>();


    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
            int cursor;
            Boolean hasNext, hasPrevious;
            boolean canBeRemovedOrSet;


            @Override
            public boolean hasNext() {
                return hasNext = cursor < size();
            }

            @Override
            public T next() {
                if (cursor + 1 > size()) {
                    throw new NoSuchElementException();
                }
                return innerList.get(cursor++);
            }

            @Override
            public boolean hasPrevious() {
                return hasPrevious = cursor > 0;
            }

            @Override
            public T previous() {
                try {
                    return innerList.get(--cursor);
                } catch (IndexOutOfBoundsException e) {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public int nextIndex() {
                return cursor;
            }

            @Override
            public int previousIndex() {
                return cursor - 1;
            }

            @Override
            public void remove() {
                if (!(cursor - 1 < 0)) {
                    innerList.remove(--cursor);
                } else throw new IllegalStateException();
                /*try {
                    innerList.remove(--cursor);
                } catch (IndexOutOfBoundsException e) {
                    throw new IllegalStateException();
                }*/

            }

            @Override
            public void set(T t) {
                try {
                    innerList.set(cursor - 1, t);
                } catch (IndexOutOfBoundsException e) {
                    throw new IllegalStateException();
                }
            }

            @Override
            public void add(T t) {
                innerList.add(cursor++, t);
            }

            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                throw new UnsupportedOperationException();
            }
        };
    }

    /*@Override
    public void forEach(Consumer<? super T> action) {
        throw new UnsupportedOperationException();
    }*/

    @Override
    public void clear() {
        innerList.clear();
    }

    @Override
    public int size() {
        return innerList.size();
    }

    @Override
    public boolean add(T value) {
        return innerList.add(value);
    }

    @Override
    public T get(int index) {
        return innerList.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return this.listIterator();
    }

    @Override
    public int indexOf(Object data) {
        return innerList.indexOf(data);
    }

    @Override
    public boolean contains(Object data) {
        return innerList.contains(data);
    }

    @Override
    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    @Override
    public void add(int index, T data) {
        innerList.add(index, data);
    }

    @Override
    public T set(int index, T data) {
        return innerList.set(index, data);
    }
}
