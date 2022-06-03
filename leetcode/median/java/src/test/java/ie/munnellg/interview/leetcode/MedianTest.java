package ie.munnellg.interview.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class MedianTest {

    @Test
    public void testMergedOddLength() {
        double[] nums1 = { 1.0, 3.0 };
        double[] nums2 = { 2.0 };
        assertEquals(2.0, Median.median(nums1, nums2));
    }

    @Test
    public void testMergedEvenLength() {
        double[] nums1 = { 1.0, 2.0 };
        double[] nums2 = { 3.0, 4.0 };
        assertEquals(2.5, Median.median(nums1, nums2));
    }

    @Test
    public void testConcatToMerge() {
    	double[] nums1 = { 1.0, 2.0, 3.0 };
    	double[] nums2 = { 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 };
    	assertEquals(5.0, Median.median(nums1, nums2));
    }

    @Test
    public void testInterlaceToMerge() {
    	double[] nums1 = { 1.0, 3.0, 5.0, 7.0 };
    	double[] nums2 = { 2.0, 4.0, 6.0, 8.0, 9.0, 10.0 };
    	assertEquals(5.5, Median.median(nums1, nums2));
    }

	@Test
	public void testEmptyList() {
		double[] nums1 = {};
		double[] nums2 = {};
		
		try {
			Median.median(nums1, nums2);
			fail("Median.median should throw an exception for empty input");
		} catch (IllegalArgumentException ex) {
			assertEquals(Median.EMPTY_INPUT_EXCEPTION_MESSAGE, ex.getMessage());
		}
	}

	@Test
    public void testNullInput() {
    	double[] nums1 = { 1.0 };
    	double[] nums2 = { 2.0 };
    	
		try {
			Median.median(null, nums2);
			fail("Median.median should throw an exception for null input");
		} catch (NullPointerException ex) {
			assertEquals(Median.NULL_INPUT_EXCEPTION_MESSAGE, ex.getMessage());
		}

		try {
			Median.median(nums1, null);
			fail("Median.median should throw an exception for null input");
		} catch (NullPointerException ex) {
			assertEquals(Median.NULL_INPUT_EXCEPTION_MESSAGE, ex.getMessage());
		}
    }
}
