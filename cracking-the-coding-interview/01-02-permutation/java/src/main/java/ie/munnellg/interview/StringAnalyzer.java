package ie.munnellg.interview;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// - Does case matter? Assuming no, A == a
// - What alphabet are we using? Assuming unicode
// - Is null a valid input, and if so what does it mean? Assuming no, it's not valid
// - Are there any characters we want to ignore? Assuming we want to ignore spaces & punctuation

public class StringAnalyzer {
	
	protected static final String NULL_INPUT_EXCEPTION_MESSAGE = "Neither input to isPermutation can be null";
	protected static final Pattern INVALID_CHARACTER_REGEX     = Pattern.compile("[\\s\\p{Punct}]");

	// O(n) time; O(n) space
	public static boolean isPermutation(final String s1, final String s2) {

		if (s1 == null || s2 == null) {
			throw new NullPointerException(StringAnalyzer.NULL_INPUT_EXCEPTION_MESSAGE);
		}

		return preprocess(s1).equals(preprocess(s2));
	}

	private static List<Integer> preprocess(String s) {
		// regex may use O(2 ^ m) space where m is the size of the regex
		return INVALID_CHARACTER_REGEX.matcher(s.toLowerCase()) // case doesn't matter -- convert all to lower case...
			.replaceAll("")                // ... and remove any non-word characters with regex
			.codePoints()                  // get unicode chars
			.sorted()                      // sort chars alphabetically - O(n log n)
			.boxed()                       // convert from IntStream to Stream<Integer>
			.collect(Collectors.toList()); // gather to List
	}
}
