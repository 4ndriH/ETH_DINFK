package ShortestPath;

import Graph.*;
import java.util.*;

public class BreadthFirstSearch {
    public Graph g;

    public BreadthFirstSearch(Graph g) {
        this.g = g;

        System.out.println("BreadthFirstSearch");
        System.out.println(Arrays.toString(BFS(0)));
    }

    public int[] BFS(int start) {
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