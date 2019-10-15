package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphAppTest {

    GraphApp graphApp = new GraphApp();
    GraphGenerator gen = new GraphGenerator();

    @Test
    public void printGraphMatrix() {
        Graph<Integer> g = gen.create(5);
        graphApp.printGraphMatrix(g);
    }

//    @Test
//    public void existsCycle() {
//        Graph<Integer> g = new Graph<>(4);
//        for (int i = 0; i < 4; i++) {
//            g.addVertex(i);
//        }
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1,2);
//        graphApp.printGraphMatrix(g);
//
//        assertTrue(graphApp.existsCycle(g, 0));
//    }

    @Test
    public void warshallTest() {
        Graph<Integer> g = new Graph<>(4);
        for (int i = 0; i < g.order(); i++) {
            g.addVertex(i);
        }
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
    }


    @Test
    public void dfsTest() {
        Graph<Integer> g = gen.create(6);
        graphApp.printGraphMatrix(g);
        System.out.println();
        graphApp.dfs(g, 0);
    }


}