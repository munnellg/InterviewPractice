package ie.munnellg.interview;

import java.util.Iterator;

public class Node implements Iterable {
	public Integer digit;
	public Node next;
	
	public Node(Integer digit) {
		this(digit, null);
	}

	public Node(Integer digit, Node next) {
		this.digit = digit;
		this.next  = next;
	}

	public Iterator iterator() {
		return new NodeIter(this);
	}

	@Override
	public String toString() {
		return new StringBuilder("Node(")
			.append(this.digit)
			.append(")")
			.toString();
	}

	public static  Node of(Integer... values) {
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
		private Node ptr;

		public NodeIter(Node head) {
			this.ptr = head;
		}

		public boolean hasNext() {
			return this.ptr == null;
		}

		public Integer next() {
			Integer digit = this.ptr.digit;
			this.ptr = ptr.next;
			return digit;
		}
	}
}
