package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SingleEditDistanceCheckerTest {
	@Test
	public void testDeleteOne() {
		assertTrue(SingleEditDistanceChecker.isOneAway("pale", "ple"));
	}

	@Test
	public void testReplaceOne() {
		assertTrue(SingleEditDistanceChecker.isOneAway("pale", "bale"));
	}

	@Test
	public void testInsertOne() {
		assertTrue(SingleEditDistanceChecker.isOneAway("pale", "pales"));
	}

	@Test
	public void testMoreThanOneEdit() {
		assertFalse(SingleEditDistanceChecker.isOneAway("pale", "bake"));
	}
}
