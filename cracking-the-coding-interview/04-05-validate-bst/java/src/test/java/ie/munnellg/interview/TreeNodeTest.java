package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TreeNodeTest {

    @Test
    public void test1() {
        TreeNode<Integer> tree = TreeNode.of(5, 2, 3, 4, 1, 8, 6, 7, 9);
        assertTrue(tree.isBst());
    }

    @Test
    public void test2() {
		TreeNode<Integer> n10 = new TreeNode<>(10);
		TreeNode<Integer> n5  = new TreeNode<>(5);
		TreeNode<Integer> n12 = new TreeNode<>(12);
		TreeNode<Integer> n20 = new TreeNode<>(20);
		TreeNode<Integer> n3  = new TreeNode<>(3);
		TreeNode<Integer> n9  = new TreeNode<>(9);
		TreeNode<Integer> n18 = new TreeNode<>(18);
		TreeNode<Integer> n7  = new TreeNode<>(7);
		n10.left  = n5;
		n5.right  = n12;
		n10.right = n20;
		n20.left  = n3;
		n20.right = n7;
		n3.left   = n9;
		n3.right  = n18;

        assertFalse(n10.isBst());
    }

    @Test
    public void test3() {
    	// tree walk solution will fail this one
		TreeNode<Integer> n20 = new TreeNode<>(20);
		n20.right = new TreeNode<>(20);
        assertFalse(n20.isBst());
    }
}
