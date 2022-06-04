package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void test() {
        Node<Integer> list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer expected = 7;
        Integer result = LinkedList.findKthToLast(list, 3);
        assertEquals(expected, result);
    }
}
