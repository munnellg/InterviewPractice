package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.Test;

public class PartitionTest {

    @Test
    public void test() {
        Node<Integer> input = Node.of(3, 5, 8, 5, 10, 2, 1);
        Node<Integer> expectedLeft = Node.of(3, 2, 1);
        Node<Integer> expectedRight = Node.of(5, 8, 5, 10);
        Partition<Integer> partition = Partition.of(input, 5);
        assertIterableEquals(expectedLeft, partition.left);
        assertIterableEquals(expectedRight, partition.right);
    }
}
