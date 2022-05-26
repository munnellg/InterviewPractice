package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringAnalyzerTest {

    private static final String UNIQUE_STRING     = "humble";
    private static final String NON_UNIQUE_STRING = "disestablishmentarianism";

    @Test
    public void detectsUniqueCharacters() {
        assertTrue(StringAnalyzer.hasUniqueChars(UNIQUE_STRING));
    }

    @Test
    public void detectsNonUniqueCharacters() {
        assertFalse(StringAnalyzer.hasUniqueChars(NON_UNIQUE_STRING));
    }

    @Test
    public void handlesNullInput() {
        try {
            StringAnalyzer.hasUniqueChars(null);
        } catch (NullPointerException ex) {
            assertEquals(StringAnalyzer.NULL_STRING_EXCEPTION_MESSAGE, ex.getMessage());
        }
    }

    @Test
    public void detectsUniqueCharactersList() {
        assertTrue(StringAnalyzer.hasUniqueCharsList(UNIQUE_STRING));
    }

    @Test
    public void detectsNonUniqueCharactersList() {
        assertFalse(StringAnalyzer.hasUniqueCharsList(NON_UNIQUE_STRING));
    }

    @Test
    public void handlesNullInputList() {
        try {
            StringAnalyzer.hasUniqueCharsList(null);
        } catch (NullPointerException ex) {
            assertEquals(StringAnalyzer.NULL_STRING_EXCEPTION_MESSAGE, ex.getMessage());
        }
    }

    @Test
    public void detectsUniqueCharactersBitVector() {
        assertTrue(StringAnalyzer.hasUniqueCharsBV(UNIQUE_STRING));
    }

    @Test
    public void detectsNonUniqueCharactersBitVector() {
        assertFalse(StringAnalyzer.hasUniqueCharsBV(NON_UNIQUE_STRING));
    }

    @Test
    public void handlesNullInputBitVector() {
        try {
            StringAnalyzer.hasUniqueCharsBV(null);
        } catch (NullPointerException ex) {
            assertEquals(StringAnalyzer.NULL_STRING_EXCEPTION_MESSAGE, ex.getMessage());
        }
    }
}
