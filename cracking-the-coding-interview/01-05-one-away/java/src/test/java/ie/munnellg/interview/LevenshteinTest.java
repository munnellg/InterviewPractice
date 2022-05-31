package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LevenshteinTest {
	@Test
	public void testDeleteOne() {
		assertTrue(Levenshtein.isOneAway("pale", "ple"));
	}

	@Test
	public void testReplaceOne() {
		assertTrue(Levenshtein.isOneAway("pale", "bale"));
	}

	@Test
	public void testInsertOne() {
		assertTrue(Levenshtein.isOneAway("pale", "pales"));
	}

	@Test
	public void testMoreThanOneEdit() {
		assertFalse(Levenshtein.isOneAway("pale", "bake"));
	}
}
