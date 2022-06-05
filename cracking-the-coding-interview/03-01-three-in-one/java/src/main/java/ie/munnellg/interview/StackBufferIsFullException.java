package ie.munnellg.interview;

public class StackBufferIsFullException extends RuntimeException {
	
	private static final String DEFAULT_MESSAGE = "StackBuffer is full";

	public StackBufferIsFullException() {
		super(DEFAULT_MESSAGE);
	}

	public StackBufferIsFullException(String msg) {
		super(msg);
	}	
}