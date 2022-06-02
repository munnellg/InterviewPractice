package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MatrixOpsTest {

	@Test
	public void testBlankMatrix() {
		int[][] input    = {{}};
		int[][] expected = {{}};
		
		MatrixOps.rotate(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}

	@Test
	public void testSingleCellMatrix() {
		int[][] input = {{1}};
		int[][] expected = {{1}};

		MatrixOps.rotate(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}

	@Test
	public void testOddSizedMatrix() {
		int[][] input = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		int[][] expected = {
			{7, 4, 1},
			{8, 5, 2},
			{9, 6, 3}
		};

		MatrixOps.rotate(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}

	@Test
	public void testEvenSizedMatrix() {
		int[][] input = {
			{ 1,  2,  3,  4},
			{ 5,  6,  7,  8},
			{ 9, 10, 11, 12},
			{13, 14, 15, 16}
		};

		int[][] expected = {
			{13,  9,  5,  1},
			{14, 10,  6,  2},
			{15, 11,  7,  3},
			{16, 12,  8,  4}
		};

		MatrixOps.rotate(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}

	@Test
	public void testLargeOddSizedMatrix() {
		int[][] input = {
			{ 1,  2,  3,  4,  5,  6,  7},
			{ 8,  9, 10, 11, 12, 13, 14},
			{15, 16, 17, 18, 19, 20, 21},
			{22, 23, 24, 25, 26, 27, 28},
			{29, 30, 31, 32, 33, 34, 35},
			{36, 37, 38, 39, 40, 41, 42},
			{43, 44, 45, 46, 47, 48, 49},
		};

		int[][] expected = {
			{43, 36, 29, 22, 15,  8,  1},
			{44, 37, 30, 23, 16,  9,  2},
			{45, 38, 31, 24, 17, 10,  3},
			{46, 39, 32, 25, 18, 11,  4},
			{47, 40, 33, 26, 19, 12,  5},
			{48, 41, 34, 27, 20, 13,  6},
			{49, 42, 35, 28, 21, 14,  7},
		};

		MatrixOps.rotate(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}

	@Test
	public void testLargeEvenSizedMatrix() {
		int[][] input = {
			{ 1,  2,  3,  4,  5,  6,  7, 8},
			{ 9, 10, 11, 12, 13, 14, 15, 16},
			{17, 18, 19, 20, 21, 22, 23, 24},
			{25, 26, 27, 28, 29, 30, 31, 32},
			{33, 34, 35, 36, 37, 38, 39, 40},
			{41, 42, 43, 44, 45, 46, 47, 48},
			{49, 50, 51, 52, 53, 54, 55, 56},
			{57, 58, 59, 60, 61, 62, 63, 64}
		};

		int[][] expected = {
			{57, 49, 41, 33, 25, 17,  9,  1},
			{58, 50, 42, 34, 26, 18, 10,  2},
			{59, 51, 43, 35, 27, 19, 11,  3},
			{60, 52, 44, 36, 28, 20, 12,  4},
			{61, 53, 45, 37, 29, 21, 13,  5},
			{62, 54, 46, 38, 30, 22, 14,  6},
			{63, 55, 47, 39, 31, 23, 15,  7},
			{64, 56, 48, 40, 32, 24, 16,  8}
		};

		MatrixOps.rotate(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}

	@Test
	public void testNullInput() {
		try {
			MatrixOps.rotate(null);	
			fail("MatrixOps.rotate did not throw the expected NullPointerException exception");
		} catch (NullPointerException ex) {
			assertEquals(MatrixOps.NULL_INPUT_EXCEPTION_MESSAGE, ex.getMessage());
		}
		
	}
}
