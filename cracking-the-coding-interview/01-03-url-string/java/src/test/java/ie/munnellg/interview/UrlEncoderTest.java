package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class UrlEncoderTest {

    @Test
    public void test() {
    	char[] input    = "Mr John Smith    ".toCharArray();
    	char[] expected = "Mr%20John%20Smith".toCharArray();

    	UrlEncoder.encode(input, 13);
    	
        assertArrayEquals(expected, input);
    }
}
