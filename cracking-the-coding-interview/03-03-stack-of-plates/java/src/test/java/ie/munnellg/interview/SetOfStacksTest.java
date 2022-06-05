package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SetOfStacksTest {

    @Test
    public void test() {
    	SetOfStacks<Integer> input = SetOfStacks.of(1,2,3,4,5,6,7,8,9);
        Stack<Integer> expected    = Stack.of(1,2,3,4,5,6,7,8,9);

        while (!input.isEmpty() && !expected.isEmpty()) {
        	assertEquals(expected.pop(), input.pop());
        }

        assertTrue(input.isEmpty());
        assertTrue(expected.isEmpty());
    }

    @Test
    public void test2() {
    	SetOfStacks<Integer> input = SetOfStacks.of(1,2,3,4,5,6,7,8,9);
        Stack<Integer> expected    = Stack.of(1,2,3,4,5,7,8,9);
        
        input.popAt(1);

        while (!input.isEmpty() && !expected.isEmpty()) {
        	assertEquals(expected.pop(), input.pop());
        }

        assertTrue(input.isEmpty());
        assertTrue(expected.isEmpty());
    }

    @Test
    public void test3() {
    	SetOfStacks<Integer> input = SetOfStacks.of(1,2,3,4,5,6,7,8,9);
        Stack<Integer> expected    = Stack.of(1,2,3,7,8,9);
        
        // going to pop the middle stack and
        // completely empty it
        input.popAt(1);
        input.popAt(1);
        input.popAt(1);

        while (!input.isEmpty() && !expected.isEmpty()) {
        	assertEquals(expected.pop(), input.pop());
        }

        assertTrue(input.isEmpty());
        assertTrue(expected.isEmpty());
    }
}
