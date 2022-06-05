package ie.munnellg.interview;

import java.util.EmptyStackException;

public class StackBuffer {
	private int bufPtr;
	private StackNode[] buffer;

	public StackBuffer(int bufferSize) {
		bufPtr   = 0;
		buffer   = new StackNode[bufferSize];
	}

	private <T> StackNode<T> allocate(T data) {
		int oldBufPtr = bufPtr;

		while (buffer[bufPtr] != null) {
			bufPtr = (bufPtr + 1) % this.buffer.length;
			
			if (bufPtr == oldBufPtr) {
				throw new StackBufferIsFullException();
			}
		}

		this.buffer[this.bufPtr] = new StackNode<T>(data, this.bufPtr);
		return this.buffer[this.bufPtr];
	}

	private void deallocate(int i) {
		this.buffer[i] = null;
	}

	public <T> Stack<T> stack() {
		return new Stack<T>(this);
	}

	public <T> Stack<T> stack(T... values) {
		Stack<T> stack = new Stack<T>(this);
		
		for (int i = 0; i < values.length; i++) {
			stack.push(values[i]);
		}

		return stack;
	}

	private static class StackNode<T> {
		private int index;
		private T data;
		private StackNode next;
			
		public StackNode(T data, int index) {
			this.data  = data;
			this.index = index;
			this.next  = null;
		}
	}

	public static class Stack<T> {
		private StackBuffer buffer;
		private StackNode<T> head;

		private Stack(StackBuffer buffer) {
			this.buffer = buffer;
			this.head   = null;
		}

		public void push(T value) {
			StackNode<T> insert = this.buffer.allocate(value);
			insert.next = this.head;
			this.head = insert;
		}

		public T pop() {
			if (this.head == null) {
				throw new EmptyStackException();
			}

			T data = head.data;

			this.buffer.deallocate(head.index);

			head = head.next;

			return data;
		}

		public T peek() {
			if (this.head == null) {
				throw new EmptyStackException();
			}

			return head.data;
		}

		public boolean isEmpty() {
			return head == null;
		}
	}
}