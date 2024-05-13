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
    void insert(String xMaker, int xTpye, int xRadius) {
        //You should insert here statements to complete this function
        if (xMaker.charAt(0) == 'B') {
            return;
        }
        Ball newBall = new Ball(xMaker, xTpye, xRadius);
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            int comparetype = newBall.type - current.info.type;
            if (comparetype < 0) {
                current = current.left;
            } else if (comparetype > 0) {
                current = current.right;
            } else {
                return;
            }
        }
        if (parent == null) {
            root = new Node(newBall);
        } else {
            int comparetpye = newBall.type - parent.info.type;
            if (comparetpye < 0) {
                parent.left = new Node(newBall);
            } else {
                parent.right = new Node(newBall);
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
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        postOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        if (p.info.radius < 5) {
            fvisit(p, f);
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
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        inOrder2(root, f);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

     public void deleteByCopying(int x) {
        if (isEmpty()) {
            System.out.println("The tree is empty. No deletion.");
            return;
        }

        Node p = root;
        Node f = p;
        while (p != null) {
            if (p.info.type == x) {
                break;
            } else {
                f = p;
                if (x < p.info.type) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
        }

        if (p == null) {
            System.out.println(x + " does not exist. No deletion.");
            return;
        }

        // Case 1: p is a leaf node
        if (p.left == null && p.right == null) {
            if (root == p) {
                root = null;
                return;
            }

            if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        }

        // Case 2: p has only one child
        if (p.left == null && p.right != null) { // p has right child
            if (root == p) {
                root = root.right;
                return;
            }

            if (p == f.left) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } else if (p.left != null && p.right == null) { // p has left child
            if (root == p) {
                root = root.left;
                return;
            }

            if (p == f.left) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }

        // Case 3: p has both left and right children
        if (p.left != null && p.right != null) {
            Node s = p.left; // Find the rightmost node in the left subtree
            Node fs = p; // Parent of s
            while (s.right != null) {
                fs = s;
                s = s.right;
            }

            // Copying
            p.info = s.info; // Replace p's key with s's key

            // Deleting by copying
            if (fs.left == s) {
                fs.left = s.left;
            } else {
                fs.right = s.left;
            }
        }
    }
    int count = 0;
//Xóa của inorder
   void inOrder2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
        return;
    }
    Stack<Node> stack = new Stack<>();
    Node current = p;

    while (!stack.isEmpty() || current != null) {
        if (current != null) {
            stack.push(current);
            current = current.left;
        } else {
            current = stack.pop();

            if (current.right != null && current.left != null ) {
                count++;
                if (count == 1) {
                    deleteByCopying(current.info.type);
                    break;
                }
            }                   

            current = current.right;
        }
    }
}
   //Xóa của PreOrder
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
        return;
    }
    Stack<Node> stack = new Stack<>();
    Node current = p;
    int count = 0;

    while (!stack.isEmpty() || current != null) {
        if (current != null) {
            stack.push(current);

            if (current.right != null && current.left != null) {
                count++;
                if (count == 1) {
                    deleteByCopying(current.info.type);
                    break;
                }
            }

            current = current.left;
        } else {
            current = stack.pop();
            current = current.right;
        }
    }
}
    //Xóa của PostOrder
    void postOrder3(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
        return;
    }
    Stack<Node> stack = new Stack<>();
    Node current = p;
    int count = 0;

    while (!stack.isEmpty() || current != null) {
        if (current != null) {
            stack.push(current);

            if (current.right != null && current.left != null) {
                count++;
                if (count == 1) {
                    deleteByCopying(current.info.type);
                    break;
                }
            }

            current = current.right;
        } else {
            current = stack.pop();
            current = current.left;
        }
    }
}
//xóa theo rộng
    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.right != null && r.left != null && r.info.type < 7) {
                count++;
                if (count == 1) {
                    deleteByCopying(r.info.type);
                    break;
                }
            }
            //  fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
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
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
//        preOrder2(root, f);
        postOrder3(root, f);
//        inOrder2(root, f);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    //Chạy thử để biết :v
    void breadth3(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
        return;
    }
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
        r = q.dequeue();
        if (r.left != null && r.info.type < 7) {
            // Rotate r to right about its left son
            Node leftSon = r.left;
            r.left = leftSon.right;
            leftSon.right = r;
            if (q.isEmpty()) {
                p = leftSon;
            }
            // Output the node to the file
            f.writeBytes("(" + r.info.maker + "," + r.info.type + ") ");
        }
        
        if (r.right != null) {
            q.enqueue(r.right);
        }
        if (r.left != null) {
            q.enqueue(r.left);
        }
    }
}
    //delete the most right/left
     void delete(Node root) {
        if (root == null) {
            return;
        }
        if (root.right != null && root.right.right == null) {
            root.right = root.right.left;
            return;
        }
        delete(root.right);
    }
     //rotate left
     //trên hàm f4
//       Node current = root;
//        Node parent = null;
//        while (current.right != null) {
//            parent = current;
//            current = current.right;
//        }
//
//        if (parent != null) {
//            rotateLeft(parent);
//        }
      void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;

        if (node == root) {
            root = rightChild;
        } else {
            Node parent = root;
            while (parent.left != node && parent.right != node) {
                if (node.info.type < parent.info.type) {
                    parent = parent.left;
                } else {
                    parent = parent.right;
                }
            }
            if (node == parent.left) {
                parent.left = rightChild;
            } else {
                parent.right = rightChild;
            }
        }

        rightChild.left = node;
    }

}
