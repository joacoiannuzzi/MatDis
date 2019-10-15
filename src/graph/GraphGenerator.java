package graph;

import java.util.Random;

class GraphGenerator {

    Graph<Integer> create(int vertexs) {
        Random random = new Random();
        Graph<Integer> g = new Graph<>(vertexs);
        for (int i = 0; i < vertexs; i++) {
            g.addVertex(i);
        }
        for (int v = 0; v < g.order(); v++) {
            for (int w = v + 1; w < g.order(); w++) {
                if (random.nextBoolean()) {
                    g.addEdge(v, w);
                }
            }
        }
        return g;
    }
}
