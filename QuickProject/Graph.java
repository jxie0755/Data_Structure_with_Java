import java.util.Arrays;
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


	// 找出哪个点是连了最多的其他的点
	public static int maxDegree(Graph G) {
		int max = 0;
		for (int v = 0; v < G.V(); v++) {
			int degree = degree(G, v);
			if (degree > max)
				max = degree;
		}
		return max;
	}

	// avgDegree = 总边数 / 总点数  (约算成整数)
	public static int avgDegree(Graph G) {
		return 2 * G.E() / G.V();
	}

	// 找出有多少个点是跟自己相连
	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.V(); v++)
			for (int w : G.adj(v))
				if (v == w)
					count++;
		return count / 2;
	}

	public static void main(String[] args) {

		Graph a = new Graph(5);
		a.addEdge(3, 4);
		System.out.println(Arrays.toString(a.adj));
		a.addEdge(2, 3);
		System.out.println(Arrays.toString(a.adj));
		a.addEdge(2, 4);
		System.out.println(Arrays.toString(a.adj));
		//  0   1      2      3        4
		// [[], [], [4, 3], [2, 4], [2, 3]]
		a.addEdge(1, 3);
		a.addEdge(2, 2);
		a.addEdge(3, 3);
		System.out.println(Arrays.toString(a.adj));
		System.out.println(Graph.avgDegree(a));
		System.out.println(Graph.numberOfSelfLoops(a));
	}
}
