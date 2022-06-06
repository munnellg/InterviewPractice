package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class TreeNodeTest {

    @Test
    public void test1() {
        TreeNode<Integer> tree = TreeNode.of(1,2,3,4,5,6,7,8,9,10);
        double minHeight = (Math.log(tree.size()) / Math.log(2));
        assertEquals((int) minHeight, tree.height());
    }

    @Test
    public void test2() {
        TreeNode<Integer> tree = TreeNode.of(1,2,3,4,5,6,7,8,9);
        double minHeight = (Math.log(tree.size()) / Math.log(2));
        assertEquals((int) minHeight, tree.height());
    }

    @Test
    public void test3() {
        TreeNode<Integer> tree = TreeNode.of(1);
        assertEquals(1, tree.height());
    }

    @Test
    public void test4() {
        TreeNode<Integer> tree = TreeNode.of();
        assertNull(tree);
    }
}
