/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_list;

public class DoublelyLinkedList<T> {

    public static class Node<T> {

        T data;
        Node<T> prev;
        Node<T> next;

        @Override
        public String toString() {
            return data.toString();
        }

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }

    Node<T> header, trailer;
    int size;

    public DoublelyLinkedList() {
        //data , prev , next 
        header = new Node(null, null, null);
        //data , prev , next 
        trailer = new Node(null, header, null);
        header.next = trailer;
        size = 0;
    }

    //isEmpty, addFirst, addLast, removeFirst, removeLast, traversal
    public boolean isEmpty() {
        return size == 0;
    }

    private void addBetween(Node<T> predecessor, Node<T> x, Node<T> successor) {
        //Buoc 1 tao node x
        x.prev = predecessor;
        x.next = successor;
        //Buoc 2 noi next cua predecessor vao x
        predecessor.next = x;
        //Buoc 3 noi prev cua successor vao x
        successor.prev = x;

    }

    public void addFirst(T data) {
        //x them vao giua header va node dau tien trong danh sach
        Node<T> x = new Node<T>(data);
        addBetween(header, x, header.next);
        size++;
    }

    public void addLast(T data) {
        Node<T> x = new Node<T>(data);
        addBetween(trailer.prev, x, trailer);
        size++;
    }

    public T removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Invalid operation");
        }
        Node<T> first = header.next;
        T data = first.getData(); //lay du lieu cua next
        header.next = first.next;
        first.next.prev = header;
        size--;
        return data;
    }

    public T removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Invalid operation");
        }
        Node<T> last = trailer.prev;
        T data = last.getData();
        //to do
        
        Node<T> tail = trailer.prev;
        Node<T> preTail = tail.prev;
        preTail.next = trailer;
        trailer.prev = preTail;
        tail = null;
        size--;
        return data;
    }

    public void travesal() {
        if(isEmpty()){
            return;
        }
        Node<T> curr = header.next;
        for (int i = 0; i < size; i++) {
            System.out.print(curr + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) throws Exception {      
        DoublelyLinkedList<String> dl = new DoublelyLinkedList();
        dl.addFirst("1"); //1
        dl.addLast("5");// 1  5
        dl.addFirst("3"); // 3 1 5
        dl.addLast("2"); // 3  1  5 2
        dl.removeFirst();  // 1 5 2
        dl.removeLast(); // 1  5
        dl.travesal();
    }

}
