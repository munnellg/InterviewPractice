package ie.munnellg.interview.leetcode;

public class Median {
	protected static final String EMPTY_INPUT_EXCEPTION_MESSAGE = "Size of merged arrays cannot be 0";
	protected static final String NULL_INPUT_EXCEPTION_MESSAGE  = "Inputs to median cannot be null";

	// O(n + m)
	public static double medianSlow(double[] list1, double[] list2) {
		if (list1 == null) { throw new NullPointerException(Median.NULL_INPUT_EXCEPTION_MESSAGE); }
		if (list2 == null) { throw new NullPointerException(Median.NULL_INPUT_EXCEPTION_MESSAGE); }

		int len1 = list1.length;
		int len2 = list2.length;
		int mergedLen = len1 + len2;
		if (mergedLen <= 0) { throw new IllegalArgumentException(Median.EMPTY_INPUT_EXCEPTION_MESSAGE); }

		double[] merged = new double[mergedLen];

		int i1 = 0, i2 = 0;
		while (i1 < len1 && i2 < len2) {
			if (list1[i1] < list2[i2]) {
				merged[i1 + i2] = list1[i1++];
			} else {
				merged[i1 + i2] = list2[i2++];
			}
		}

		while (i1 < len1) { merged[i1 + i2] = list1[i1++]; }
		while (i2 < len2) { merged[i2 + i1] = list2[i2++]; }

		int iMedian = merged.length / 2;

		return merged.length % 2 == 0 ? (merged[iMedian] + merged[iMedian - 1]) / 2.0 : merged[iMedian];
	}

	public static double median(double[] list1, double[] list2) {
		if (list1 == null) { throw new NullPointerException(Median.NULL_INPUT_EXCEPTION_MESSAGE); }
		if (list2 == null) { throw new NullPointerException(Median.NULL_INPUT_EXCEPTION_MESSAGE); }

		int len1 = list1.length;
		int len2 = list2.length;
		int mergedLen = len1 + len2;
		if (mergedLen <= 0) { throw new IllegalArgumentException(Median.EMPTY_INPUT_EXCEPTION_MESSAGE); }

		if (list1[0] > list2[len2 - 1]) {
			if (len1 == len2) {
				return (list1[0] + list2[len2 - 1]) / 2;
			}
		}

		if (list2[0] > list1[len1 - 1]) {
			if (len1 == len2) {
				return (list2[0] + list1[len1 - 1]) / 2;
			}
		}

		double median1 = Median.median(list1);
		double median2 = Median.median(list2);

		int closest1 = binarySearch(list1, median2);
		int closest2 = binarySearch(list2, median1);

		// for (int i = 0; i < len1; i++) { System.out.print(String.format("%f ", list1[i])); }
		// System.out.println();
		// for (int i = 0; i < len2; i++) { System.out.print(String.format("%f ", list2[i])); }
		// System.out.println();
		// System.out.println(String.format("median1  = %f : median2  = %f", median1, median2));
		// System.out.println(String.format("closest1 = %d : closest2 = %d", closest1, closest2));

		return 0.0;
	}

	private static double median(double[] list) {
		int mid = list.length / 2;
		return (list.length % 2 == 0)? (list[mid] + list[mid - 1]) / 2  : list[mid];
	}

	public static int binarySearch(double[] list, double target) {
		int min = 0, max = list.length - 1;

		while (min <= max) {

			int idx = (min + max) / 2;

			if (list[idx] == target) {
				return idx;
			} else if (list[idx] < target) {
				min = idx + 1;
			} else {
				max = idx - 1;
			}
		}
		if (max < 0) { return min; }
		if (min >= list.length) { return max; }
		return (list[min] - target < target - list[max]) ? max : min;
	}
}
