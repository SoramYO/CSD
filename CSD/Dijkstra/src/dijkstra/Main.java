package dijkstra;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] a, b, c;
        
//        int a[] = {1, 1, 1, 2, 3, 4};
//        int b[] = {2, 3, 5, 3, 4, 5};
//        int c[] = {1, 4, 7, 9, 2, 3};

//    a = new int[]{1, 1, 1, 2, 2, 3, 4, 5, 6, 7};
//    b = new int[]{2, 3, 4, 5, 6, 7, 8, 8, 9, 9};
//    c = new int[]{4, 2, 5, 3, 1, 6, 3, 2, 4, 5};
//    
        a = new int[]{1, 1, 2, 2, 5, 3, 4, 4, 5};
        b = new int[]{2, 3, 3, 4, 2, 5, 5, 6, 6};
        c = new int[]{12, 4, 1, 5, 3, 2, 3, 10, 8};
        int n = 6;

        UWGraph gr = new UWGraph(n);
        gr.addManyEdge(a, b, c);
        int dt[] = gr.dijkstra(1);
        for (int i = 1; i <= n; i++) {
            System.out.println("1 -> " + i + " : " + dt[i]);
        }

        gr.display();
    }

}
