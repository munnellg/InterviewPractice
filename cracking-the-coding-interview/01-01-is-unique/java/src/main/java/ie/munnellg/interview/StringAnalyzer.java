package ie.munnellg.interview;

// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional datastructures?

// - What is the size of the alphabet? Assuming unicode?
// - Does the case of characters matter? Assuming no, A == a
// - Remember, chars() returns code points but toCharArray() only works with extended ASCII

import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.List;

public class StringAnalyzer {
	
	protected static final String NULL_STRING_EXCEPTION_MESSAGE = "Input string must not be null";

	public static boolean hasUniqueChars(final String str) throws NullPointerException {
		if (str == null) {
			throw new NullPointerException(NULL_STRING_EXCEPTION_MESSAGE);
		}

		char[] chars = str.toLowerCase().toCharArray();
		
		Arrays.sort(chars);

		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == chars[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static boolean hasUniqueCharsList(final String str) throws NullPointerException {
		if (str == null) {
			throw new NullPointerException(NULL_STRING_EXCEPTION_MESSAGE);
		}

		List<Integer> codepoints = str.toLowerCase()
									.chars()  // get code points
									.sorted() // alphabetize
									.boxed()  // convert IntStream to Stream<Integer>
									.collect(Collectors.toList());

		for (int i = 0; i < codepoints.size() - 1; i++) {
			if (codepoints.get(i) == codepoints.get(i + 1)) {
				return false;
			}
		}

		return true;
	}

	public static boolean hasUniqueCharsBV(final String str) throws NullPointerException {
		if (str == null) {
			throw new NullPointerException(NULL_STRING_EXCEPTION_MESSAGE);
		}

		BitSet characters = new BitSet();
		Iterator<Integer> it = str.toLowerCase().chars().iterator();

		while (it.hasNext()) {
			Integer i = it.next();

			if (characters.get(i)) {
				return false;
			}

			characters.set(i);
		}

		return true;
	}
}
