package es.upm.dit.adsw.ej2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Pruebas del algoritmo BFS.
 *
 * @version 11.2.2018
 */
public class BFSTest0 {

    // http://pages.cs.wisc.edu/~mcw/cs367/lectures/graph_traversals.html
    private Graph graph;
    private Node N0;
    private Node N1;
    private Node N2;
    private Node N3;
    private Node N4;
    private Node N5;

    @Before
    public void setup() {

        graph = new Graph();
        N0 = new Node("0", 0, 0);
        N1 = new Node("1", 0, 0);
        N2 = new Node("2", 0, 0);
        N3 = new Node("3", 0, 0);
        N4 = new Node("4", 0, 0);
        N5 = new Node("5", 0, 0);
        graph.addNode(N0);
        graph.addNode(N1);
        graph.addNode(N2);
        graph.addNode(N3);
        graph.addNode(N4);
        graph.addNode(N5);
        graph.addLink(new Link("0", "1", 5));
        graph.addLink(new Link("0", "5", 5));
        graph.addLink(new Link("1", "2", 5));
        graph.addLink(new Link("1", "3", 5));
        graph.addLink(new Link("1", "4", 5));
        graph.addLink(new Link("2", "0", 5));
        graph.addLink(new Link("3", "4", 5));
        graph.addLink(new Link("4", "2", 5));
    }

    @Test
    public void test1() {
        BFS bfs = new BFS(graph);

        List<Node> p01 = bfs.search(N0, N1);
        List<Node> expected01 = Arrays.asList(N0, N1);
        assertEquals(expected01, p01);
    }

    @Test
    public void test2() {
        BFS bfs = new BFS(graph);

        List<Node> p04 = bfs.search(N0, N4);
        List<Node> expected04 = Arrays.asList(N0, N1, N4);
        assertEquals(expected04, p04);
    }

    @Test
    public void test3() {
        BFS bfs = new BFS(graph);

        List<Node> p54 = bfs.search(N5, N4);
        List<Node> expected54 = Arrays.asList();
        assertEquals(expected54, p54);
    }

}
