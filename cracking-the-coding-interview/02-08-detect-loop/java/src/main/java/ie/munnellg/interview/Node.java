package ie.munnellg.interview;

import java.util.Iterator;

public class Node<T> implements Iterable<T> {
	public T data;
	public Node next;
	
	public Node(T data) {
		this(data, null);
	}

	public Node(T data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node kth(int i) {
		if (i == 0)            { return this; }
		if (this.next == null) { return null; }
		return this.next.kth(--i);
	}

	public Iterator<T> iterator() {
		return new NodeIter(this);
	}

	@Override
	public String toString() {
		return new StringBuilder("Node(")
			.append(this.data)
			.append(")")
			.toString();
	}

	public static <T> Node<T> of(T... values) {
		if (values.length <= 0) { return null; }
		
		Node head = new Node(values[0]);
		Node ptr  = head;

		for (int i = 1; i < values.length; i++) {
			ptr.next = new Node(values[i]);
			ptr = ptr.next;
		}

		return head;
	}

	private class NodeIter implements Iterator {
		private Node<T> ptr;

		public NodeIter(Node<T> head) {
			this.ptr = head;
		}

		public boolean hasNext() {
			return this.ptr == null;
		}

		public T next() {
			T data = this.ptr.data;
			this.ptr = ptr.next;
			return data;
		}
	}
}
