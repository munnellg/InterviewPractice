package ie.munnellg.interview;

public class StringCompressor {
	protected static final String NULL_INPUT_EXCEPTION_MSG = "Input to compress cannot be null";

	public static String compress(String s) {
		if (s == null)   { throw new NullPointerException(NULL_INPUT_EXCEPTION_MSG); }
		if (s.isEmpty()) { return s; }
		
		char current = s.charAt(0);
		int count = 1;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == current) {
				count++;
			} else {
				sb.append(current).append(count);
				current = s.charAt(i);
				count = 1;				
			}
		}

		sb.append(current).append(count);

		String compressed = sb.toString();

		return (compressed.length() < s.length())? compressed : s;
	}
}
