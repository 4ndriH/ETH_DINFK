package MST;

import java.util.*;
import Graph.*;

public class Boruvka {
    Graph g;

    public Boruvka(Graph g) {
        this.g = g;

        ArrayList<Edge> MST = Boruvka();

        int cost = 0;

        System.out.println("Boruvka:");
        for (Edge e : MST) {
            System.out.println(e.toString());
            cost += e.w;
        }
        System.out.println("Cost of the MST: " + cost);
    }

    public ArrayList<Edge> Boruvka() {
        ArrayList<Edge> MST = new ArrayList<>();
        UnionFind uf = new UnionFind(g.V);

        boolean[][] adjMat = new boolean[g.V][g.V];
        boolean[] uselessE = new boolean[g.E];
        int[] cheapest = new int[g.V];
        Edge[] edges = new Edge[g.E];
        int idx = 0;

        for (int i = 0; i < g.V; i++) {
            cheapest[i] = - 1;
            for (Edge e : g.adjL.get(i)) {
                if (!adjMat[e.u][e.v] && !adjMat[e.v][e.u]) {
                    edges[idx++] = e;
                    adjMat[e.u][e.v] = true;
                }
            }
        }

        while (uf.getZHKs() > 1) {
            for (int i = 0; i < g.E; i++) {
                if (!uselessE[i]) {
                    Edge e = edges[i];
                    int uRoot = uf.find(e.u);
                    int vRoot = uf.find(e.v);
                    if (uRoot == vRoot) {
                        uselessE[i] = true;
                        continue;
                    }
                    if (cheapest[uRoot] == -1 || edges[cheapest[uRoot]].w > e.w) {
                        cheapest[uRoot] = i;
                    }
                    if (cheapest[vRoot] == -1 || edges[cheapest[vRoot]].w > e.w) {
                        cheapest[vRoot] = i;
                    }
                }
            }
            for(int i = 0; i < g.V; i++) {
                int cheapestIdx = cheapest[i];
                cheapest[i] = -1;
                if (cheapestIdx != -1) {
                    Edge cheap = edges[cheapestIdx];
                    int uRoot = uf.find(cheap.u);
                    int vRoot = uf.find(cheap.v);
                    if (uRoot == vRoot) {
                        uselessE[cheapestIdx] = true;
                        continue;
                    }
                    uf.union(uRoot, vRoot);
                    MST.add(cheap);
                }
            }
        }

        return MST;
    }
}