package ie.munnellg.interview;

public class StackSort {
	public static <T extends Comparable> void sort(Stack<T> stack) {
		Stack<T> buffer = new Stack<>();

		while (!stack.isEmpty()) {
			T value = stack.pop();
			
			while (!buffer.isEmpty() && value.compareTo(buffer.peek()) > 0) {
				stack.push(buffer.pop());
			}

			buffer.push(value);
		}

		while (!buffer.isEmpty()) {
			stack.push(buffer.pop());
		}
	}
}
