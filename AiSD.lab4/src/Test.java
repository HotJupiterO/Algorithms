import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test<T> {
    List<T> list;

    Test() {
        list = new ArrayList();
    }

    public void test(T o) {
        list.add(Objects.requireNonNull(o));
    }

    public int sum(int... a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += Objects.requireNonNull(a[i], "Cannot be null");
        }
        return sum;
    }
}
