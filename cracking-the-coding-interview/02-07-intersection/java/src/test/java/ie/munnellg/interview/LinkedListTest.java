package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void test1() {
        Node<Integer> l1 = Node.of(1,2,3,4,5,6,7,8,9,10);
        Node<Integer> l2 = Node.of(2,4,6);
        Node<Integer> intersection = l1.next.next.next.next.next.next;
        l2.next.next.next = intersection;
        assertEquals(intersection, LinkedList.findIntersection(l1, l2));
    }

    @Test
    public void test2() {
        Node<Integer> l1 = Node.of(1,2,3);
        Node<Integer> l2 = Node.of(4,5,6);
        Node<Integer> intersection = l2;
        l1.next.next.next = intersection;
        assertEquals(intersection, LinkedList.findIntersection(l1, l2));
    }

    @Test
    public void test3() {
        Node<Integer> l1 = Node.of(1,2,3,4,5,6,7,8,9,10);
        Node<Integer> l2 = Node.of(2,4,6);
        assertNull(LinkedList.findIntersection(l1, l2));
    }
}
