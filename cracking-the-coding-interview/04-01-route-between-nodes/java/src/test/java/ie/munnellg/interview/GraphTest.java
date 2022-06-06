package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

public class GraphTest {

    @Test
    public void test() throws IOException, URISyntaxException {
        Graph graph = Graph.load(new File(GraphTest.class.getResource("/test-graph.json").toURI()));

        assertTrue(graph.routeExists("A", "B"));
        assertFalse(graph.routeExists("F", "A"));
    }
}
