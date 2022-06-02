package ie.munnellg.interview;

public class Arithmetic {
	public static int multiply(int a, int b) {
		if (b == 0) { return 0; }
		if (b == 1) { return a; }
		return multiply(a << 1, b >> 1) + (((b & 1) == 0)? 0 : a);
	}
}
