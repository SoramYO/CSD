/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xTower, int xSound, int xType) {
        //You should write here appropriate statements to complete this function.        
        if (xTower.charAt(0) == 'A') {

        } else {
            Bell x = new Bell(xTower, xSound, xType);
            Node newNode = new Node(x);
            if (isEmpty()) {
                head = tail = new Node(x);
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Bell x = new Bell("X", 1, 2);
        Bell y = new Bell("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node currentNode = head;
        int count = 0;
        while (count < 1 && currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        if (currentNode != null) {
            Node newNodeY = new Node(y);
            newNodeY.next = currentNode.next;
            currentNode.next = newNodeY;
        }

        currentNode = head;
        count = 0;
        while (count < 3 && currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        if (currentNode != null) {
            Node newNodeX = new Node(x);
            newNodeX.next = currentNode.next;
            currentNode.next = newNodeX;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        Node pre = null;
        int maxType = Integer.MIN_VALUE;
        while (cur != null && cur != tail) {
            if (cur.next.info.type > maxType) {
                maxType = cur.next.info.sound;
                pre = cur;
            }
            cur = cur.next;
        }
        if (pre != null && pre.next != null) {
            pre.next = pre.next.next;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node i = head;
        while (i.next.next.next.next != tail) {
            i = i.next;
        }
        Node j = null;
        Node stop = tail.next;
        Bell tmp;
        while (i != stop) {
            j = i.next;
            while (j != stop) {
                if (i.info.type < j.info.type) {
                    tmp = i.info;
                    i.info = j.info;
                    j.info = tmp;
                }
                j = j.next;
            }
            i = i.next;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
