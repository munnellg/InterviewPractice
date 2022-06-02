package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MatrixOpsTest {

	@Test
	public void testIrregularSizeInput() {
		int[][] input = {
			{ 1, 1, 1, 1, 1 },
			{ 1, 1, 0, 0, 1 },
			{ 1, 1, 1, 1, 1 }
		};

	    int[][] expected = {
			{ 1, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 1 }
		};

		MatrixOps.zeroMarkedCells(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}

	@Test
	public void testZeroFirstRowInput() {
		int[][] input = {
			{ 1, 1, 1, 0, 1 },
			{ 1, 1, 0, 0, 1 },
			{ 1, 1, 1, 1, 1 }
		};

	    int[][] expected = {
			{ 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 1 }
		};

		MatrixOps.zeroMarkedCells(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}

	@Test
	public void testZeroFirstColInput() {
		int[][] input = {
			{ 1, 1, 1, 1, 1 },
			{ 1, 1, 0, 0, 1 },
			{ 0, 1, 1, 1, 1 }
		};

	    int[][] expected = {
			{ 0, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 }
		};

		MatrixOps.zeroMarkedCells(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}

	@Test
	public void testZeroFirstRowAndColInput() {
		int[][] input = {
			{ 0, 1, 1, 1, 1 },
			{ 1, 1, 0, 0, 1 },
			{ 1, 1, 1, 1, 1 }
		};

	    int[][] expected = {
			{ 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 1 }
		};

		MatrixOps.zeroMarkedCells(input);

		assertTrue(Arrays.deepEquals(input, expected));
	}
}
