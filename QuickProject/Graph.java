import java.util.LinkedList;
import java.util.List;

/**
 * This Graph implementation maintains a vertex-indexed array of lists of
 * integers. Every edge appears twice: if an edge connects v and w, then w
 * appears in v's list and v appears in w's list.
 */
public class Graph {
	private int V = 0; // number of vertices
	private int E; // number of edges
	private List<Integer>[] adj; // adjacency lists

	// create a V-vertex graph with no edges
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = new LinkedList[V]; // Create array of lists.
		// Initialize all lists to empty
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}

	// return number of vertices
	public int V() {
		return V;
	}

	// return number of edges
	public int E() {
		return E;
	}

	// add edge v-w to this graph
	public void addEdge(int v, int w) {
		adj[v].add(0, w);
		adj[w].add(0, v);
		E++;
	}

	// vertices adjacent to v
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public static int degree(Graph G, int v) {
		return G.adj[v].size();
	}

	public static int maxDegree(Graph G) {
		int max = 0;
		for (int v = 0; v < G.V(); v++) {
			int degree = degree(G, v);
			if (degree > max)
				max = degree;
		}
		return max;
	}

	public static int avgDegree(Graph G) {
		return 2 * G.E() / G.V();
	}

	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.V(); v++)
			for (int w : G.adj(v))
				if (v == w)
					count++;
		return count / 2;
	}

}
