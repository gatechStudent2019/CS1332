import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptySet;

/**
 * @author sergeys
 */
public class SS1332HW10Tests {
    public static final long TIMEOUT = 200L;

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBFSException1() {
        GraphAlgorithms.breadthFirstSearch(null, new Graph<>(emptySet(),
                emptySet()));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBFSException2() {
        GraphAlgorithms.breadthFirstSearch(new Vertex<>(0), null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBFSException3() {
        GraphAlgorithms.breadthFirstSearch(new Vertex<>(0),
                new Graph<>(new HashSet<>(
                        Collections.singletonList(new Vertex<>(1))),
                        emptySet()));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDFSException1() {
        GraphAlgorithms.depthFirstSearch(null, new Graph<>(emptySet(),
                emptySet()));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDFSException2() {
        GraphAlgorithms.depthFirstSearch(new Vertex<>(0), null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDFSException3() {
        GraphAlgorithms.depthFirstSearch(new Vertex<>(0),
                new Graph<>(new HashSet<>(
                        Collections.singletonList(new Vertex<>(1))),
                        emptySet()));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDijkstraException1() {
        GraphAlgorithms.dijkstras(null, new Graph<>(emptySet(),
                emptySet()));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDijkstraException2() {
        GraphAlgorithms.dijkstras(new Vertex<>(0), null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDijkstraException3() {
        GraphAlgorithms.dijkstras(new Vertex<>(0),
                new Graph<>(new HashSet<>(
                        Collections.singletonList(new Vertex<>(1))),
                        emptySet()));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPrimException1() {
        GraphAlgorithms.prims(null, new Graph<>(emptySet(),
                emptySet()));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPrimException2() {
        GraphAlgorithms.prims(new Vertex<>(0), null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPrimException3() {
        GraphAlgorithms.prims(new Vertex<>(0),
                new Graph<>(new HashSet<>(
                        Collections.singletonList(new Vertex<>(1))),
                        emptySet()));
    }

    private void edge(Set<Edge<Integer>> edges, int v1, int v2, int w) {
        edges.add(new Edge<>(new Vertex<>(v1), new Vertex<>(v2), w));
    }

    private void biedge(Set<Edge<Integer>> edges, int v1, int v2, int w) {
        edge(edges, v1, v2, w);
        edge(edges, v2, v1, w);
    }

    /*
    0 - 1       6
    |   |       |
    2 - 3 - 4 - 5
        |
        7
        |
    10- 8 - 9
     */
    private Graph<Integer> getGraph1() {
        Set<Vertex<Integer>> vertices = new LinkedHashSet<>();
        Set<Edge<Integer>> edges = new LinkedHashSet<>();

        for (int i = 0; i <= 10; i++) {
            vertices.add(new Vertex<>(i));
        }

        biedge(edges, 0, 1, 0);
        biedge(edges, 0, 2, 0);
        biedge(edges, 3, 1, 1);
        biedge(edges, 3, 2, 0);
        biedge(edges, 3, 4, 3);
        biedge(edges, 3, 7, 1);
        biedge(edges, 5, 4, 5);
        biedge(edges, 5, 6, 1);
        biedge(edges, 8, 7, 1);
        biedge(edges, 8, 9, 4);
        biedge(edges, 8, 10, 3);

        return new Graph<>(vertices, edges);
    }

    /*
    0 - 1   5
    |       |
    2   3 - 4
     */
    private Graph<Integer> getGraph2() {
        Set<Vertex<Integer>> vertices = new LinkedHashSet<>();
        Set<Edge<Integer>> edges = new LinkedHashSet<>();

        for (int i = 0; i <= 5; i++) {
            vertices.add(new Vertex<>(i));
        }

        biedge(edges, 0, 1, 1);
        biedge(edges, 0, 2, 2);
        biedge(edges, 4, 3, 2);
        biedge(edges, 4, 5, 1);

        return new Graph<>(vertices, edges);
    }

    /*
    0  -> 1 <-  5
    ^           ^
    |     |     |
          V
    2 <-  3  -> 4
     */
    private Graph<Integer> getGraph3() {
        Set<Vertex<Integer>> vertices = new LinkedHashSet<>();
        Set<Edge<Integer>> edges = new LinkedHashSet<>();

        for (int i = 0; i <= 5; i++) {
            vertices.add(new Vertex<>(i));
        }

        edge(edges, 0, 1, 5);
        edge(edges, 5, 1, 1);
        edge(edges, 1, 3, 0);
        edge(edges, 3, 2, 1);
        edge(edges, 3, 4, 3);
        edge(edges, 2, 0, 2);
        edge(edges, 4, 5, 1);

        return new Graph<>(vertices, edges);
    }

    @Test(timeout = TIMEOUT)
    public void testBFS1() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                3, 1, 2, 4, 7, 0, 5, 8, 6, 9, 10
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph1();

        Assert.assertEquals(expected, GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(3), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testBFS2_1() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                1, 0, 2
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph2();

        Assert.assertEquals(expected, GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(1), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testBFS2_2() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                3, 4, 5
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph2();

        Assert.assertEquals(expected, GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(3), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testBFS3_1() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                3, 2, 4, 0, 5, 1
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph3();

        Assert.assertEquals(expected, GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(3), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testBFS3_2() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                2, 0, 1, 3, 4, 5
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph3();

        Assert.assertEquals(expected, GraphAlgorithms.breadthFirstSearch(
                new Vertex<>(2), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDFS1() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                3, 1, 0, 2, 4, 5, 6, 7, 8, 9, 10
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph1();

        Assert.assertEquals(expected, GraphAlgorithms.depthFirstSearch(
                new Vertex<>(3), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDFS2_1() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                1, 0, 2
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph2();

        Assert.assertEquals(expected, GraphAlgorithms.depthFirstSearch(
                new Vertex<>(1), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDFS2_2() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                3, 4, 5
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph2();

        Assert.assertEquals(expected, GraphAlgorithms.depthFirstSearch(
                new Vertex<>(3), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDFS3_1() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                3, 2, 0, 1, 4, 5
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph3();

        Assert.assertEquals(expected, GraphAlgorithms.depthFirstSearch(
                new Vertex<>(3), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDFS3_2() {
        List<Vertex<Integer>> expected = Arrays.stream(new int[]{
                5, 1, 3, 2, 0, 4
        }).boxed().map(Vertex::new).collect(Collectors.toList());
        Graph<Integer> graph = getGraph3();

        Assert.assertEquals(expected, GraphAlgorithms.depthFirstSearch(
                new Vertex<>(5), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstra1() {
        HashMap<Vertex<Integer>, Integer> expected = new HashMap<>();
        expected.put(new Vertex<>(3), 0);
        expected.put(new Vertex<>(2), 0);
        expected.put(new Vertex<>(0), 0);
        expected.put(new Vertex<>(1), 0);
        expected.put(new Vertex<>(7), 1);
        expected.put(new Vertex<>(8), 2);
        expected.put(new Vertex<>(4), 3);
        expected.put(new Vertex<>(10), 5);
        expected.put(new Vertex<>(9), 6);
        expected.put(new Vertex<>(5), 8);
        expected.put(new Vertex<>(6), 9);

        Graph<Integer> graph = getGraph1();

        Assert.assertEquals(expected, GraphAlgorithms.dijkstras(
                new Vertex<>(3), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstra2_1() {
        HashMap<Vertex<Integer>, Integer> expected = new HashMap<>();
        expected.put(new Vertex<>(0), 0);
        expected.put(new Vertex<>(1), 1);
        expected.put(new Vertex<>(2), 2);
        expected.put(new Vertex<>(3), Integer.MAX_VALUE);
        expected.put(new Vertex<>(4), Integer.MAX_VALUE);
        expected.put(new Vertex<>(5), Integer.MAX_VALUE);

        Graph<Integer> graph = getGraph2();

        Assert.assertEquals(expected, GraphAlgorithms.dijkstras(
                new Vertex<>(0), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstra2_2() {
        HashMap<Vertex<Integer>, Integer> expected = new HashMap<>();
        expected.put(new Vertex<>(0), Integer.MAX_VALUE);
        expected.put(new Vertex<>(1), Integer.MAX_VALUE);
        expected.put(new Vertex<>(2), Integer.MAX_VALUE);
        expected.put(new Vertex<>(3), 2);
        expected.put(new Vertex<>(4), 0);
        expected.put(new Vertex<>(5), 1);

        Graph<Integer> graph = getGraph2();

        Assert.assertEquals(expected, GraphAlgorithms.dijkstras(
                new Vertex<>(4), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstra3() {
        HashMap<Vertex<Integer>, Integer> expected = new HashMap<>();
        expected.put(new Vertex<>(3), 0);
        expected.put(new Vertex<>(2), 1);
        expected.put(new Vertex<>(0), 3);
        expected.put(new Vertex<>(4), 3);
        expected.put(new Vertex<>(5), 4);
        expected.put(new Vertex<>(1), 5);

        Graph<Integer> graph = getGraph3();

        Assert.assertEquals(expected, GraphAlgorithms.dijkstras(
                new Vertex<>(3), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstra4() {
        HashMap<Vertex<Integer>, Integer> expected = new HashMap<>();
        expected.put(new Vertex<>(0), 0);
        expected.put(new Vertex<>(1), 1);
        expected.put(new Vertex<>(2), 2);
        expected.put(new Vertex<>(3), 3);
        expected.put(new Vertex<>(4), 4);
        expected.put(new Vertex<>(5), 5);
        expected.put(new Vertex<>(6), 6);
        expected.put(new Vertex<>(7), 6);
        expected.put(new Vertex<>(8), 6);
        expected.put(new Vertex<>(9), 6);
        expected.put(new Vertex<>(10), 6);
        expected.put(new Vertex<>(11), 5);
        expected.put(new Vertex<>(12), 4);
        expected.put(new Vertex<>(13), 3);
        expected.put(new Vertex<>(14), 2);
        expected.put(new Vertex<>(15), 1);
        expected.put(new Vertex<>(16), 3);
        expected.put(new Vertex<>(17), Integer.MAX_VALUE);

        Set<Vertex<Integer>> vertices = new LinkedHashSet<>();
        Set<Edge<Integer>> edges = new LinkedHashSet<>();

        //Imagine this as a circle of 16 nodes with one in the center
        //the weights between the ones in the circle are 1 and the one in the
        //center connects to the rest with weight 5
        for (int i = 0; i <= 16; i++) {
            vertices.add(new Vertex<>(i));
            if (i != 16) {
                biedge(edges, 16, i, 3);
                biedge(edges, i, (i + 1) % 16, 1);
            }
        }
        vertices.add(new Vertex<>(17));

        Graph<Integer> graph = new Graph<>(vertices, edges);

        Assert.assertEquals(expected, GraphAlgorithms.dijkstras(
                new Vertex<>(0), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testPrim1() {
        Set<Edge<Integer>> expected = new HashSet<>();
        biedge(expected, 3, 2, 0);
        biedge(expected, 2, 0, 0);
        biedge(expected, 0, 1, 0);
        biedge(expected, 3, 7, 1);
        biedge(expected, 7, 8, 1);
        biedge(expected, 8, 9, 4);
        biedge(expected, 8, 10, 3);
        biedge(expected, 3, 4, 3);
        biedge(expected, 5, 4, 5);
        biedge(expected, 5, 6, 1);
        biedge(expected, 8, 7, 1);

        Graph<Integer> graph = getGraph1();
        Assert.assertEquals(expected, GraphAlgorithms.prims(
                new Vertex<>(3), graph));
    }

    @Test(timeout = TIMEOUT)
    public void testPrim2() {
        Graph<Integer> graph = getGraph2();
        Assert.assertNull(GraphAlgorithms.prims(
                new Vertex<>(0), graph));
    }
}