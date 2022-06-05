package ie.munnellg.interview;

public class Stack<T> {

	private StackNode<T> head;
	private int size;

	public Stack() {
		this.head = null;
		this.size = 0;
	}

	public void push(T data) {
		head = new StackNode(data, head);
		size++;
	}

	public T pop() {
		if (head == null) { 
			throw new EmptyStackException();
		}

		T data = head.data;
		head = head.next;
		size--;
		return data;
	}

	public T peek() {
		if (head == null) { return null; }
		return head.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return this.size;
	}

	public static <T> Stack<T> of(T... data) {
		Stack<T> stack = new Stack();
		
		for (int i = 0; i < data.length; i++) {
			stack.push(data[i]);
		}

		return stack;
	}

	private class StackNode<T> {
		private T data;
		private StackNode next;

		public StackNode(T data, StackNode next) {
			this.data = data;
			this.next = next;
		}
	}
}
