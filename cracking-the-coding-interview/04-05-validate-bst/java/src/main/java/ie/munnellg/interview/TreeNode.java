package ie.munnellg.interview;

public class TreeNode<T extends Comparable> {
	public T value;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(T value) {
		this(value, null, null);
	}

	public TreeNode(T value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left  = left;
		this.right = right;
	}

	public boolean isBst() {
		// solution 1 - contains bug if tree contains duplicates
		// return walk(this, new ValueWrapper());

		return isBst(this, null, null);
	}

	private boolean isBst(TreeNode<T> node, T min, T max) {
		if (node == null) { return true; }
		if (min != null && node.value.compareTo(min) <= 0) { return false; }
		if (max != null && node.value.compareTo(max) > 0)  { return false; }
		return isBst(node.left, min, node.value) && isBst(node.right, node.value, max);
	}

	private boolean walk(TreeNode<T> node, ValueWrapper prev) {
		if (node == null) { return true; }

		// check if the left branch is valid
		if (!walk(node.left, prev)) { return false; }

		// check if we're still valid in this branch
		if (prev.value != null && prev.value.compareTo(node.value) > 0) {
			return false;
		}

		prev.value = node.value;

		// check the right branch
		return walk(node.right, prev);
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

	private class ValueWrapper {
		private T value;
		public ValueWrapper() { this(null); }
		public ValueWrapper(T value) { this.value = value; }
	}
}
