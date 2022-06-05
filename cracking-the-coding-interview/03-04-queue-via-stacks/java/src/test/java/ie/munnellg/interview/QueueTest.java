package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void test() {
        Queue<Integer> queue    = Queue.of(1,2,3,4,5,6);
        Stack<Integer> expected = Stack.of(6,5,4,3,2,1);

        while (!queue.isEmpty() && !expected.isEmpty()) {
        	assertEquals(expected.pop(), queue.dequeue());
        }

        assertTrue(queue.isEmpty());
        assertTrue(expected.isEmpty());
    }
}
