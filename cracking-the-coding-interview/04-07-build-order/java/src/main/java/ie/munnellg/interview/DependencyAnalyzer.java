package ie.munnellg.interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

public class DependencyAnalyzer {

	public static List<String> computeBuildOrder(File file) throws InvalidJsonBuildException, IOException {
		Build g = load(file);
		return g.buildOrder();
	}

	private static Build parse(JSONObject json) throws InvalidJsonBuildException, IOException {
		Build build = new Build();

		JSONArray buildObjects = json.getJSONArray("buildObjects");
		JSONArray dependencies = json.getJSONArray("dependencies");

		Map<String, BuildObject> lookup = new HashMap<>();

		for (int i = 0; i < buildObjects.length(); i++) {
			String label = buildObjects.getString(i);
			BuildObject buildObject = new BuildObject(label);
			lookup.put(buildObject.label, buildObject);
			build.buildObjects.add(buildObject);
		}

		for (int i = 0; i < dependencies.length(); i++) {
			JSONObject dependency = dependencies.getJSONObject(i);
			
			if (!dependency.has("from") || !dependency.has("to")) {
				throw new InvalidJsonBuildException(String.format("Edge %d: Missing to/from statement", i));
			}

			String from = dependency.getString("from");
			String to   = dependency.getString("to");
			if (from == null || to == null || from.isEmpty() || to.isEmpty()) {
				throw new InvalidJsonBuildException(String.format("Edge %d: Blank to/from statement", i));	
			}

			BuildObject src = lookup.get(from);
			BuildObject dst = lookup.get(to);

			if (src == null) {
				throw new InvalidJsonBuildException(String.format("Edge %d: Unknown dependency \"%s\"", i, from));		
			}

			if (dst == null) {
				throw new InvalidJsonBuildException(String.format("Edge %d: Unknown build object \"%s\"", i, to));		
			}

			src.dependencies.add(dst);
		}

		return build;
	}

	private static Build load(File file) throws IOException {
		return parse(loadFile(file));
	}

	private static JSONObject loadFile(File file) throws IOException {
		try (InputStream stream = new FileInputStream(file)) {
			return new JSONObject(new String(stream.readAllBytes(), StandardCharsets.UTF_8));
		}	
	}

	private static enum State {
		PENDING,
		COMPILING,
		COMPILED
	};

	private static class Build {
		private List<BuildObject> buildObjects;

		private Build() {
			this.buildObjects = new ArrayList<>();
		}

		private List<String> buildOrder() {
			List<String> order = new ArrayList<String>();

			BuildObject seed = nextPending();
			
			while (seed != null) {
				build(seed, order);
				seed = nextPending();
			}
			
			return order;
		}

		private BuildObject nextPending() {
			for (BuildObject obj : this.buildObjects) {
				if (obj.state == State.PENDING) {
					return obj;
				}
			}
			
			return null;
		}

		private void build(BuildObject seed, List<String> buildOrder) {
			if (seed == null) { return; }
			if (seed.state == State.COMPILED)  { return; }
			if (seed.state == State.COMPILING) { throw new CircularDependencyException(); }

			seed.state = State.COMPILING;
			
			for (BuildObject object : seed.dependencies) {
				build(object, buildOrder);
			}

			seed.state = State.COMPILED;
			buildOrder.add(seed.label);
		}
	}

	private static class BuildObject {
		private String label;
		private Set<BuildObject> dependencies;
		private State state;

		private BuildObject(String label) {
			this.label        = label;
			this.dependencies = new HashSet<>();
			this.state        = State.PENDING;
		}
	}
}
