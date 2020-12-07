import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GraphPropertiesTest {

	@Test
	void testGrith_1() {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(4, 3);

		GraphProperties gp = new GraphProperties(graph);
		assertEquals(-1, gp.grith());
	}

	@Test
	void testGrith_2() {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 3);

		GraphProperties gp = new GraphProperties(graph);
		assertEquals(3, gp.grith());
	}

	@Test
	void testGrith_3() {
		Graph graph = new Graph(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);

		GraphProperties gp = new GraphProperties(graph);
		assertEquals(3, gp.grith());
	}

}
