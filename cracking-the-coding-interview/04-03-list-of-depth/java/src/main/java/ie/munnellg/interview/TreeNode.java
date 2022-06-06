package ie.munnellg.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

	public T getValue() {
		return this.value;
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

	public static <T extends Comparable> List<List<TreeNode<T>>> depthList(TreeNode<T> tree) {
		List<List<TreeNode<T>>> depthLists = new ArrayList<List<TreeNode<T>>>();
		buildDepthList(depthLists, tree, 0);
		return depthLists;
	}

	private static <T extends Comparable> void buildDepthList(List<List<TreeNode<T>>> list, TreeNode<T> tree, int depth) {
		if (tree == null) { return; }
		while (list.size() <= depth) { list.add(new LinkedList<TreeNode<T>>()); }
		list.get(depth).add(tree);
		buildDepthList(list, tree.left, depth + 1);
		buildDepthList(list, tree.right, depth + 1);
	}
}
