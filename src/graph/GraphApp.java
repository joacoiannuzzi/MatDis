package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphApp {

    private <T> boolean existsPath(Graph<T> g, int v, int w, boolean[] visited) {
        if (v == w || g.existsEdge(v, w))
            return true;
        visited[v] = true;
        List<Integer> lst = g.getAdj(v);
        if (lst.isEmpty())
            return false;
        for (Integer integer : lst) {
            if (!visited[integer] && existsPath(g, integer, w, visited))
                return true;
        }
        return false;
    }

    public <T> boolean existsPath(Graph<T> g, int v, int w) {
        boolean[] visited = new boolean[g.order()];
        return existsPath(g, v, w, visited);
    }

    <T> void printGraphMatrix(Graph<T> g) {
        boolean[][] matrix = g.getMatrix();
        System.out.print("    ");
        for (int i = 0; i < g.order(); i++) {
            System.out.print(i + "  ");
        }
        System.out.println("\n");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) System.out.print(1 + "  ");
                else System.out.print(0 + "  ");
            }
            System.out.println();
        }
    }

    <T> boolean existsCycle(Graph<T> g, int v) {
        boolean[][] visited = new boolean[g.order()][g.order()];
        return existsCycle(g, v, visited);
        // todo anda mal
    }

    private <T> boolean existsCycle(Graph<T> g, int v, boolean[][] visited) {
        List<Integer> lst = g.getAdj(v);
        if (lst.size() <= 1)
            return false;
        for (Integer integer : lst) {
            if (existsPath(g, v, integer, visited))
                return true;
        }
        return false;
    }

    private <T> boolean existsPath(Graph<T> g, int v, int w, boolean[][] visited) {
        visited[v][w] = visited[w][v] = true;
        if (!visited[v][w] && g.existsEdge(v, w))
            return true;
        List<Integer> lst = g.getAdj(w);
        for (Integer integer : lst) {
            if (!visited[integer][w] && existsPath(g, v, integer, visited))
                return true;
        }
        return false;
    }

    public <T> void dfs(Graph<T> g, int v) {
        int t;
        boolean[] visited = new boolean[g.order()];
        Stack<Integer> p = new Stack<>();
        List<Integer> lst;
        p.push(v);
        visited[v] = true;
        while (!p.isEmpty()) {
            t = p.peek();
            p.pop();
            process(t);
            lst = g.getAdj(t);
            for (Integer integer : lst) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    p.push(integer);
                }
            }

        }
    }

    public <T> void bfs(Graph<T> g, int v) {
        int fr;
        boolean[] visited = new boolean[g.order()];
        Queue<Integer> c = new LinkedList<>();
        List<Integer> lst;
        c.add(v);
        visited[v] = true;
        while (!c.isEmpty()) {
            fr = c.peek();
            c.remove();
            process(fr);
            lst = g.getAdj(fr);
            for (Integer integer : lst) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    c.add(integer);
                }
            }
        }
    }

    private void process(int t) {
        System.out.println(t);
    }

    <T> boolean[][] warshall(Graph<T> g) {
        int n = g.order();
        boolean[][] t = g.getMatrix();
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (t[i][k] && t[k][j])
                        t[i][k] = true;
        return t;
    }


}
