package ie.munnellg.interview;

public class TreeNode<T extends Comparable> {
	private T value;
	private TreeNode parent;
	private TreeNode left;
	private TreeNode right;
	private int size;

	public TreeNode(T value) {
		this(value, null, null);
	}

	public TreeNode(T value, TreeNode left, TreeNode right) {
		this.value  = value;
		this.parent = null;
		this.left   = left;
		this.right  = right;
		this.size   = 1;
	}

	public TreeNode<T> successor() {
		if (this.right != null)  { return min(this.right); }
		
		TreeNode<T> successor = this.parent;
		
		while (successor != null && successor.value.compareTo(this.value) < 0) {
			successor = successor.parent;
		}

		return successor;
	}

	public TreeNode<T> nodeAt(int i) {
		if (i < 0 || i >= this.size) { throw new IndexOutOfBoundsException(); }

		int sizeL = (this.left == null) ? 0 : this.left.size;
		int sizeR = (this.right == null) ? 0 : this.right.size;

		if (i < sizeL) { return this.left.nodeAt(i); }
		if (i > sizeL) { return this.right.nodeAt(i - sizeL - 1); }
		return this;
	}

	private TreeNode<T> min(TreeNode<T> node) {
		if (node.left == null) { return node; }
		return min(node.left);
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
			node.left.parent = node;
		} else {
			node.right = insert(node.right, value);
			node.right.parent = node;
		}

		node.size++;

		return node;
	}
}
