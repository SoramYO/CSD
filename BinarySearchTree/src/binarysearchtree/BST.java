/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.ArrayList;

/**
 *
 * @author Son
 */
public class BST {

    public static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this(data, null, null);
        }

    }
    Node root = null;

    public void visit(Node v) {
        System.out.print(v.data + " ");
    }

    public void preOder(Node v) {
        if (v == null) {
            return;
        }
        visit(v);
        preOder(v.left);
        preOder(v.right);

    }

    public void postOder(Node v) {
        if (v == null) {
            return;
        }
        postOder(v.left);
        postOder(v.right);
        visit(v);
    }

    public void inOder(Node v) {
        if (v == null) {
            return;
        }
        inOder(v.left);
        visit(v);
        inOder(v.right);
    }

    public void breathFirstSearch(Node n) {
        //Duyệt cây theo chiều ngang
        ArrayList<Node> q = new ArrayList();
        //enqueue tương ứng với add
        q.add(n);
        while (!q.isEmpty()) {
            Node front = q.remove(0); //dequeue
            visit(front);
            if (front.left != null) {
                q.add(front.left);
            }
            if (front.right != null) {
                q.add(front.right);
            }
        }
    }

    public Node search(int data) {
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                return current;
            } //neu data nho hon node hien tai tim ben trai
            else if (current.data > data) {
                current = current.left;
            } //neu data lon hon node hien tai tim ben phai
            else {
                current = current.right;
            }
        }
        return null;//not found
    }

    public void deleteByCopy(Node n) {
        //xoa node n 
        Node leftSubTree = n.left;
        Node rightMost = n.right;
        Node parent = leftSubTree;
        while (rightMost.right != null) {
            parent = rightMost; //tim partent cua rightMost
            rightMost = rightMost.right; //tim rightMost cua cay ben trai
        }
        //Buoc 2 dua con cho ong noi
        parent.right = rightMost.left;
        //Buoc 3 copy gia tri cua rightMost cho node n
        n.data = rightMost.data;

    }

    public Node insert(Node v, int data) {
        if (v == null) {
            return new Node(data);
        }
//Khi da tim thay vi tri cua data return node moi cho progr
        if (v.data > data) {
            //node vo gia tri lon hon ta se inseart
            //vao ben trai
            v.left = insert(v.left, data);
            return v;
        } else if (v.data < data) {
            //node vo gia tri be hon ta se inseart
            //vao ben phai
            v.right = insert(v.right, data);
            return v;
        } else {
            return v; //duplicate
        }
    }

    public void insert(int data) {
//Ham insert khong dung de qui
        if (root == null) {
            root = new Node(data);
        }
        Node curr = root, parent = null;
        while (curr != null) {

            parent = curr; //luu gia tri parent cua curr truoc khi sang trai hoac phai
            if (curr.data > data) {
                curr = curr.left;
            } else if (curr.data < data) {
                curr = curr.right;
            } else {
                return; //dupplicate
            }
        }
        if (parent.data > data) {
            parent.left = new Node(data);
        } else if (parent.data < data) {
            parent.right = new Node(data);
        } else {
            return;//dupplicate
        }
    }
    public int height (Node n){
        if(n==null) return 0;
        int leftH = 1 + height(n.left); //tinh chieu cau cay ben trai
        int rightH = 1 + height(n.right);//tinh chieu cau cay ben phai
        if(leftH >rightH) return leftH;
        else return rightH;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] list = {10, 15, 8, 6, 20, 9, 7, 11};
        for (int data : list) {
//            bst.root = bst.insert(bst.root, data);
            bst.insert(data);
        }
        Node n15 = bst.search(15);
        System.out.println("height(15) =" + bst.height(n15));
        Node n = bst.search(10);
        bst.deleteByCopy(n);
        System.out.println("PreOder: ");
        bst.preOder(bst.root);
        System.out.println("\nPosOder: ");
        bst.postOder(bst.root);
        System.out.println("\nInOder: ");
        bst.inOder(bst.root);
        System.out.println("\nBFS:");
        bst.breathFirstSearch(bst.root);//10 8 15 6 9 11 20 7
        
    }
}
