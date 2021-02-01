package ShortestPath;

import Graph.*;
import java.util.*;

public class BreadthFirstSearchATA {
    Graph g;

    public BreadthFirstSearchATA(Graph g) {
        this.g = g;

        int[][] d = BreadthFirstSearchATA();

        System.out.println("BreadthFirstSearchATA");
        for (int[] a : d) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] BreadthFirstSearchATA() {
        int[][] distance = new int[g.V][];

        for (int i = 0; i < g.V; i++) {
            distance[i] = BFS(i);
        }

        return distance;
    }

    private int[] BFS(int start) {
        int[] distance = new int[g.V];
        boolean[] active = new boolean[g.V];
        boolean[] visited = new boolean[g.V];
        LinkedList<Integer> Q = new LinkedList<>();

        Q.addLast(start);

        while (!Q.isEmpty()) {
            int u = Q.pollFirst();
            visited[u] = true;
            for (Edge e : g.adjL.get(u)) {
                if (!visited[e.v] && !active[e.v]) {
                    Q.addLast(e.v);
                    active[e.v] = true;
                    distance[e.v] = distance[u] + 1;
                }
            }

        }

        return distance;
    }
}