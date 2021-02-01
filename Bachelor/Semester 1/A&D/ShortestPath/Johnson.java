package ShortestPath;

import Graph.*;
import java.util.*;

public class Johnson {
    Graph g;

    public Johnson(Graph g) {
        this.g = g;

        int[][] d = Johson();

        System.out.println("Johnson:");
        for (int[] a : d) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] Johson() {
        int[][] distance = new int[g.V][];

        g.adjL.add(new ArrayList<>());
        for (int i = 0; i < g.V; i++) {
            g.adjL.get(g.V).add(new Edge(g.V, i, 0));
        }

        int[] BFshortest = BellmanFord(g.V);

        for (int u = 0; u < g.V; u++) {
            for (Edge e : g.adjL.get(u)) {
                e.w = e.w + BFshortest[e.u] - BFshortest[e.v];
            }
        }

        for (int i = 0; i < g.V; i++) {
            distance[i] = Dijkstra(i, BFshortest);
        }

        return distance;
    }

    private int[] BellmanFord(int start) {
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

    private int[] Dijkstra(int start, int[] BFshortest) {
        int[] distanceInternal = new int[g.V];
        int[] distance = new int[g.V];
        Vertex[] PQelems = new Vertex[g.V];
        PriorityQueue<Vertex> PrioQ = new PriorityQueue<>();

        for (int i = 0; i < g.V; i++) {
            distanceInternal[i] = Integer.MAX_VALUE;
        }

        distanceInternal[start] = 0;
        PQelems[start] = new Vertex(start, 0);
        PrioQ.add(PQelems[start]);

        while (!PrioQ.isEmpty()) {
            Vertex vert = PrioQ.poll();
            int u = vert.idx;
            for (Edge e : g.adjL.get(u)) {
                if (distanceInternal[e.v] == Integer.MAX_VALUE) {
                    distanceInternal[e.v] = distanceInternal[u] + e.w;
                    distance[e.v] = distance[e.u] + e.w - BFshortest[e.u] + BFshortest[e.v];
                    PQelems[e.v] = new Vertex(e.v, distanceInternal[e.v]);
                    PrioQ.add(PQelems[e.v]);
                } else if (distanceInternal[u] + e.w < distanceInternal[e.v]) {
                    distanceInternal[e.v] = distanceInternal[u] + e.w;
                    distance[e.v] = distance[e.u] + e.w - BFshortest[e.u] + BFshortest[e.v];
                    PQelems[e.v].priority = distanceInternal[e.v];
                    PrioQ.add(PQelems[e.v]);
                }
            }
        }
        return distance;
    }
}
