package ie.munnellg.interview;

public class CircularDependencyException extends RuntimeException {
	public CircularDependencyException() {
		super("Circular dependency detected");
	}
}