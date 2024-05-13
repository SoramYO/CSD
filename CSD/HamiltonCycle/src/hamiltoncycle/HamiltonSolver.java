package hamiltoncycle;

import java.util.*;

public class HamiltonSolver extends UUGraph {

    int[] h;     //to try every posible path
    boolean[] visited;
    boolean cycle_detected;

    public HamiltonSolver(int n) {
        super(n);
        h = new int[n + 1];
        visited = new boolean[n + 1];
        cycle_detected = false;
    }
    
    //Print out an Array ** quite not OOP
    public void prtArr(int a[]){
        for (int x:a){
            System.out.print(" "+x);
        }
        System.out.println("");
    }

    public int[] hamiltonCycle() {
        int[] Hmt = new int[N + 1];   //save hmt cycle 
        h[0] = 1; h[N]=1;
        visited[1] = true;
        tryh(1, Hmt);
        return Hmt;
    }

    private void tryh(int i, int[] hmt) {
        
        if (cycle_detected==true){
            return;
        }
        
        //if h[n-1] adj with h[0] -> hamilton cycle detected
        if (i == N && super.adj[h[N - 1]].contains((Integer) h[0])) {
            for (int j = 0; j <= N; j++) {
                hmt[j] = h[j];  //copy h to hmt
            }
            //cycle_detected = true;                 / lit only 1 line
            prtArr(hmt); //Can print every cycle    /
            return;
        }
        
        if (i==N){
            return;
        }

        for (int u : super.adj[h[i - 1]]) if (!visited[u]){
            visited[u] = true;
            h[i] = u;
            tryh(i+1, hmt);
            visited[u] = false;
        }
    }
}
