package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StackSortTest {

    @Test
    public void test() {
        Stack<Integer> input  = Stack.of(3,1,4,8,2,4,1,6);
        Stack<Integer> expect = Stack.of(1,1,2,3,4,4,6,8);
        StackSort.sort(input);

        while (!input.isEmpty() && !expect.isEmpty()) {
        	assertEquals(input.pop(), expect.pop());
        }

        assertTrue(input.isEmpty());
        assertTrue(expect.isEmpty());
    }
}
