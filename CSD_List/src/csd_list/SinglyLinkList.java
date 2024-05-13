package csd_list;

public class SinglyLinkList {
// Khai bao cac node cua danh sach lien ket 

    class Node {

        int data; // data of node
        Node next; // link to next node

        Node() {
        }

        public Node(int data) {
            this(data, null);
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "=>" + data;
        }

    }
    //Khai bao cac bien cho lien ket
    Node head = null, tail = null;//2 node dau cuoi
    // addFirst, addLast, removeFirst,removeLast, isEmpty, traversal

    public void addFirst(int x) {
        if (head != null) {
            head = new Node(x, head);
            // tao 1 node moi
            // next cua node moi la head hien tai
            // nap head moi thanh node moi     
        } else {
            // Chua co node nao
            head = tail = new Node(x);
        }
    }

    public void addLast(int x) {
        Node newNode = new Node(x); // tao node
        if (tail != null) {
            // noi next cua tail vao newnext
            // nap newnext thanh new moi
            tail.next = newNode;
            tail = newNode;
        } else {
            head = tail = new Node(x);
        }
    }

    public void traversal() {
        // in ra tat ca ca phan tu
        Node current = head;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
    }

    public int removeFirst() throws Exception {
        int data = head.data; //lay du lieu tra ve
        if (head == null) { // neu rong thi throw exception
            throw new Exception("Invalid operation");
        }
        if (head == tail) {// neu co 1 phan tu phai xoa ca tail lan head
            head = tail = null;
        } else { //neu nhieu hon 1 phan tu thi chi can xoa head
            head = head.next;// di chuyen head toi phan tu tiep theo
        }
        //xoa phan tu dau tien  
        return data;// tra ve du lieu
    }

    public int removeLast() throws Exception {
        int data = head.data; //lay du lieu tra ve
        if (head == null) { // neu rong thi throw exception
            throw new Exception("Invalid operation");
        }
        if (head == tail) {// neu co 1 phan tu phai xoa ca tail lan head
            head = tail = null;
        } else { //neu nhieu hon 1 phan tu thi chi can xoa head
            Node preTail = null;
            Node curr = head;
            //tim kiem pretail
            while (curr != tail) { //khi nao toi tail thi dung
                preTail = curr; //luu bien truoc tail
                curr = curr.next;
            }// di chuyen head toi phan tu tiep theo
            tail = preTail; //tail moi
            tail.next = null; //next cua tail moi la null
        }
        return data;// tra ve du lieu
    }

    public static void main(String[] args) {
        try {
            SinglyLinkList l = new SinglyLinkList();
            l.addFirst(0);
            l.addFirst(2);
            l.addLast(1);
            l.addLast(3);
            l.removeFirst();
            l.addFirst(5);
            l.removeLast();
            l.traversal();
        } catch (Exception e) {

        };
    }
}
