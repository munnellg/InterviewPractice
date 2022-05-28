package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class IntSumTest {

    @Test
    public void testValidInput() {
        List<Integer> numbers = List.of(10, 4, 16, 1, 5, 3, 9, 7);
        assertEquals(new Pair<Integer, Integer>(4, 10), IntSum.find(numbers, 14));
    }
}
