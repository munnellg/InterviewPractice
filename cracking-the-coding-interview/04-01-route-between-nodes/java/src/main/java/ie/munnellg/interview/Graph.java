package ie.munnellg.interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;

import org.json.JSONArray;
import org.json.JSONObject;

public class Graph {

	private Map<String, Node> nodes;

	public Graph() {
		this.nodes = new HashMap<>();
	}

	public boolean routeExists(String label1, String label2) {
		Node src = nodes.get(label1);
		Node dst = nodes.get(label2);

		if (src == dst) { return true; }

		for (Node n : nodes.values()) {
			n.visited = false;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(src);

		while (!queue.isEmpty()) {
			Node next = queue.remove();
			next.visited = true;
			
			for (Node n : next.edges) {
				if (n == dst)   { return true; }
				if (!n.visited) { queue.add(n); }
			}
		}

		return false;
	}

	public static Graph parse(JSONObject json) throws InvalidJsonGraphException {
		Graph graph = new Graph();

		JSONArray nodes = json.getJSONArray("nodes");
		JSONArray edges = json.getJSONArray("edges");

		for (int i = 0; i < nodes.length(); i++) {
			String label = nodes.getString(i);
			graph.nodes.put(label, new Node(label));
		}

		for (int i = 0; i < edges.length(); i++) {
			JSONObject edge = edges.getJSONObject(i);
			
			if (!edge.has("from") || !edge.has("to")) {
				throw new InvalidJsonGraphException(String.format("Edge %d: Missing to/from statement", i));
			}

			String from = edge.getString("from");
			String to   = edge.getString("to");
			if (from == null || to == null || from.isEmpty() || to.isEmpty()) {
				throw new InvalidJsonGraphException(String.format("Edge %d: Blank to/from statement", i));	
			}

			Node src = graph.nodes.get(from);
			Node dst = graph.nodes.get(to);

			if (src == null) {
				throw new InvalidJsonGraphException(String.format("Edge %d: Unknown \"from\" graph node \"%s\"", i, from));		
			}

			if (dst == null) {
				throw new InvalidJsonGraphException(String.format("Edge %d: Unknown \"to\" graph node \"%s\"", i, to));		
			}

			src.edges.add(dst);
		}

		return graph;
	}

	public static Graph load(File file) throws IOException {
		return parse(loadFile(file));
	}

	private static JSONObject loadFile(File file) throws IOException {
		try (InputStream stream = new FileInputStream(file)) {
			return new JSONObject(new String(stream.readAllBytes(), StandardCharsets.UTF_8));
		}	
	}

	private static class Node {
		private String label;
		private Set<Node> edges;
		private boolean visited;

		private Node(String label) {
			this.label = label;
			this.edges = new HashSet<>();
		}
	}
}
