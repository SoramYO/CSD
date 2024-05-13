/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Son
 */
public class ABL extends BST {

    public void balance() {
        //Buoc 1 nap du lieu vao mang
        ArrayList<Node> data = new ArrayList();
        //breath first search
        ArrayList<Node> q = new ArrayList();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove(0);
            data.add(n);
            if (n.right != null) {
                q.add(n.right);
            }
            if (n.left != null) {
                q.add(n.left);
            }
        }
        //Buoc 2 sort du lieu
        Collections.sort(data, (Node n1, Node n2) -> {
            if (n1.data > n2.data) {
                return 1;
            } else if (n1.data < n2.data) {
                return -1;
            } else {
                return 0;
            }
        });
        root = null;
        balance(data, 0, data.size() - 1);
    }

    //Buoc 3 xoay cay nhi phan va thuc hien de quy viec insert
    //du lieu tai phan tu giua mang
    private void balance(List<Node> data, int first, int last) {
        if (first <= last) {
            int mid = (first + last) / 2;
            insert(data.get(mid).data);
            balance(data, first, mid - 1);
            balance(data, mid + 1, last);
        }
    }

    public static void main(String[] args) {
        ABL avl = new ABL();
        avl.insert(5);
        avl.insert(1);
        avl.insert(9);
        avl.insert(8);
        avl.insert(7);
        avl.insert(0);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(6);
        System.out.println("Before balacing");
        System.out.println("PreOrder: ");
        avl.preOder(avl.root);//5102349876
        System.out.println("\nInOrder: ");
        avl.inOder(avl.root);//0123456789
        System.out.println("\nPostOrder: ");
        avl.postOder(avl.root);//0432167895
        System.out.println("\nBFS: ");
        avl.breathFirstSearch(avl.root);//5 1 9 0 2 8 3 7 4 6 
        avl.balance();
        System.out.println("\n\nAfter balacing");
        System.out.println("PreOrder: ");
        avl.preOder(avl.root);//4 1 0 2 3 7 5 6 8 9 
        System.out.println("\nInOrder: ");
        avl.inOder(avl.root);//0 1 2 3 4 5 6 7 8 9 
        System.out.println("\nPostOrder: ");
        avl.postOder(avl.root);//0 3 2 1 6 5 9 8 7 4 
        System.out.println("\nBFS: ");
        avl.breathFirstSearch(avl.root);//4 1 7 0 2 5 8 3 6 9

    }
}
