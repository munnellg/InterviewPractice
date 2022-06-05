package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class StackBufferTest {

    @Test
    public void test() {
    	final int STACK_BUFFER_SIZE = 10;

    	StackBuffer buffer = new StackBuffer(STACK_BUFFER_SIZE);
        StackBuffer.Stack<Integer> sp1 = buffer.stack();
		StackBuffer.Stack<Integer> sp2 = buffer.stack();
		StackBuffer.Stack<Integer> sp3 = buffer.stack();

		LinkedList<Integer> e1 = new LinkedList<>();
		LinkedList<Integer> e2 = new LinkedList<>();
		LinkedList<Integer> e3 = new LinkedList<>();

		for (int i = 0; i < STACK_BUFFER_SIZE / 2; i++) {
			sp1.push(i); e1.push(i);
			if (i % 2 == 0) { sp2.push(i); e2.push(i); }
			if (i % 3 == 0) { sp3.push(i); e3.push(i); }
		}

		checkList(sp1, e1);
		checkList(sp2, e2);
		checkList(sp3, e3);

		// buffer is fully deallocatd now. We should be able to reuse the
		// full buffer
		StackBuffer.Stack<Integer> sp4 = buffer.stack();
		LinkedList<Integer> e4 = new LinkedList<>();
		
		for (int i = 0; i < STACK_BUFFER_SIZE; i++) {
			sp4.push(i); e4.push(i);
		}

		checkList(sp4, e4);
    }

    private <T> void checkList(StackBuffer.Stack<T> l1, LinkedList<T> l2) {
    	while (!l1.isEmpty() && !l2.isEmpty()) {
    		assertEquals(l1.pop(), l2.pop());
    	}

    	assertTrue(l1.isEmpty());
    	assertTrue(l2.isEmpty());
    }
}
