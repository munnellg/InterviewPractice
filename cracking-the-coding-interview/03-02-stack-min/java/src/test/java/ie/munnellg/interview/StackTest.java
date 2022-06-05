package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void test() {
        Stack<Integer> stack    = Stack.of(3, 5, 2, 1);
        Stack<Integer> expected = Stack.of(3, 3, 2, 1);

        while (!stack.isEmpty() && !expected.isEmpty()) {
        	assertEquals(expected.pop(), stack.min());
        	stack.pop();
        }

        assertTrue(stack.isEmpty());
        assertTrue(expected.isEmpty());
    }
}
