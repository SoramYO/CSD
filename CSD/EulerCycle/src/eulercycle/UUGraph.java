/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulercycle;

import java.util.*;

public class UUGraph {

    int N;
    ArrayList<Integer>[] adj;


    public UUGraph(int n) {

        this.N = n;
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addManyEdge(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            addEdge(a[i], b[i]);
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
    
    public void removeEdge(Integer u, Integer v)
    {
        adj[u].remove(v);
        adj[v].remove(u);
    }

    public ArrayList<Integer> findEulerCycle() {
        ArrayList<Integer> eulerCycle = new ArrayList<>();

        if (!isEulerianCyclePossible()) {
            return eulerCycle;
        }

        int startVertex = 1;

        // Find the Euler cycle using the Fleury's algorithm

        dfs(startVertex, eulerCycle);
        return eulerCycle;
    }

    private void dfs(int v, ArrayList<Integer> eulerCycle) {

        while (!adj[v].isEmpty()) {
            int neighbor = adj[v].get(0);
            removeEdge(v, neighbor);
            dfs(neighbor, eulerCycle);
        }
       
        eulerCycle.add(v);
    }

    //Check if the graph have Euler Cycle
    private boolean isEulerianCyclePossible() {
        if (connectedComponent() != 1) {
            return false;
        }

        for (int i = 1; i <= N; i++) {
            if (adj[i].size() % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    //Count the connected component
    private int connectedComponent() {  
        int CC = 0;
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFSz(i, visited);
                CC++;
            }
        }
        return CC;
    }

    //Help for connectedComponent()
    private void DFSz(int v, boolean[] visited) {   
        visited[v] = true;
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFSz(neighbor, visited);
            }
        }
    }
}
