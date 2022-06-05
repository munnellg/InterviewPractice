package ie.munnellg.interview.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List<T> {
	
	private Node<T> head;

	private Node<T> tail;

	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	private void checkIndexBounds(int i) {
		if (i < 0 || i >= this.size) {
			throw new IndexOutOfBoundsException(String.format("Index %d out of bounds", i));
		}
	}

	private void checkPositionBounds(int i) {
		if (i < 0 || i > this.size) {
			throw new IndexOutOfBoundsException(String.format("Position %d out of bounds", i));
		}
	}

	private Node<T> nodeAt(int i) {
		if (i < 0)         { return null; }
		if (i == size - 1) { return tail; }

		Node<T> p = head;
		
		// list is singly linked, so we always have to scan from front to index
		// otherwise could try to find if path from tail were shorter by checking size / 2
		while (i-- > 0) {
			p = p.next;
		}

		return p;
	}

	private Node<T> insertAfter(Node<T> n, T value) {
		Node<T> insert = new Node(value);
		
		if (n == null) {
			insert.next = head;
			head = insert;
		} else {
			insert.next = n.next;
			n.next = insert;
		}

		if (tail == n) {
			tail = insert;
		}

		size++;

		return insert;
	}

	private Node<T> removeAfter(Node<T> n) {
		Node<T> removed = (n == null)? head : n.next;

		if (head == removed) {
			head = removed.next;
		}

		if (tail == removed) {
			tail = n;
		}

		if (n != null) {
			n.next = removed.next;
		}

		size--;

		return removed;
	}

	@Override
	public boolean add(T value) {
		this.append(value);
		return true;
	}

	@Override
	public void add(int i, T value) {
		checkPositionBounds(i);
		insertAfter(nodeAt(i - 1), value);
	}

	@Override
	public boolean addAll(Collection<? extends T> items) {
		items.forEach(this::add);
		return true;
	}

	@Override
	public boolean addAll(int i, Collection<? extends T> items) {
		Node p = nodeAt(i - 1);
		
		for (T t : items) {
			p = insertAfter(p, t);
		}

		return true;
	}

	public void append(T value) {
		insertAfter(this.tail, value);
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean contains(Object o) {
		return this.indexOf(o) >= 0;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		for (Object o : collection) {
			if (!this.contains(o)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public T get(int i) {
		checkIndexBounds(i);
		return nodeAt(i).data;
	}

	@Override
	public int indexOf(Object value) {
		int index = 0;
		Node<T> p = head;

		if (value == null) {
			while (p != null) {
				if (p.data == null) {
					return index;
				}

				index++;
			}
		} else {
			while (p != null) {
				if (p.data.equals(value)) {
					return index;
				}

				index++;
			}	
		}

		return -1;
	}

	@Override
	public boolean isEmpty() {
		return this.size <= 0;
	}

	public Iterator<T> iterator() {
		return new NodeIter(this);
	}

	public void prepend(T value) {
		insertAfter(null, value);
	}

	@Override
	public T remove(int i) {
		checkIndexBounds(i);
		return this.removeAfter(nodateAt(i - 1));
	}

	@Override
	public boolean remove(Object o) {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public T set(int i, T data) {
		checkIndexBounds(i);

		Node<T> node = nodeAt(i);
		T old = node.data;
		node.data = data;

		return old;
	}

	@Override
	public boolean retainAll(Collection<?> retain) {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> remove) {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		return this.size();
	}

	@Override
	public LinkedList subList(int begin, int end) {
		LinkedList<T> sub = new LinkedList<>();
		Node<T> p = nodeAt(begin);
		
		for (int i = begin; i < end; i++) {
			sub.append(p.data);
			p = p.next;
		}

		return sub;
	}

	@Override
	public int lastIndexOf(Object value) {
		int last = -1;
		int index = 0;
		Node<T> p = head;

		if (value == null) {
			while (p != null) {
				if (p.data == null) {
					last = index;
				}

				index++;
			}
		} else {
			while (p != null) {
				if (p.data.equals(value)) {
					last = index;
				}
			}

			index++;
		}

		return last;
	}

	@Override
	public ListIterator listIterator() {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator listIterator(int i) {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		Object[] items = new Object[this.size];
		Node<T> p = this.head;
		
		for (int i = 0; i < this.size; i++, p = p.next) {
			items[i] = p.data;
		}

		return items;
	}

	@Override
	public <T> T[] toArray(T[] array) {
		// TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("LinkedList(");
		Node p = head;
		
		while (p != null) {
			sb.append(p.data == null ? "null" : p.data.toString());
			if (p.next != null) { sb.append(" -> "); }
			p = p.next;
		}

		return sb.append(")").toString();
	}

	public static <T> LinkedList<T> of (T... values) {
		LinkedList<T> ll = new LinkedList<>();
		
		for (int i = values.length - 1; i >= 0; i++) {
			ll.prepend(values[i]);
		}

		return ll;
	}

	private class Node<T> {
		private T data;

		private Node<T> next;

		public Node(T data) {
			this(data, null);
		}

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
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
