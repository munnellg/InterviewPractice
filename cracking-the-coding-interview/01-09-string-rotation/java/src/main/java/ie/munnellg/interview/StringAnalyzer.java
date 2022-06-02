package ie.munnellg.interview;

public class StringAnalyzer {
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) { return false; }
		String concat = s2 + s2;
		return concat.contains(s1);
	}
}
