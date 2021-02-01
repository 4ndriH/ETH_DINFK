package MST;

import Graph.*;
import java.util.*;

public class Kruskal {
    Graph g;

    public Kruskal(Graph g) {
        this.g = g;

        ArrayList<Edge> MST = Kruskal();

        int cost = 0;

        System.out.println("Kruskal:");
        for (Edge e : MST) {
            System.out.println(e.toString());
            cost += e.w;
        }
        System.out.println("Cost of the MST: " + cost);
    }

    public ArrayList<Edge> Kruskal() {
        ArrayList<Edge> MST = new ArrayList<Edge>();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        UnionFind uf = new UnionFind(g.V);

        for (ArrayList<Edge> al : g.adjL) {
            for (Edge e : al) {
                edges.add(e);
            }
        }

        Collections.sort(edges);

        for (Edge e : edges) {
            if (uf.getZHKs() > 1 && !uf.same(e.u, e.v)) {
                MST.add(e);
                uf.union(e.u, e.v);
            }
        }

        return MST;
    }
}