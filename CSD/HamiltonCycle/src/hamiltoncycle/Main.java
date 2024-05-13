package hamiltoncycle;

public class Main {

    public static void main(String[] args) {
        int[] a, b;
        a = new int[]{1, 1, 1, 2, 2, 3, 3, 4};
        b = new int[]{2, 3, 4, 3, 4, 5, 4, 5};
        int n = 5;

        HamiltonSolver hs = new HamiltonSolver(n);
        hs.addManyEdge(a, b);
        //hs.display();
        
        hs.hamiltonCycle();
    }

}
