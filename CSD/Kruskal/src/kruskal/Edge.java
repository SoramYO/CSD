/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

/**
 *
 * @author Quangz
 */
public class Edge {
    int vertice1,vertice2,weight;

    public Edge() {
    }

    public Edge(int vertice1, int vertice2, int weight) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.weight = weight;
    }

    public int getVertice1() {
        return vertice1;
    }

    public void setVertice1(int vertice1) {
        this.vertice1 = vertice1;
    }

    public int getVertice2() {
        return vertice2;
    }

    public void setVertice2(int vertice2) {
        this.vertice2 = vertice2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    
}
