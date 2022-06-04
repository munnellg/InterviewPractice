package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.Test;

public class SumTest {

    @Test
    public void test1() {
        Node l1 = Node.of(9, 7, 8);
        Node l2 = Node.of(6, 8, 5);
        Node expected = Node.of(5, 6, 4, 1);
        assertIterableEquals(expected, Sum.sum(l1, l2));
    }

    @Test
    public void test2() {
        Node l1 = Node.of(8, 7, 9);
        Node l2 = Node.of(5, 8, 6);
        Node expected = Node.of(1, 4, 6, 5);
        assertIterableEquals(expected, Sum.sumForward(l1, l2));
    }

    @Test
    public void test3() {
        Node l1 = Node.of(1, 2, 3, 4);
        Node l2 = Node.of(5, 6, 7);
        Node expected = Node.of(1, 8, 0, 1);
        assertIterableEquals(expected, Sum.sumForward(l1, l2));
    }
}
