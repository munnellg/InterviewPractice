package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArithmeticTest {

    @Test
    public void test() {
        assertEquals(12, Arithmetic.multiply(3, 4));
        assertEquals(10, Arithmetic.multiply(5, 2));
        assertEquals(40, Arithmetic.multiply(5, 8));
    }
}
