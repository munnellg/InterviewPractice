package ie.munnellg.interview;

import java.util.Iterator;

public class Node<T> implements Iterable<T> {

	private T data;
	private Node next;

	public Node() {
		this(null, null);
	}

	public Node(T data) {
		this(data, null);
	}

	public Node(T data, Node next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Iterator<T> iterator() {
		return new NodeIterator<T>(this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append(this.data);
		
		if (this.next != null) {
			sb.append(" -> ").append(this.next.toString());
		}

		return sb.toString();
	}

	public static <T> Node<T> of(T... values) {
		Node head = null;

		for (int i = values.length - 1; i >= 0; i--) {
			Node insert = new Node(values[i], head);
			head = insert;			
		}

		return head;
	}

	private class NodeIterator<T> implements Iterator<T> {
		private Node<T> curr;

		public NodeIterator(Node<T> head) {
			this.curr = head;
		}

		public boolean hasNext() {
			return curr != null;
		}

		public T next() {
			T data = curr.data;
			curr = curr.next;
			return data;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}