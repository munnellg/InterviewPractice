package ie.munnellg.interview;

public class SingleEditDistanceChecker {

	public static boolean isOneAway(final String s1, final String s2) {
		int lengthDiff = s1.length() - s2.length();

		// if the strings differ in length by more than 1, then they're
		// definitely more than one edit distance away
		if (Math.abs(lengthDiff) > 1) {
			return false;
		}

		// initialize references - p1 is shorter of two strings
		String p1 = (lengthDiff < 0) ? s1 : s2;
		String p2 = (lengthDiff < 0) ? s2 : s1;

		int i1 = 0;
		int i2 = 0;
		int diffCount = 0;

		while (i1 < p1.length() && i2 < p2.length()) {
			// if the characters at current position don't match
			if (p1.charAt(i1) != p2.charAt(i2)) {
				// check if we've already found a difference
				// in which case the edit distance is greater than 1
				if (++diffCount > 1) {
					return false;
				}

				// if the strings are the same length, we're performing a replacement
				// move s1
				if (p1.length() == p2.length()) {
					i1++;
				}
			} else {
				i1++; // if matching, move shorter pointer
			}

			i2++; // always move longer pointer
		}

		return true;
	}
}
