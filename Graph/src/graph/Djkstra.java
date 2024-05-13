package graph;

import java.util.ArrayList;

public class Djkstra {

    int[][] adj; //ma tran ke
    int[] V;//vertex
    int[] predecessor;// node phia truoc
    int[] minDist;//khoang cach ngan nhat
    int n = 9;//so luong vertex
    final int MAX = Integer.MAX_VALUE;

    public Djkstra() {
        V = new int[n];
        //khoi tao node tu 0 den 8
        for (int i = 0; i < n; i++) {
            V[i] = i;
        }
        adj = new int[][]{
          //  0     1        2       3       4       5       6      7       8                       
            {MAX,   4,      MAX,    MAX,    MAX,    MAX,    MAX,    8,     MAX},//0
            {4,     MAX,    8,      MAX,    MAX,    MAX,    MAX,    11,    MAX},//1
            {MAX,    8,     MAX,    7,      MAX,    4,      MAX,    MAX,   2},//2
            {MAX,   MAX,    7,      MAX,    9,      14,     MAX,    MAX,   MAX},//3
            {MAX,   MAX,    MAX,    9,      MAX,    10,     MAX,    MAX,   MAX},//4
            {MAX,   MAX,    4,      14,     10,     MAX,    2,      MAX,   MAX},//5
            {MAX,   MAX,    MAX,    MAX,    MAX,    2,      MAX,    1,     6},//6
            {8,     11,     MAX,    MAX,    MAX,    MAX,    1,      MAX,   7},//7
            {MAX,   MAX,    2,      MAX,    MAX,    MAX,    6,      7,     MAX}//8     
        };
        //tinh duong di ngan nhat tu node thu inx trong V den tat ca cac node con 
        //lai trong do thi dung djkstra   
    }

    public void djkstra(int start) {
        minDist = new int[n];//khoi tao mang duong di ngan nhat toi tat ca cac node
        //cai tat ca gia tri bang vo cung
        for (int i = 0; i < n; i++) {
            minDist[i] = MAX;
        }
        predecessor = new int[n];//khoi tao mang chua cac node lien truoc cac node trong V
        //tinh thao vi tri Vi du V[i] thi se co predecessor tuong ung la predecessor[i]
        for (int i = 0; i < n; i++) {
            predecessor[i] = -1;
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        minDist[start] = 0;//truoc khi vao thuat toan gan gia tri minDist[start] = 0
        do {
            visited[start] = true;//vi tri dau tien nam trong cloud
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    if (adj[start][i] < MAX && minDist[start] + adj[start][i] < minDist[i]) {
                        //cap nhat lai minDist tai vi tri thu i la khoang cach tu start de i
                        minDist[i] = minDist[start] + adj[start][i];
                        predecessor[i] = start; //node vi tri truoc i trong duong di ngan nhat la vi tri start
                    }
                }
            }
            //buoc 2: tim vi tri start moi de bat dau lai
            int min = MAX;
            start = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && minDist[i] < min) {
                    start = i;
                    min = minDist[i];
                }
            }
        } while (start != -1);
    }

    public void print(int start, int stop) {
        ArrayList<String> list = new ArrayList();
        int curr = stop;
        do {
            list.add(0, "(" + V[curr] + "," + minDist[curr] + ")");
            curr = predecessor[curr];
        } while (curr != -1);
        System.out.println(String.join("->", list));
    }

    public static void main(String[] args) {
        Djkstra dij = new Djkstra();
        dij.djkstra(0);//dijstra(0)
        dij.print(0, 4);
    }
}
