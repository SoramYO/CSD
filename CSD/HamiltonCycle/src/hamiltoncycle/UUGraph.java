package hamiltoncycle;

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
    
    public void display(){
        for (int i=1;i<=N;i++) if (!adj[i].isEmpty()){
            for (int x: adj[i]){
                if (x>i)
                System.out.println(i+" "+x);
            }
        }
    }
}
