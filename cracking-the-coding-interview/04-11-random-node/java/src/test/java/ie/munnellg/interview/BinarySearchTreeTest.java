package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class BinarySearchTreeTest {

    @Test
    public void test() {
    	final int NUMBER_OF_SAMPLES   = 100000;
    	final Double ACCEPTABLE_ERROR = 0.01;

        BinarySearchTree<Integer> tree = BinarySearchTree.of(4, 1, 2, 3, 0, 7, 5, 6, 8, 9);
        double[] counts = new double[tree.size()];

        // count how often each value gets picked
        for (int i = 0; i < NUMBER_OF_SAMPLES; i++) {
        	counts[tree.getRandomNode().value()] += 1.0;
        }

        // in a perfect world, over a long enough number of samples,
        // all values will be picked exactly the same number of times
        Double forecast = (double) NUMBER_OF_SAMPLES / (double) counts.length;
        Double mape = mape(counts, forecast); // mean average percentage error
        assertTrue(mape < ACCEPTABLE_ERROR);
    }

    private Double mape(double[] counts, double expected) {
    	
    	Double sum = 0.0;
    	for (int i = 0; i < counts.length; i++) {
    		if (counts[i] == 0.0) { return Double.NaN; }
    		sum += Math.abs((counts[i] - expected) / counts[i]);
    	}

    	return sum / counts.length;
    }
}
