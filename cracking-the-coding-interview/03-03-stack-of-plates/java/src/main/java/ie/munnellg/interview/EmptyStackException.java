package ie.munnellg.interview;

public class EmptyStackException extends RuntimeException {
	private static final String DEFAULT_MESSAGE = "Stack is empty";

	public EmptyStackException() {
		super(DEFAULT_MESSAGE);
	}

	public EmptyStackException(String msg) {
		super(msg);
	}
}