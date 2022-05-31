package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringAnalyzerTest {

    @Test
    public void identifiesPermutation() {
        assertTrue(StringAnalyzer.isPermutation("Dog", "God"));
    }

    @Test
    public void identifiesNotPermutation() {
    	assertFalse(StringAnalyzer.isPermutation("Dog", "Cat"));
    }

    @Test
    public void handlesSpacesAndPunctuation() {
    	assertTrue(StringAnalyzer.isPermutation("Dog Cat.", "Catdog"));
    }

    @Test
    public void handlesUnicode() {    	
    	assertTrue(StringAnalyzer.isPermutation("乳牛", "牛乳"));
		assertFalse(StringAnalyzer.isPermutation("日本", "牛乳"));

		// these two strings have the same bytes, but different characters
		// naive sorting of char array will say that they are permutations, when it is clear they are not
		assertFalse(StringAnalyzer.isPermutation("獎", "乳"));
    }

    @Test
    public void handlesNullInput() {
		try {
			StringAnalyzer.isPermutation("Dog", null);
		} catch (NullPointerException ex) {
			assertEquals(StringAnalyzer.NULL_INPUT_EXCEPTION_MESSAGE, ex.getMessage());
		}

		try {
			StringAnalyzer.isPermutation(null, "Cat");
		} catch (NullPointerException ex) {
			assertEquals(StringAnalyzer.NULL_INPUT_EXCEPTION_MESSAGE, ex.getMessage());
		}

		try {
			StringAnalyzer.isPermutation(null, null);
		} catch (NullPointerException ex) {
			assertEquals(StringAnalyzer.NULL_INPUT_EXCEPTION_MESSAGE, ex.getMessage());
		}
    }
}
