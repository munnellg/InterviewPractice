package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;


public class ApartmentFinderTest {

  @Test
  public void findSingleBestApartment() throws IOException {
    JSONArray blocks = loadSampleData();
    List<String> requiredBuildings = List.of("gym", "school", "store");
    List<Integer> expected = List.of(3);

    assertIterableEquals(expected, ApartmentFinder.findBestApartment(blocks, requiredBuildings));
  }

  private JSONArray loadSampleData() throws IOException {
    InputStream stream = ApartmentFinderTest.class.getClassLoader().getResourceAsStream("./blocks.json");
    String jsonStr = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
    return new JSONArray(jsonStr);
  }
}
