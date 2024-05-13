/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

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

    void loadData(int k) { //do not edit this function
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
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xMaker, int xType, int xRadius) {
        //You should write here appropriate statements to complete this function.
        if (xMaker.charAt(0) == 'B') {
            return;
        }
        Node newNode = new Node(new Ball(xMaker, xType, xRadius));
        if (head == null) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
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
        Ball x, y;
        x = new Ball("X", 1, 2);
        y = new Ball("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node tam = head.next.next;
        head.next.next = new Node(x);
        head.next.next.next = new Node(y);
        head.next.next.next.next = tam;

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
        //Delete the second maximum element
        Node prev = null;
        Node current = head;
        int count = 0;
        int max = Integer.MIN_VALUE;

        while (current != null) {
            if (current.info.type > max) {
                max = current.info.type;
                prev = current;
                count = 1;
            } else if (current.info.type == max) {
                count++;
            }

            if (count == 2) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                break;
            }

            prev = current;
            current = current.next;
        }
 //-------------------------------------------------------------------------------------------
 //Delete by condition and value anf visit
//          Node prev = null;
//        Node current = head;
////        int count = 0;
//        while (current != null) {
//            if (current.info.price == 5) {
////                count++;
//                if (prev == null) {
//                    head = current.next;
//                } else {
////                    if (count == 2) {
//                    prev.next = current.next;
////                        break;
////                    }
//                }
//                break;
//            }
//            prev = current;
//            current = current.next;
//        }
//       //red point when delete difference the first element
//--------------------------------------------------------------------------------------------
////Delete with conditions
// Node current = head;
//        while (current != null) {
//            if (current.next.info.price < 6) {
//                current.next = current.next.next;
//                break;
//            }
//            current = current.next;
//        }


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
        Node n1 = head;
        Node n2 = head.next;
        Node n3 = n2.next;
        Node n4 = n3.next;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (n1.info.type < n2.info.type) {
                    Ball tam = n1.info;
                    n1.info = n2.info;
                    n2.info = tam;
                }
                if (n2.info.type < n3.info.type) {
                    Ball tam = n2.info;
                    n2.info = n3.info;
                    n3.info = tam;
                }
                if (n3.info.type < n4.info.type) {
                    Ball tam = n3.info;
                    n3.info = n4.info;
                    n4.info = tam;
                }

            }

        }
        //Sap all
//                boolean swap;
//        do {
//            swap = false;
//            Node current = head;
//            Node prev = null;
//            while (current != null && current.next != null) {
//                if (current.info.type > current.next.info.type) {
//                    Node tmp = current.next;
//                    current.next = tmp.next;
//                    tmp.next = current;
//                    if (prev == null) {
//                        head = tmp;
//                    } else {
//                        prev.next = tmp;
//                    }
//                    prev = tmp;
//                    swap = true;
//                } else {
//                    prev = current;
//                    current = current.next;
//                }
//
//            }
//        } while (swap);


        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
   // ------------------------------------------------------------------------------------------------------------
    //addFirst
    void addFirst(String xMaker, int xType, int xRadius) {
    if (xMaker.charAt(0) == 'B') {
        return; 
    }
    Node newNode = new Node(new Ball(xMaker, xType, xRadius));
    newNode.next = head; 
    head = newNode; 
    if (tail == null) {
        tail = head; 
    }
}
    
    
    //------------------------------------------------------------------------------------------------------------

}
