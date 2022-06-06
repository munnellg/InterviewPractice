package ie.munnellg.interview;

import java.util.Random;

public class BinarySearchTree<T extends Comparable> {
	private Node root;

	private final Random prng;

	public BinarySearchTree() {
		this.root = null;
		this.prng = new Random();
	}

	public void insert(T value) {
		this.root = insert(this.root, value);
	}

	public Node<T> find(T value) {
		return find(this.root, value);
	}

	public int size() {
		return this.root == null ? 0 : this.root.size;
	}

	public Node<T> getRandomNode() {
		if (this.root == null) { return null; }
		return nodeAt(this.root, prng.nextInt(root.size));
	}

	private Node<T> find(Node<T> node, T value) {
		if (node == null) { return null; }
		int compare = node.value.compareTo(value);
		if (compare == 0) { return node; }
		if (compare >= 0) { return find(node.left, value); }
		return find(node.right, value);
	}

	private Node<T> insert(Node<T> node, T value) {
		if (node == null) { return new Node(value); }
		
		if (node.value.compareTo(value) >= 0) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}

		node.size++;

		return node;
	}

	private Node<T> nodeAt(Node<T> node, int index) {
		if (node == null) { return null; }
		int sizeLeft  = (node.left == null)? 0 : node.left.size;
		int sizeRight = (node.right == null)? 0 : node.right.size;
		
		if (index < sizeLeft) { return nodeAt(node.left, index); }
		if (index > sizeLeft) { return nodeAt(node.right, index - sizeLeft - 1); }
		return node;
	}

	public static <T extends Comparable> BinarySearchTree<T> of(T... values) {
		BinarySearchTree<T> bst = new BinarySearchTree();

		for (int i = 0; i < values.length; i++) {
			bst.insert(values[i]);
		}

		return bst;
	}

	public static class Node<T> {
		private T value;
		private Node left;
		private Node right;
		private int size;

		private Node(T value) {
			this.value  = value;
			this.left  = null;
			this.right = null;
			this.size  = 1;
		}

		public T value() { return this.value; }
		public void value(T value) { this.value = value; }
		public Node<T> left() { return this.left; }
		public void left(Node<T> left) { this.left = left; }
		public Node<T> right() { return this.right; }
		public void right(Node<T> right) { this.right = right; }
	}
}
