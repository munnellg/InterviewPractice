package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TreeNodeTest {

    @Test
    public void TreeNodeTest() {
        TreeNode<Integer> tree = TreeNode.of(5, 2, 3, 4, 1, 8, 6, 7, 9);
        List<List<TreeNode<Integer>>> depthList = TreeNode.depthList(tree);

        List<Integer> expected1 = List.of(5);
        List<Integer> expected2 = List.of(2, 8);
        List<Integer> expected3 = List.of(1, 3, 6, 9);
        List<Integer> expected4 = List.of(4, 7);

        assertIterableEquals(expected1, depthList.get(0).stream().map(TreeNode::getValue).collect(Collectors.toList()));
        assertIterableEquals(expected2, depthList.get(1).stream().map(TreeNode::getValue).collect(Collectors.toList()));
        assertIterableEquals(expected3, depthList.get(2).stream().map(TreeNode::getValue).collect(Collectors.toList()));
        assertIterableEquals(expected4, depthList.get(3).stream().map(TreeNode::getValue).collect(Collectors.toList()));
    }
}
