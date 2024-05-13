package dijkstra;

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

        for (int i = 1; i <= N; i++) {
            for (AdjNode an : adj.get(i)) {
                //if (i<an.getVertice())
                System.out.println(i + " " + an.getVertice() + " " + an.getDistance());
            }   
        }
    }

    public int[] dijkstra(int source) {
        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minVertex = -1;

            // Find the vertex with the minimum distance
            for (int v = 1; v <= N; v++) {
                if (!visited[v] && distances[v] < minDistance) {
                    minDistance = distances[v];
                    minVertex = v;
                }
            }

            if (minVertex == -1) {
                break;
            }

            visited[minVertex] = true;

            // Update distances of adjacent vertices
            for (AdjNode a : adj.get(minVertex)) {
                int v = a.getVertice();
                int w = a.getDistance();
                distances[v] = Math.min(distances[v], distances[minVertex]+w);
            }
        }

        return distances;
    }

}
