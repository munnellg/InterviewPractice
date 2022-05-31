package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class StringCompressorTest {

    @Test
    public void testReturnCompressInput() {
        assertEquals("a2b1c5a3", StringCompressor.compress("aabcccccaaa"));
    }

    @Test
    public void testReturnOriginalInput() {
    	assertEquals("do not compress", StringCompressor.compress("do not compress"));
    }

    @Test
    public void testNullInput() {
    	try {
    		StringCompressor.compress(null);
    		fail("Expected exception was not thrown");
    	} catch (NullPointerException ex) {
    		assertEquals(StringCompressor.NULL_INPUT_EXCEPTION_MSG, ex.getMessage());
    	}
    }

    @Test
    public void testEmptyInput() {
    	assertEquals("", StringCompressor.compress(""));
    }
}
