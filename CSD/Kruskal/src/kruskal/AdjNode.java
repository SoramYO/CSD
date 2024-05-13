package kruskal;

public class AdjNode {
    int vertice;
    int distance;

    //just Constructor, Getter, Setter
    public AdjNode() {
    }

    public AdjNode(int vertice, int distance) {
        this.vertice = vertice;
        this.distance = distance;
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
}
