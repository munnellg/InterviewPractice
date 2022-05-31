package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class PalindromePermutationTest {

	@Test
	public void testPalindromeIsTrue() {
		// odd number of characters
		assertTrue(PalindromePermutation.isPermutation("tactcoa"));
		// even number of characters
		assertTrue(PalindromePermutation.isPermutation("tactca"));
	}

	@Test
	public void testPalindromeIsFalse() {
		// odd number of characters
		assertFalse(PalindromePermutation.isPermutation("ctcoa"));
		// even number of characters
		assertFalse(PalindromePermutation.isPermutation("actcoa"));
	}

	@Test
	public void testCaseInsensitive() {
		assertTrue(PalindromePermutation.isPermutation("TactCoa"));
	}

	@Test
	public void testIgnoresNonLetterCharacters() {
		assertTrue(PalindromePermutation.isPermutation("tact coa."));
	}

	@Test
	public void testNullInput() {
		assertFalse(PalindromePermutation.isPermutation(null));
	}

	@Test
	public void testEmptyInput() {
		assertFalse(PalindromePermutation.isPermutation(""));
		assertFalse(PalindromePermutation.isPermutation("   "));
		assertFalse(PalindromePermutation.isPermutation("..."));
		assertFalse(PalindromePermutation.isPermutation(",,,"));
		assertFalse(PalindromePermutation.isPermutation(";;;"));
		assertFalse(PalindromePermutation.isPermutation("@@@"));
	}

	@Test
    public void testBSPalindromeIsTrue() {
    	// odd number of characters
        assertTrue(PalindromePermutation.isPermutationBS("tactcoa"));
        // even number of characters
        assertTrue(PalindromePermutation.isPermutationBS("tactca"));
    }

    @Test
    public void testBSPalindromeIsFalse() {
    	// odd number of characters
        assertFalse(PalindromePermutation.isPermutationBS("ctcoa"));
        // even number of characters
        assertFalse(PalindromePermutation.isPermutationBS("actcoa"));
    }

    @Test
    public void testBSCaseInsensitive() {
    	assertTrue(PalindromePermutation.isPermutationBS("TactCoa"));
    }

    @Test
    public void testBSIgnoresNonLetterCharacters() {
    	assertTrue(PalindromePermutation.isPermutationBS("tact coa."));
    }

    @Test
    public void testBSNullInput() {
    	assertFalse(PalindromePermutation.isPermutationBS(null));
    }

    @Test
    public void testBSEmptyInput() {
    	assertFalse(PalindromePermutation.isPermutationBS(""));
    	assertFalse(PalindromePermutation.isPermutationBS("   "));
    	assertFalse(PalindromePermutation.isPermutationBS("..."));
    	assertFalse(PalindromePermutation.isPermutationBS(",,,"));
    	assertFalse(PalindromePermutation.isPermutationBS(";;;"));
    	assertFalse(PalindromePermutation.isPermutationBS("@@@"));
    }
}
