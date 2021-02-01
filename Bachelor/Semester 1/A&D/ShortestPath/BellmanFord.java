package ShortestPath;

import Graph.*;
import java.util.*;

public class BellmanFord {
    Graph g;

    public BellmanFord(Graph g) {
        this.g = g;

        System.out.println("BellmanFord:");
        System.out.println(Arrays.toString(BellmanFord(0)));
    }

    public int[] BellmanFord(int start) {
        int[] distance = new int[g.V];

        for (int i = 0; i < g.V; i++) {
            distance[i] = 100000;
        }

        distance[start] = 0;

        for (int i = 1; i < g.V - 1; i++) {
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