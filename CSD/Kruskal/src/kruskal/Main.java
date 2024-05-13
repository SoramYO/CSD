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
public class Main {

    public static void main(String[] args) {
        int[] a, b, c;

        a = new int[]{1, 1, 2, 2, 5, 3, 4, 4, 5};
        b = new int[]{2, 3, 3, 4, 2, 5, 5, 6, 6};
        c = new int[]{12, 4, 1, 5, 3, 2, 3, 10, 8};
        int n = 6;

        UWGraph gr = new UWGraph(n);
        gr.addManyEdge(a, b, c);
        UWGraph mst = gr.kruskal();
        gr.display();
        mst.display();
    }

}
