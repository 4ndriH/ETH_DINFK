package MST;

import Graph.*;
import java.util.*;

public class Prim {
    Graph g;

    public Prim(Graph g) {
        this.g = g;

        ArrayList<Edge> MST = Prim(0);

        int cost = 0;

        System.out.println("Prim:");
        for (Edge e : MST) {
            System.out.println(e.toString());
            cost += e.w;
        }
        System.out.println("Cost of the MST: " + cost);
}

    public ArrayList<Edge> Prim(int start) {
        ArrayList<Edge> MST = new ArrayList<Edge>();
        TreeSet<Edge> minHeap = new TreeSet<Edge>();
        boolean[] visited = new boolean[g.V];
        int ZHKs = g.V;

        for (Edge e : g.adjL.get(start)) {
            minHeap.add(e);
        }

        visited[start] = true;

        while (ZHKs > 1 && !minHeap.isEmpty()) {
            Edge minE = minHeap.pollFirst();
            if (!visited[minE.v]) {
                MST.add(minE);
                visited[minE.u] = visited[minE.v] = true;
                ZHKs--;
                for (Edge e : g.adjL.get(minE.v)){
                    minHeap.add(e);
                }
            }
        }

        return MST;
    }
}