
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    // Default constructor
    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.getData() + " "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    public void traversal() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * Do NOT modify this method Load 3 lines of data from file: line k (for
     * district), line k+1 (for price), and line k+2 (for area)
     *
     * @param k the k-th line where data is started to be loaded
     */
    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;

        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);// insert the new Node(a[i], b[i], c[i]) into the list
        }
    }

    /**
     * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh Error
     * khi run chuong trinh. 2. Neu khong tuan thu se nhan diem 0 (khong).
     *
     * Question 1.1: implement the 'addLast' method that inserts a new Node into
     * the list's tail if the attributes of a new Student satisfies: 'grade'>=0
     * && 'grade'<=10. The output of this method will be written into the file
     * 'f1.txt'. Therefore you should open this file to see/test your code
     * output. Example: with the content given in the file 'data.txt', the
     * content of 'f1.txt' after insertion should be (B,5,3) (C,6,5) (E,1,1)
     * (G,70,9) (P,4,7) @param xName name of the inputted Student @param xAge
     * age of the inputted Student @param xGrade grade of the inputted Student
     */
    void addLast(String xName, int xAge, int xGrade) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (xGrade >= 0 && xGrade <= 10) {
            Student x = new Student(xName, xAge, xGrade);
            Node newNode = new Node(x);
            if (isEmpty()) {
                head = tail = new Node(x);
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    /**
     * Do NOT modify this method This is a helper method for writing data
     * (node's info) stored in the linked list to file
     *
     * @throws Exception
     */
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

    // This method is used for Question 1.2
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        System.out.println("Input:");
        traversal();
        /**
         * Question 1.2: With all Student's names contains letter "u" or "U",
         * decrease age by 3 (age=age-3), if ***age*** is less than zero,
         * ***age*** should be 0 (if(age<0) then age=0).
         *
         * The output of this method will be written into the file 'f2.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before change is (ou,9,8) (Uu,1,3)
         * (xX,8,5) (TT,5,4) (ER,4,9) then the content of 'f2.txt' after change
         * is (ou,6,8) (Uu,0,3) (xX,8,5) (TT,5,4) (ER,4,9) the changed nodes
         * are: (ou,6,8) (Uu,0,3)
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Node currentNode = head;
        while (currentNode != null) {
            Student student = currentNode.getData();
            if (student.getName().contains("u") || student.getName().contains("U")) {
                int newAge = student.getAge() - 3;
                if (newAge < 0) {
                    student.setAge(0);
                } else {
                    student.setAge(newAge);
                }
            }
            currentNode = currentNode.next;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 1.3
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        System.out.println("Input:");
        traversal();
        /**
         * Question 1.3: Remove last Student if possible.
         *
         * The output of this method will be written into the file 'f3.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list is (1,9,8) (4,5,3) (6,6,5) (0,1,1)
         * (1,7,9) (4,4,7) (7,3,2) (xxx,3,9) then the content of 'f3.txt' is
         * (1,9,8) (4,5,3) (6,6,5) (0,1,1) (1,7,9) (4,4,7) (7,3,2)
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (head == null) {
            throw new Exception("Invalid operation");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node preTail = null;
            Node curr = head;

            while (curr != tail) {
                preTail = curr;
                curr = curr.next;
            }
            tail = preTail;
            tail.next = null;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 1.4
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        System.out.println("Input:");
        traversal();
        /**
         * Question 1.4: Sort the linked list in an descending order according
         * to Student's grade, if more than one Student have the same grade, you
         * should sort in an ascending order by their names. The output of this
         * method will be written into the file 'f4.txt'. Therefore you should
         * open this file to see/test your code output. Example: if the linked
         * list before sorting is (A,9,8) (D,5,3) (C,6,3) (E,1,7) (F,7,7)
         * (G,4,7) (I,2,2) (H,3,2) then the content of 'f4.txt' after sorting is
         * (A,9,8) (E,1,7) (F,7,7) (G,4,7) (C,6,3) (D,5,3) (H,3,2) (I,2,2)
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                Student currentStudent = current.getData();
                Student nextStudent = current.next.getData();
                if (currentStudent.getGrade() < nextStudent.getGrade()
                        || (currentStudent.getGrade() == nextStudent.getGrade()
                        && currentStudent.getName().compareTo(nextStudent.getName()) > 0)) {
                    Student temp = currentStudent;
                    current.setData(nextStudent);
                    current.next.setData(temp);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 1.5
    void f5() throws Exception {
        clear();
        loadData(13);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        System.out.println("Input:");
        traversal();
        /**
         * Question 1.5: Revert the linked list. The output of this method will
         * be written into the file 'f4.txt'. Therefore you should open this
         * file to see/test your code output. Example: if the linked list before
         * sorting is (A,9,8) (D,5,3) (C,6,3) (E,1,7) (F,7,7) (G,4,7) (I,2,2)
         * (H,3,2) then the content of 'f4.txt' after sorting is (H,3,2) (I,2,2)
         * (G,4,7) (F,7,7) (E,1,7) (C,6,3) (D,5,3) (A,9,8)
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
