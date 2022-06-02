package ie.munnellg.interview;

public class MatrixOps {
	public static void zeroMarkedCells(int[][] matrix) {
		int[] zeroFirstRowColFlags = { 0, 0 };
		
		markCells(matrix, zeroFirstRowColFlags);

		zeroCells(matrix, zeroFirstRowColFlags);
	}

	private static void markCells(int[][] matrix, int[] zeroFirstRowColFlags) {
		int height = matrix.length;
		int width  = matrix[0].length;

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (matrix[row][col] == 0) {
					if (row == 0) {
						zeroFirstRowColFlags[0] = 1;
					} else {
						matrix[row][0] = 0;
					}

					if (col == 0) {
						zeroFirstRowColFlags[1] = 1;
					} else {
						matrix[0][col] = 0;
					}
				}
			}
		}
	}

	private static void zeroCells(int[][] matrix, int[] zeroFirstRowColFlags) {
		boolean zeroFirstRow = zeroFirstRowColFlags[0] == 1;
		boolean zeroFirstCol = zeroFirstRowColFlags[1] == 1;

		for (int row = 1; row < matrix.length; row++) {
			if (matrix[row][0] == 0) {
				zeroRow(matrix, row);
			}
		}

		for (int col = 1; col < matrix[0].length; col++) {
			if (matrix[0][col] == 0) {
				zeroCol(matrix, col);
			}
		}

		if (zeroFirstRow) { zeroRow(matrix, 0); }
		if (zeroFirstCol) { zeroCol(matrix, 0); }
	}

	private static void zeroCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	private static void zeroRow(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}
}
