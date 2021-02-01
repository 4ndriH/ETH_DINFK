package ShortestPath;

import Graph.*;
import java.util.*;

public class BellmanFordATA {
    Graph g;

    public BellmanFordATA(Graph g) {
        this.g = g;

        int[][] d = BellmanFordATA();

        System.out.println("BellmanFord:");
        for (int[] a : d) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] BellmanFordATA() {
        int[][] distance = new int[g.V][];

        for (int i = 0; i < g.V; i++) {
            distance[i] = BellmanFord(i);
        }

        return distance;
    }

    private int[] BellmanFord(int start) {
        int[] distance = new int[g.V];

        for (int i = 0; i < g.V; i++) {
            distance[i] = 100000;
        }

        distance[start] = 0;

        for (int i = 0; i < g.V - 1; i++) {
            for (int u = 0; u < g.V; u++) {
                for (Edge e : g.adjL.get(u)) {
                    if (distance[e.u] + e.w < distance[e.v]) {
                        distance[e.v] = distance[e.u] + e.w;
                    }
                }
            }
        }

        for (int u = 0; u < g.V; u++) {
            for (Edge e : g.adjL.get(u)) {
                if (distance[e.u] + e.w < distance[e.v]) {
                    throw new IllegalStateException("NEGATIVE CYCLE!");
                }
            }
        }

        return distance;
    }
}