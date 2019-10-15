package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    private T[] vertexes;
    private boolean[][] matrix;
    private int n; //order
    private int alpha; //edges

    public Graph() {
        this(10);
    }

    public Graph(int capacity) {
        this.n = 0;
        this.alpha = 0;
        this.vertexes = (T[]) new Object[capacity];
        this.matrix = new boolean[capacity][capacity];
    }

    public void addVertex(T v) {
        if (n > vertexes.length) {
            throw new IndexOutOfBoundsException();
        }
        vertexes[n++] = v;
    }

//    public void deleteVertex(int v) {
//        for (int i = v; i < n - 1; i++) {
//            vertexs[i] = vertexs[i + 1];
//        }
//        vertexs[n--] = null;
//        //todo
//    }

    public void addEdge(int v, int w) {
        if (v > n || w > n || v < 0 || w < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!existsEdge(v, w)) {
            matrix[v][w] = matrix[w][v] = true;
            alpha++;
        }
    }

    public void deleteEdge(int v, int w) {
        if (v > n || w > n) {
            throw new IndexOutOfBoundsException();
        }
        if (existsEdge(v,w)) {
            matrix[v][w] = matrix[w][v] = false;
            alpha--;
        }
    }

    public boolean existsEdge(int v, int w) {
        if (v > n || w > n) {
            throw new IndexOutOfBoundsException();
        }
        return matrix[v][w];
    }

    public int order() {
        return n;
    }

    public int quantityOfEdges() {
        return alpha;
    }

    public T getVertex(int v) {
        if (v > n) {
            throw new IndexOutOfBoundsException();
        }
        return (T) matrix[v];
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public List<Integer> getAdj(int v) {
        if (v > n) {
            throw new IndexOutOfBoundsException();
        }
        List lst = new ArrayList();
        for (int w = 0; w < n ; w++)
            if (matrix[v][w])
                lst.add(w);
        return lst;
    }

}
