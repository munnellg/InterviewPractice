package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

	@Test
	public void test1() {
		Node<Integer> input    = Node.of(1, 2, 3, 4, 2, 6);
		Node<Integer> expected = Node.of(1, 2, 3, 4, 6);

		assertIterableEquals(expected, LinkedList.removeDuplicates(input));
	}

	@Test
	public void test2() {
		Node<Integer> input    = Node.of(2, 2, 2, 2, 2, 2);
		Node<Integer> expected = Node.of(2);

		assertIterableEquals(expected, LinkedList.removeDuplicates(input));
	}

	@Test
	public void test3() {
		Node<Integer> input    = Node.of(1, 2, 3, 4, 2, 6);
		Node<Integer> expected = Node.of(1, 2, 3, 4, 6);

		assertIterableEquals(expected, LinkedList.removeDuplicatesNoBuffer(input));
	}

	@Test
	public void test4() {
		Node<Integer> input    = Node.of(2, 2, 2, 2, 2, 2);
		Node<Integer> expected = Node.of(2);

		assertIterableEquals(expected, LinkedList.removeDuplicatesNoBuffer(input));
	}
}
