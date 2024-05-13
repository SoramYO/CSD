/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xForest, int xRate, int xSound) {
        //You should insert here statements to complete this function
        if (xForest.charAt(0) == 'A') {
            return;
        }
        Boo x = new Boo(xForest, xRate, xSound);
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            int comparetype = x.sound - current.info.sound;
            if (comparetype < 0) {
                current = current.left;
            } else if (comparetype > 0) {
                current = current.right;
            } else {
                return;
            }
        }
        if (parent == null) {
            root = new Node(x);
        } else {
            int comparetpye = x.sound - parent.info.sound;
            if (comparetpye < 0) {
                parent.left = new Node(x);
            } else {
                parent.right = new Node(x);
            }
        }

    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.rate < 6) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }
//=============================================================

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    class Counter {

        int count;

        Counter() {
            this.count = 0;
        }
    }

    Node findAndGet4thNode(Node p, Counter counter) {
        if (p == null) {
            return null;
        }

        counter.count++;

        if (counter.count == 4) {
            return p;
        }

        Node leftResult = findAndGet4thNode(p.left, counter);
        if (leftResult != null) {
            return leftResult;
        }

        Node rightResult = findAndGet4thNode(p.right, counter);
        if (rightResult != null) {
            return rightResult;
        }

        return null;
    }

    Node deleteByCopying(Node p, int sound) {
        if (p == null) {
            return null;
        }

        if (sound < p.info.sound) {
            p.left = deleteByCopying(p.left, sound);
        } else if (sound > p.info.sound) {
            p.right = deleteByCopying(p.right, sound);
        } else {
            if (p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            } else {
                Boo successor = findSmallest(p.right);
                p.info = successor;
                p.right = deleteByCopying(p.right, successor.sound);
            }
        }

        return p;
    }

    Boo findSmallest(Node p) {
        if (p.left == null) {
            return p.info;
        } else {
            return findSmallest(p.left);
        }
    }

//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        Counter counter = new Counter();
        Node fourthNode = findAndGet4thNode(root, counter);
        if (fourthNode != null) {
            root = deleteByCopying(root, fourthNode.info.sound);
        }
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        Counter counter = new Counter();
        Node fourthNode = findAndGet4thNode(root, counter);
        if (fourthNode != null && fourthNode.right != null) {
            Node rightChild = fourthNode.right;
            fourthNode.right = rightChild.left;
            rightChild.left = fourthNode;
        }

        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
