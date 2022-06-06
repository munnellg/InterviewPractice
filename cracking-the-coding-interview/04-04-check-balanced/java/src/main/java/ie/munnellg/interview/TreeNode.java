package ie.munnellg.interview;

public class TreeNode<T extends Comparable> {
	private T value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(T value) {
		this(value, null, null);
	}

	public TreeNode(T value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left  = left;
		this.right = right;
	}

	public boolean isBalanced() {
		return this.checkBalance(this) >= 0;
	}

	private int checkBalance(TreeNode node) {
		if (node == null) { return 0; }               // base case - we're balanced

		int hLeft = checkBalance(node.left);          // check height of left, and whether left is balanced
		if (hLeft < 0) { return hLeft; }              // if left isn't balanced, height will be negative -- bail out
		
		int hRight = checkBalance(node.right);        // check height of right, and whether right is balanced
		if (hRight < 0) { return hRight; }            // if right isn't balanced, height will be negative -- bail out
		
		int diff   = hLeft - hRight;                  // subtrees are balanced, check if current node is too
		int height = Math.max(hLeft, hRight) + 1;

		return Math.abs(diff) > 1 ? -height : height; // if subtree height diff is too large, return negative value
	}

	public static <T extends Comparable> TreeNode<T> of(T... values) {
		TreeNode<T> tree = null;

		for (int i = 0; i < values.length; i++) {
			tree = insert(tree, values[i]);
		}

		return tree;
	}

	public static <T extends Comparable> TreeNode<T> insert(TreeNode<T> node, T value) {
		if (node == null) { return new TreeNode<>(value); }
		
		if (value.compareTo(node.value) < 0) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}

		return node;
	}
}
