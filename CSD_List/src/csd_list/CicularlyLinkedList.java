package csd_list;

//arraylist<car> x = new arraylist();
//Node {Object data}
public class CicularlyLinkedList<E> {

    //Define node
    public static class Node<E> {

        E data;
        Node<E> next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data + " ";
        }

    }
    //Define variables of cicularlinklist
    Node<E> tail;
    int size = 0;//dem so luong phan tu

    public boolean isEmpty() {
        return size == 0; //kiem tra list co phan tu khong
    }

    public void addFirst(E data) {
        if (!isEmpty()) {
            //them phan tu data kieu e vao dau danh sach lien ket
            //Buoc 1 tao node moi
            //toi head hien tai cua danh sach
            Node<E> newNode = new Node(data, tail.next);
            //Buoc 2 noi tail.next vao newnode
            tail.next = newNode;
        } else {
            //chua co phan tu nao
            tail = new Node(data, null);
            tail.next = tail;
        }
        size++;//tang so luong code len 1 don vi
    }

    public void addLast(E data) {
        if (!isEmpty()) {
            //tao new node noi vao head
            Node<E> newNode = new Node(data, tail.next);
            //noi duoi cu vao duoi moi
            tail.next = newNode;
            //cap nhat vao duoi moi
            tail = newNode;
        } else {
            tail = new Node(data, null);
            tail.next = tail;
        }
        size++;
    }

    public E removeFirst() throws Exception {
        if (!isEmpty()) {
            throw new Exception("Invalid operation");
        }
        E data = tail.next.getData();
        if (size == 1) {
            //khi co 1 node thi xoa node
            tail = null;
        } else {
            tail.setNext(tail.getNext().getNext());
        }
        size--;
        return data;
    }

    public E removeLast() throws Exception {
        if (!isEmpty()) {
            throw new Exception("Invalid operation");
        }
        E data = tail.getData();
        if (size == 1) {
            tail = null;
        } else {
            Node<E> curr = tail.next, preTail = null;
            while (curr != tail) {
                preTail = curr;
                curr = curr.next;
            }
            preTail.next = tail.next; //noi pretail cho head
            tail = preTail;
        }
        size--;
        return data;
    }

    public void rotate() throws Exception {
        if (isEmpty()) {
            throw new Exception("Invalid operation");
        }

        tail = tail.next; //di chuyen node dautien ra sau cung

    }

    public void printList() {
        Node<E> curr = tail.next;
        for (int i = 0; i < size; i++) {
            System.out.print(curr + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            CicularlyLinkedList<String> cl = new CicularlyLinkedList();
            cl.addLast("Hieu");
            cl.addLast("dep");
            cl.addLast("trai");
            cl.addLast("khoai");
            cl.addLast("to");
            cl.rotate();
            cl.printList();
        } catch (Exception e) {

        }
    }

}
