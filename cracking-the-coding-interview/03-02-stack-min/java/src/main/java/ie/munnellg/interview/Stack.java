package ie.munnellg.interview;

public class Stack<T extends Comparable> {
	
	private StackNode head;

	public Stack() {
		this.head = null;
	}

	public T pop() {
		T data = head.data;
		head = head.prev;
		return data;
	}

	public void push(T data) {
		head = new StackNode(data, head);
	}

	public boolean isEmpty() {
		return head == null;
	}

	public T peek() {
		return head.data;
	}

	public T min() {
		return (head == null)? null : head.min;
	}

	public static <T extends Comparable> Stack<T> of(T... values) {
		Stack<T> stack = new Stack();

		for (int i = 0; i < values.length; i++) {
			stack.push(values[i]);
		}

		return stack;
	}

	private class StackNode {
		private T data;
		private StackNode prev;
		private T min;

		public StackNode(T data) {
			this(data, null);
		}

		public StackNode(T data, StackNode prev) {
			this.data = data;
			this.prev = prev;
			this.min  = (prev == null)? this.data : (this.data.compareTo(prev.data) > 0)? prev.data : this.data;
		}
	}
}
