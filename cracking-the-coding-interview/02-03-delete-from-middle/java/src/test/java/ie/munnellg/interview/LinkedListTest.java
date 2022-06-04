package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void test1() {
        Node<Integer> input = Node.of(1,2,3,4,5,6,7,8,9);
        Node<Integer> expected = Node.of(1,2,4,5,6,7,8,9);
        LinkedList.delete(input.next.next);
        assertIterableEquals(expected, input);
    }

    @Test
    public void test2() {
        Node<Integer> input = Node.of(1,2,3);
        Node<Integer> expected = Node.of(1,3);
        LinkedList.delete(input.next);
        assertIterableEquals(expected, input);
    }
}
