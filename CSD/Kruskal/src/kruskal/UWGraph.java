package kruskal;

import java.util.*;

//undirected, weighted graph;
public class UWGraph {

    int N; //number of vertice;
    ArrayList<ArrayList<AdjNode>> adj;

    public UWGraph() {
    }

    public UWGraph(int N) {
        this.N = N;
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addManyEdge(int src[], int des[], int wei[]) {
        for (int i = 0; i < src.length; i++) {
            addEdge(src[i], des[i], wei[i]);
        }
    }

    public void addEdge(int src, int des, int wei) {
        adj.get(src).add(new AdjNode(des, wei));
        adj.get(des).add(new AdjNode(src, wei));
    }

    public void display() {
        System.out.println("Edges and their weight:");
        for (int i = 1; i <= N; i++) {
            for (AdjNode an : adj.get(i)) {
                if (i < an.getVertice()) {
                    System.out.println(i + " " + an.getVertice() + " " + an.getDistance());
                }
            }
        }
    }

    public UWGraph kruskal() {
        //Minimum spanning tree
        UWGraph MST = new UWGraph(N);
        int MSTe = 0; //number of edge in MST

        //Create a MIN HEAP to store the edge
        PriorityQueue<Edge> eq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        for (int i = 1; i <= N; i++) {
            for (AdjNode an : adj.get(i)) {
                if (i < an.vertice) {
                    eq.add(new Edge(i, an.vertice, an.distance));
                }
            }
        }

        //Disjoint set
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        while (MSTe < N - 1) {
            Edge minE = eq.poll();
            int v1 = minE.getVertice1();
            int v2 = minE.getVertice2();
            if (family(parent, v1) != family(parent, v2)) {
                MST.addEdge(v1, v2, minE.getWeight());
                MSTe++;
                union(parent, v1, v2);//union 2 disjoint set
            }

        }

        return MST;
    }

    private int family(int[] parent, int x) {   //find family in Disjoint set
        if (x == parent[x]) {
            return x;
        }
        return family(parent, parent[x]);
    }

    private void union(int[] par, int x, int y) {
        int f1 = family(par, x);
        int f2 = family(par, y);
        par[f2] = f1;
    }

}
