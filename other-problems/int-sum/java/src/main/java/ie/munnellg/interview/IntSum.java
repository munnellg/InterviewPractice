package ie.munnellg.interview;

import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class IntSum {
	
	public static Pair<Integer, Integer> find(List<Integer> numbers, Integer target) {
		Set<Integer> seenValues = new HashSet<Integer>(numbers.size());

		for (Integer i : numbers) {
			Integer complement = target - i;

			if (seenValues.contains(complement)) {
				return new Pair(i, complement);
			}

			seenValues.add(i);
		}

		throw new IllegalArgumentException("No values in input set of numbers sum to target value");
	}
}
