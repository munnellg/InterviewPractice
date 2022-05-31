package ie.munnellg.interview;

public class Levenshtein {

	public static boolean isOneAway(final String s1, final String s2) {
		int[] v0 = new int[s2.length() + 1];
		int[] v1 = new int[s2.length() + 1];

		// initialize the previous row -- number of edits from empty string to s1
		for (int i = 0; i < v0.length; i++) {
			v0[i] = i;
		}

		for (int i = 0; i < s1.length() - 1; i++) {

			// first element of v1 is A[i + 1][0]
			//  edit distance is delete (i + 1) chars from s to match empty t
			v1[0] = i + 1;

			for (int j = 0; j < s2.length() - 1; j++) {
				int deleteCost  = v0[j + 1] + 1;
				int insertCost  = v1[j] + 1;
				int replaceCost = s1.charAt(i) == s2.charAt(j) ? v0[j] : v0[j] + 1;

				v1[j + 1] = Math.min(Math.min(deleteCost, insertCost), replaceCost);
			}

			// swap the arrays for the next iteration as we compute the next row of the matrix
			int[] tmp = v1;
			v1 = v0;
			v0 = tmp;
		}

		return v0[s2.length() - 1] < 2;
	}
}
