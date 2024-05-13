/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulercycle;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] a, b;
        a = new int[]{1, 2, 1, 3, 4, 4, 5, 8,7};
        b = new int[]{2, 4, 3, 4, 5, 6, 7, 6,8};
        int n = 8;

        UUGraph gr = new UUGraph(n);
        gr.addManyEdge(a, b);
        List<Integer> ec = gr.findEulerCycle();
        for (int v : ec){
            System.out.print(" "+ v);
        }
    }

}
