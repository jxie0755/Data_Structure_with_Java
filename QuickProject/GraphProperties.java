public class GraphProperties {

	// public Graph G;
	public GraphProperties(Graph graph) {

	}

	/**
	 * The grith of a graph is the length of its shortest cycle. If a graph is
	 * acyclic, then its girth is infinite (return -1).
	 * <p>
	 * Hint : Run BFS from each vertex. The shortest cycle containing s is a
	 * shortest path from s to some vertex v, plus the edge from v back to s.
	 */
	public int grith() {
		//replace the throw statement with your implementation
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		Graph a = new Graph(5);
		GraphProperties x = new GraphProperties(a);

	}


}
