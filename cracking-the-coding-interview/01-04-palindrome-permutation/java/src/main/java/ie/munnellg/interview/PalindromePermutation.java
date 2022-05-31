package ie.munnellg.interview;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PalindromePermutation {
	private static final Pattern NON_LETTER_CHARACTERS = Pattern.compile("\\W");

	public static boolean isPermutation(String s) {
		// null strings are not permutations of a palindrome
		if (s == null) { return false; }

		// remove all non-letter characters
		s = NON_LETTER_CHARACTERS.matcher(s.toLowerCase()).replaceAll("");

		// empty strings are not palindrome permutations
		if (s.isEmpty()) { return false; }

		// build a hashmap of each character's frequency in the string
		Map<Character, Integer> characterCounts = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			Integer count = characterCounts.getOrDefault(c, 0) + 1;
			characterCounts.put(c, count);
		}

		// count instances of odd characters in the string
		int oddCount = 0;

		for (Integer i : characterCounts.values()) {
			oddCount += i % 2;
		}

		// if the string is an odd length, then we should have one odd count
		// if the string is an even length, then we should have no odd counts
		return (oddCount == s.length() % 2);
	}

	public static boolean isPermutationBS(String s) {
		// null strings are not permutations of a palindrome
		if (s == null) { return false; }

		// remove all non-letter characters
		s = NON_LETTER_CHARACTERS.matcher(s.toLowerCase()).replaceAll("");

		// empty strings are not palindrome permutations
		if (s.isEmpty()) { return false; }

		BitSet bitset = new BitSet();

		for (int i = 0; i < s.length(); i++) {
			bitset.flip(s.charAt(i));
		}

		return bitset.cardinality() == s.length() % 2;
	}
}
