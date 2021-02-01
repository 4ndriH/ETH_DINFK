package ShortestPath;

import Graph.*;
import java.util.*;

public class FloydWarshall {
    Graph g;

    public FloydWarshall(Graph g) {
        this.g = g;

        int[][] d = FloydWarshall();

        System.out.println("FloydWarshall:");
        for (int[] a : d) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] FloydWarshall() {
        int[][] distance = new int[g.V][g.V];

        for (int i = 0; i < g.V; i++) {
            for (int j = 0; j < g.V; j++) {
                distance[i][j] = i != j ? 100000 : 0;
            }
        }

        for (int i = 0; i < g.V; i++) {
            for (Edge e : g.adjL.get(i)) {
                distance[e.u][e.v] = e.w;
            }
        }

        for (int i = 0; i < g.V; i++) {
            for (int u = 0; u < g.V; u++) {
                for (int v = 0; v < g.V; v++) {
                    distance[u][v] = Math.min(distance[u][v], distance[u][i] + distance[i][v]);
                }
            }
        }

        return distance;
    }
}