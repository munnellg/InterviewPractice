package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringAnalyzerTest {

    @Test
    public void test() {
        assertTrue(StringAnalyzer.isRotation("waterbottle", "erbottlewat"));
    }
}
