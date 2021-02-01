package ShortestPath;

import Graph.*;
import java.util.*;

public class Dijkstra {
    Graph g;

    public Dijkstra(Graph g) {
        this.g = g;

        System.out.println("Dijkstra:");
        System.out.println(Arrays.toString(Dijkstra(0)));
    }

    public int[] Dijkstra(int start) {
        int[] distance = new int[g.V];
        Vertex[] PQelems = new Vertex[g.V];
        PriorityQueue<Vertex> PrioQ = new PriorityQueue<>();

        for (int i = 0; i < g.V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;
        PQelems[start] = new Vertex(start, 0);
        PrioQ.add(PQelems[start]);

        while (!PrioQ.isEmpty()) {
            Vertex vert = PrioQ.poll();
            int u = vert.idx;
            for (Edge e : g.adjL.get(u)) {
                if (distance[e.v] == Integer.MAX_VALUE) {
                    distance[e.v] = distance[u] + e.w;
                    PQelems[e.v] = new Vertex(e.v, distance[e.v]);
                    PrioQ.add(PQelems[e.v]);
                } else if (distance[u] + e.w < distance[e.v]) {
                    distance[e.v] = distance[u] + e.w;
                    PQelems[e.v].priority = distance[e.v];
                    PrioQ.add(PQelems[e.v]);
                }
            }
        }
        return distance;
    }
}