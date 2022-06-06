package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DependencyAnalyzerTest {

    @Test
    public void test1() throws IOException, URISyntaxException {
        File input = new File(DependencyAnalyzerTest.class.getResource("/test-graph.json").toURI());
        List<String> result = DependencyAnalyzer.computeBuildOrder(input);

        assertEquals(6, result.size());
        assertTrue(result.indexOf("f") < result.indexOf("a"));
        assertTrue(result.indexOf("f") < result.indexOf("b"));
        assertTrue(result.indexOf("b") < result.indexOf("d"));
        assertTrue(result.indexOf("a") < result.indexOf("d"));
        assertTrue(result.indexOf("d") < result.indexOf("c"));
    }

    @Test
    public void test2() throws IOException, URISyntaxException {        
        try {
        	File input = new File(DependencyAnalyzerTest.class.getResource("/test-invalid-graph.json").toURI());
        	DependencyAnalyzer.computeBuildOrder(input);
        	fail("Should throw CircularDependencyException");
        } catch (IOException | InvalidJsonBuildException ex) {
        	fail("The wrong exception was thrown");
        } catch (CircularDependencyException ex) {
        	// want to end up here
        } 
    }

    @Test
    public void test3() throws IOException, URISyntaxException {
        File input = new File(DependencyAnalyzerTest.class.getResource("/test-larger-graph.json").toURI());
        List<String> result = DependencyAnalyzer.computeBuildOrder(input);
        assertEquals(7, result.size());
        assertTrue(result.indexOf("f") < result.indexOf("c"));
        assertTrue(result.indexOf("f") < result.indexOf("b"));
        assertTrue(result.indexOf("b") < result.indexOf("a"));
        assertTrue(result.indexOf("c") < result.indexOf("a"));
        assertTrue(result.indexOf("a") < result.indexOf("e"));
        assertTrue(result.indexOf("d") < result.indexOf("g"));
    }
}
