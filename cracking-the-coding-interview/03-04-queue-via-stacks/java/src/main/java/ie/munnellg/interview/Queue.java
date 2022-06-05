package ie.munnellg.interview;

public class Queue<T> {
	private Stack<T> enqueueBuf;
	private Stack<T> dequeueBuf;

	public Queue() {
		this.enqueueBuf = new Stack<>();
		this.dequeueBuf = new Stack<>();
	}

	public void enqueue(T t) {
		enqueueBuf.push(t);
	}

	public T dequeue() {
		swap();
		return dequeueBuf.pop();
	}

	public T peek() {
		swap();
		return dequeueBuf.peek();
	}

	public boolean isEmpty() {
		return enqueueBuf.isEmpty() && dequeueBuf.isEmpty();
	}

	private void swap() {
		if (dequeueBuf.isEmpty()) {
			while (!enqueueBuf.isEmpty()) {
				dequeueBuf.push(enqueueBuf.pop());
			}	
		}
	}

	public static <T> Queue<T> of(T... values) {
		Queue<T> queue = new Queue<>();

		for (int i = 0; i < values.length; i++) {
			queue.enqueue(values[i]);
		}

		return queue;
	}
}