package ie.munnellg.interview;

// can there be more than one suitable apartment? Assuming yes

// define
// + n - size of input blocks
// + r - size of input requiredBuildings
// + b - number of buildings

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApartmentFinder {

  // This solution works entirely with primitives and simple datastructures
  // This being Java, under normal circumstances I would take a more OOP approach,
  // but for an interview I assume this kind of minimalist solution is what interviewers want

  // Overall: O(b x n) space; O(b x n) time
  public static List<Integer> findBestApartment(JSONArray blocks, List<String> requiredBuildings) {

    // O(b x n) space; O(b x n) time
    Map<String, List<Integer>> buildingLocations = buildLookup(blocks);

    Integer bestScore  = evaluateApartment(0, requiredBuildings, buildingLocations);

    List<Integer> scores = new ArrayList<Integer>();
    scores.add(bestScore);

    // O(n) time; O(1) space
    for (int i = 1; i < blocks.length(); i++) {
      // O(r) time; O(1) space
      Integer score = evaluateApartment(i, requiredBuildings, buildingLocations);

      // keep track of the best distance found
      if (score < bestScore) {
        bestScore = score;
      }

      scores.add(score);
    }

    // O(n) time; O(n) space
    return fetchBestLocations(scores, bestScore);
  }

  // O(n) time; O(n) space
  private static List<Integer> fetchBestLocations(List<Integer> scores, Integer bestScore) {

    List<Integer> result = new ArrayList<Integer>();

    for (int i = 0; i < scores.size(); i++) {
      if (scores.get(i) <= bestScore) {
        result.add(i);
      }
    }

    return result;
  }

  // O(r) time; O(1) space
  private static Integer evaluateApartment(
      Integer aptLocation, List<String> requiredBuildings, Map<String, List<Integer>> buildingLocations) {

    Integer score = 0;

    for (String required : requiredBuildings) {
      score = Math.max(score, findDistanceToClosest(aptLocation, buildingLocations.get(required)));
    }

    return score;
  }

  // O(log n) time; O(1) space
  private static Integer findDistanceToClosest(Integer needle, List<Integer> haystack) {
    if (haystack == null) {
      // TODO: Add proper exception message here
      throw new NullPointerException("Required building is not in lookup");
    }

    if (haystack.size() <= 0) {
      // TODO: Throw exception for this case too
      return null;
    }

    // binary search O(log n)
    int min = 0, max = haystack.size();
    int curr = haystack.size() / 2;
    int prev;

    do {
      int value = haystack.get(curr);
      prev = curr;

      if (value < needle) {
        min = curr;
      } else if (value > needle) {
        max = curr + 1;
      }

      curr = (min + max) / 2;
    } while (curr != prev);

    // binary search hasn't necessarily finished exactly on the closest value
    // check left and right for better option before returning
    Integer found = haystack.get(curr);
    Integer left  = (curr > 0)? haystack.get(curr - 1) : haystack.get(curr);
    Integer right = (curr < haystack.size() - 1)? haystack.get(curr + 1) : haystack.get(curr);

    return Math.min(Math.min(Math.abs(needle - found), Math.abs(needle - left)), Math.abs(needle - right));
  }

  // O(b x n) space; O(b x n) time
  private static Map<String, List<Integer>> buildLookup(JSONArray blocks) {
    // O(b x n) space
    Map<String, List<Integer>> buildingLocations = new HashMap<String, List<Integer>>();

    // insertion into map O(1), iterations over list O(b x n)
    for (int i = 0; i < blocks.length(); i++) {
      JSONObject block = blocks.getJSONObject(i);

      // iterate over all buildings for this block
      for (String building : block.keySet()) {

        // check if the building is present on this block
        if (block.getBoolean(building)) {
          // building is present, add this location to the lookup for this building
          List<Integer> locations = buildingLocations.get(building);
          
          // handle case where building isn't in the lookup yet
          if (locations == null) {
            locations = new ArrayList<Integer>();
            buildingLocations.put(building, locations);
          }

          locations.add(i);
        }
      }
    }

    return buildingLocations;
  }
}