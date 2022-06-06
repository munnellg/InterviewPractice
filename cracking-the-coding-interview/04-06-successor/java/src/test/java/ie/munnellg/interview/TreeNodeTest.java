package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TreeNodeTest {

	@Test
	public void test1() {
		TreeNode<Integer> tree = TreeNode.of(5, 2, 3, 4, 1, 8, 6, 7, 9);
		TreeNode<Integer> src = tree.nodeAt(4);
		TreeNode<Integer> expected = tree.nodeAt(5);
		assertEquals(expected, src.successor());
	}

	@Test
	public void test2() {
		TreeNode<Integer> tree = TreeNode.of(5, 2, 3, 4, 1, 8, 6, 7, 9);
		TreeNode<Integer> src = tree.nodeAt(8);
		TreeNode<Integer> expected = null;
		assertEquals(expected, src.successor());
	}

	@Test
	public void test3() {
		TreeNode<Integer> tree = TreeNode.of(9, 8, 7, 6, 5, 4, 3, 2, 1);
		TreeNode<Integer> src = tree.nodeAt(0);
		TreeNode<Integer> expected = tree.nodeAt(1);
		assertEquals(expected, src.successor());
	}

	@Test
	public void test4() {
		TreeNode<Integer> tree = TreeNode.of(9, 8, 7, 6, 5, 4, 3, 2, 1);
		TreeNode<Integer> src = tree.nodeAt(8);
		TreeNode<Integer> expected = null;
		assertEquals(expected, src.successor());
	}
}
