package TopologicalSorting;

import Graph.*;
import java.util.*;

public class DepthFirstSearch {
    boolean[] visited;
    int[] pre, post;
    int cnt = 1;
    Graph g;

    public DepthFirstSearch(Graph g) {
        this.g = g;
        visited = new boolean[g.V];
        pre = new int[g.V];
        post = new int[g.V];

        DFS(0);

        System.out.println("Pre:    " + Arrays.toString(pre));
        System.out.println("Post:   " + Arrays.toString(post));
    }

    public void DFS (int u) {
        visited[u] = true;
        pre[u] = cnt++;

        if (g.adjL.get(u) != null) {
            for (Edge e : g.adjL.get(u)) {
                if (!visited[e.v]) {
                    DFS(e.v);
                }
            }
        }

        post[u] = cnt++;
    }
}