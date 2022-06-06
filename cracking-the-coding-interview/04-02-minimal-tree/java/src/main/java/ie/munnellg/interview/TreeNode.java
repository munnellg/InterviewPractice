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

	public int height() {
		int hLeft  = (left == null) ? 0 : left.height();
		int hRight = (right == null) ? 0 : right.height();
		return Math.min(hLeft, hRight) + 1;
	}

	public int size() {
		int sLeft  = (left == null) ? 0 : left.size();
		int sRight = (right == null) ? 0 : right.size();
		return sLeft + sRight + 1;	
	}

	public void print() {
		if (this.left != null) { this.left.print(); }
		System.out.println(this.value);
		if (this.right != null) { this.right.print(); }
	}

	public static <T extends Comparable> TreeNode<T> of(T... values) {
		for (int i = 0; i < values.length - 1; i++) {
			if (values[i].compareTo(values[i + 1]) > 0) {
				throw new IllegalArgumentException("Input values must be in ascending sorted order");
			}
		}

		return build(values, 0, values.length - 1);
	}

	private static<T extends Comparable> TreeNode<T> build(T[] values, int low, int high) {
		if (low > high) { return null; }
		int mid = (low + high) / 2;

		return new TreeNode<T>(values[mid], build(values, low, mid - 1), build(values, mid + 1, high));
	}
}
