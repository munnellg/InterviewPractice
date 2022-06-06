package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TreeNodeTest {

    @Test
    public void test1() {
        TreeNode<Integer> tree = TreeNode.of(5, 2, 3, 4, 1, 8, 6, 7, 9);
        assertTrue(tree.isBalanced());
    }

    @Test
    public void test2() {
    	TreeNode<Integer> tree = TreeNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertFalse(tree.isBalanced());
    }
}
