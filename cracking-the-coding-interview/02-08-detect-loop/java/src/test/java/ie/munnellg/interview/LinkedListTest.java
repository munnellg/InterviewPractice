package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

	@Test
	public void test1() {
		Node list = Node.of(1, 2, 3, 4);
		list.next.next.next = list.next; 
		assertTrue(LinkedList.containsLoop(list));
	}

	@Test
	public void test2() {
		Node list = Node.of(1, 2, 3, 4, 5);
		list.next.next.next.next = list.next; 
		assertTrue(LinkedList.containsLoop(list));
	}

	@Test
	public void test3() {
		Node list = Node.of(1, 2, 3, 4);
		assertFalse(LinkedList.containsLoop(list));
	}

	@Test
	public void test4() {
		Node list = Node.of(1, 2, 3);
		assertFalse(LinkedList.containsLoop(list));
	}

	@Test
	public void test5() {
		Node list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node intersection = list.kth(8);
		intersection.next = list.kth(0);
		assertEquals(intersection.next, LinkedList.findLoop(list));
	}

	@Test
	public void test6() {
		Node list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node intersection = list.kth(8);
		intersection.next = list.kth(1);
		assertEquals(intersection.next, LinkedList.findLoop(list));
	}

	@Test
	public void test7() {
		Node list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node intersection = list.kth(8);
		intersection.next = list.kth(2);
		assertEquals(intersection.next, LinkedList.findLoop(list));
	}

	@Test
	public void test8() {
		Node list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node intersection = list.kth(8);
		intersection.next = list.kth(3);
		assertEquals(intersection.next, LinkedList.findLoop(list));
	}

	@Test
	public void test9() {
		Node list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node intersection = list.kth(8);
		intersection.next = list.kth(4);
		assertEquals(intersection.next, LinkedList.findLoop(list));
	}

	@Test
	public void test10() {
		Node list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node intersection = list.kth(8);
		intersection.next = list.kth(5);
		assertEquals(intersection.next, LinkedList.findLoop(list));
	}

	@Test
	public void test11() {
		Node list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node intersection = list.kth(8);
		intersection.next = list.kth(6);
		assertEquals(intersection.next, LinkedList.findLoop(list));
	}

	@Test
	public void test12() {
		Node list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node intersection = list.kth(8);
		intersection.next = list.kth(7);
		assertEquals(intersection.next, LinkedList.findLoop(list));
	}

	@Test
	public void test13() {
		Node list = Node.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node intersection = list.kth(8);
		intersection.next = list.kth(8);
		assertEquals(intersection.next, LinkedList.findLoop(list));
	}
}
