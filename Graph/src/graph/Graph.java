
package graph;


import java.util.ArrayList;

public class Graph {
    public static class Vertex{
        String airPortName;
        public Vertex(String name){
            this.airPortName=name;
        }
    }
    ArrayList<Vertex> V;//tap hop cac node trong do thi
    int[][] adj;//Ma tran ke
    public Graph(){
        V = new ArrayList();
        Vertex hnl = new Vertex("HNL");V.add(hnl);
        Vertex lax = new Vertex("LAX");V.add(lax);
        Vertex sfo = new Vertex("SFO");V.add(sfo);
        Vertex ord = new Vertex("ORD");V.add(ord);
        Vertex dfw = new Vertex("DFW");V.add(dfw);
        Vertex lga = new Vertex("LGA");V.add(lga);
        Vertex pvd = new Vertex("PVD");V.add(pvd);
        Vertex mia = new Vertex("MIA");V.add(mia);
        //Vi co 8 node nen ma tran ke 
        //se co kich thuoc la 8x8
        adj = new int[8][8];
                        //HNL   LAX     SFO     ORD     DFW     LGA     PVD     MIA
        adj[0]=new int[]{-1,   2555,    -1,      -1,      -1,     -1,     -1,     -1 };//HNL
        
        adj[1]=new int[]{2555,   -1,   337,    1743,    1233,     -1,     -1,     -1 };//LAX
        
        adj[2]=new int[]{-1,    337,    -1,    1843,      -1,     -1,     -1,     -1 };//SFO
        
        adj[3]=new int[]{-1,   1743,  1843,    -1  ,     802,     -1,    849,     -1 };//ORD
        
        adj[4]=new int[]{-1,   1233,  -1  ,    802 ,     -1 ,   1387,    -1 ,   1120 };//DFW
        
        adj[5]=new int[]{-1,   -1  ,  -1  ,    -1  ,    1387,   -1  ,    142,   1099 };//LGA
        
        adj[6]=new int[]{-1,   -1  ,  -1  ,    849 ,    -1  ,   142 ,    -1 ,   -1   };//PVD
        
        adj[7]=new int[]{-1,   -1  ,  -1  ,    -1  ,    1120,   1099,    -1 ,   -1   };//MIA
    }
    
    public void visit(Vertex v){
        System.out.print(v.airPortName+" ");
    }
    public int getVertexIndex(Vertex v){
        for(int i=0;i<V.size();i++){
            if(V.get(i).airPortName.equals(v.airPortName)) return i;
        }
        return -1;
    }
    public void bfs(Vertex n,boolean[] enqueued){
        if(n==null) return;
        ArrayList<Vertex> queue = new ArrayList();
        queue.add(n);//enqueue
        enqueued[getVertexIndex(n)]=true;
        while(!queue.isEmpty()){
            Vertex v = queue.remove(0);//dequeue
            visit(v);
            //Duyet ma tran ke de tim vertex co noi voi v
            int i = getVertexIndex(v);//hang thu i
            for(int j=0;j<8;j++){
                if(adj[i][j]>-1 && !enqueued[j]){
                    //neu nhu node v co noi voi node k
                    //thi adj[i][j]>-1, check node k da duyet hay chua thong qua
                    //mang enqueued[j] co khac true hay khong
                    enqueued[j]=true;
                    Vertex k = V.get(j);
                    queue.add(k);
                }
            }
        }
    } 
    public void bfs(Vertex n){
        boolean[] enqueued = new boolean[8];
        bfs(n,enqueued);//Lan duyet do thi dau tien
        for(int i=0;i<8;i++){
            if(!enqueued[i]) bfs(V.get(i),enqueued);//gia su sau khi duyet bfs cua n, van con 1 so Vertex trong do thi chua duoc duyet
            //ta se thuc hien duyet bfs voi Vertex do de dam bao tat ca cac vertex trong do thi deu duoc duyet
        }
    }
    
    public void dfs(Vertex n, boolean[] visited){
        if(n==null) return;//
        int i = getVertexIndex(n);
        visited[i]=true;
        visit(n);
        for(int j=0;j<8;j++){
            if(adj[i][j]>-1&& !visited[j]){
                dfs(V.get(j),visited);
            }
        }
    }
    public void dfs(Vertex n){
        boolean[] visited = new boolean[8];//hard code 
        dfs(n,visited);
        for(int i=0;i<8;i++){
            if(!visited[i]) dfs(V.get(i),visited);
        }
    }
    public static void main(String[] args){
        Graph g = new Graph();
        g.bfs(g.V.get(0));//bfs(hnl)
        System.out.println("");
        g.dfs(g.V.get(1));//dfs(LAX)
    }
}
