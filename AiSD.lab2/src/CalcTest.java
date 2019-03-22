import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {
    private Calc calc = new Calc();


    @Test
    public void sumTest2plus5equal7() {
        assertEquals(7, calc.sum(2, 5));
    }

    @Test
    public void divTest9div2equal4() {
        assertEquals(4, calc.div(9, 2));
    }

    @Test//(expected = ArithmeticException.class)
    public void divTest9div0Exception() {
        assertThrows(ArithmeticException.class, () -> calc.div(9, 0));

    }
}
