package ie.munnellg.interview;

public class SetOfStacks<T> {

	private static final Integer MAX_STACK_SIZE = 3;
	
	private Stack<T>[] stacks;

	private int headIdx;

	public SetOfStacks() {
		this.stacks    = new Stack[1];
		this.stacks[0] = new Stack<>();
		this.headIdx   = 0;
	}

	public boolean isEmpty() {
		adjustHeadIdx();
		return stacks[headIdx].isEmpty();
	}

	public void push(T data) {
		adjustHeadIdx();

		checkCapacity();

		stacks[headIdx].push(data);
	}

	public T pop() {
		adjustHeadIdx();
		return stacks[headIdx].pop();
	}

	public T peek() {
		adjustHeadIdx();
		return stacks[headIdx].peek();	
	}

	public T popAt(int index) {
		if (index < 0 || index > headIdx) {
			throw new IndexOutOfBoundsException();
		}

		return stacks[index].pop();
	}

	private void adjustHeadIdx() {
		while (stacks[headIdx].isEmpty() && headIdx > 0) {
			headIdx--;
		}
	}

	private void checkCapacity() {
		if (stacks[headIdx].size() >= MAX_STACK_SIZE) {
			headIdx++;
			
			if (headIdx >= this.stacks.length) {
				expand();
			}

			stacks[headIdx] = new Stack<>();
		}
	}

	private void expand() {
		Stack[] expanded = new Stack[this.stacks.length * 2];

		for (int i = 0; i < this.stacks.length; i++) {
			expanded[i] = this.stacks[i];
		}

		this.stacks = expanded;
	}

	public static <T> SetOfStacks<T> of(T... data) {
		SetOfStacks<T> stack = new SetOfStacks();
		
		for (int i = 0; i < data.length; i++) {
			stack.push(data[i]);
		}

		return stack;
	}
}