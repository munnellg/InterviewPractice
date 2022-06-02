package ie.munnellg.interview;

public class MatrixOps {
	public static final String NULL_INPUT_EXCEPTION_MESSAGE = "rotate input cannot be null";

	public static void rotate(int[][] matrix) {
		if (matrix == null) { throw new NullPointerException(NULL_INPUT_EXCEPTION_MESSAGE); }
		
		for (int i = 0; i < matrix.length / 2; i++) {
			rotateLayer(matrix, i, matrix.length - i - 1);
		}
	}

	private static void rotateLayer(int[][] matrix, int low, int high) {
		for (int i = 0; i < high - low; i++) {
			int tmp                = matrix[high - i][low];  // save bottom left
			matrix[high - i][low]  = matrix[high][high - i]; // bottom right to bottom left
			matrix[high][high - i] = matrix[low + i][high];  // top right to bottom right
			matrix[low + i][high]  = matrix[low][low + i];   // top left to top right
			matrix[low][low + i]   = tmp;                    // old bottom left to top left
		}
	}
}
