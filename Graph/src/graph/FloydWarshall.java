/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Son
 */
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class FloydWarshall {
    static final int MAXN = 100;
    static final int INF = Integer.MAX_VALUE;
    static int num;
    int[][] dist = new int[MAXN][MAXN];
    int[][] next = new int[MAXN][MAXN];
    int[][] graph;
    public FloydWarshall(){
        initialize();
    }
    void initialize(){
        num=4;
        graph = new int[][]{ { 0,   3, INF,   7 },
                             { 8,   0,  2 , INF },
                             { 5, INF,  0 ,   1 },
                             { 2, INF, INF,   0 } };
        for(int i=0;i<num;i++)
            for(int j=0;j<num;j++){
                dist[i][j]=graph[i][j];
                if(graph[i][j]==INF)
                    next[i][j]=-1;
                else
                    next[i][j]=j;
            }
        
    }
    ArrayList<Integer> constructPath(int u,int v){
        //If there's no path beetween
        //node u and v, simple return 
        //an empty array
        if(next[u][v]==-1) return null;
        ArrayList<Integer> path = new ArrayList();
        path.add(u);
        while(u!=v){
            u = next[u][v];
            path.add(u);
        }
        return path;
    }
    // standard Floyd Warshall algorithm
    // with little modification. Now if we
    // find that dist[i][j]>dist[i][k]+dist[k][j]
    public void floydWarshall(){
        for(int k=0;k<num;k++){
            for(int i=0;i<num;i++){
                for(int j=0;j<num;j++){
                    // We cannot travel through
                    // edge that doesnt exist
                    if(dist[i][k]==INF ||
                            dist[k][j]==INF)
                        continue;
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                        next[i][j]=k;
                    }
                }
            }
        }
    }
    public void printPath(ArrayList<Integer> path)
    {
        int n = path.size();
        for(int i = 0; i < n - 1; i++)
        System.out.print(path.get(i) + " -> ");
        System.out.print(path.get(n - 1) + "\n");
    }
    public static void main(String[] args){
        FloydWarshall floyd = new FloydWarshall();
        floyd.floydWarshall();
        ArrayList<Integer> path = floyd.constructPath(1, 3);
        floyd.printPath(path);
    }
}