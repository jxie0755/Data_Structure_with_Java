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

	@Test
	void testGrith_4() {
		Graph graph = new Graph(16);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);

		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(8, 4);

		graph.addEdge(9, 10);
		graph.addEdge(10, 11);
		graph.addEdge(11, 12);
		graph.addEdge(12, 13);
		graph.addEdge(13, 14);
		graph.addEdge(14, 15);
		graph.addEdge(15, 16);
		graph.addEdge(16, 9);
		GraphProperties gp = new GraphProperties(graph);
		assertEquals(4, gp.grith());
	}

	@Test
	void testGrith_5 () {
		Graph graph = new Graph(16);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);

		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(8, 4);

		graph.addEdge(4, 0);
		graph.addEdge(2, 6);

		GraphProperties gp = new GraphProperties(graph);
		assertEquals(4, gp.grith());
	}

	@Test
	void testGrith_6() {
		Graph graph = new Graph(16);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);

		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(8, 4);

		graph.addEdge(4, 0);
		graph.addEdge(8, 0);
		graph.addEdge(2, 6);

		GraphProperties gp = new GraphProperties(graph);
		assertEquals(3, gp.grith());
	}
}
