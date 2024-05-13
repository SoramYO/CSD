/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Queue {
    //Linked Queue (FIFO)
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this(data,null);
        }
        public Node(int data, Node next){
            this.data=data;
            this.next=next;
        }  
    }
    ///////Queue's function///////
    Node front, rear;
    //enqueue, dequeue, front, rear
    public void enqueue(int data){
        if(front==null) front = rear = new Node(data);
        else{
            rear.next = new Node(data); //Đuôi cũ.next = node mới
            rear = rear.next; //Đuôi mới
        }
    }
    public Node dequeue(){
        if(front==null) return null;
        else if(front==rear){
            //queue chi co 1 node
            Node deletedNode = front;
            front=rear=null;
            return deletedNode;
        }else{
            Node deletedNode = front;
            front = front.next;
            return deletedNode;
        }
    }
    public Node front(){
        return front;
    }
    public void traversal(){
        Node curr = front;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;         
        }
    }
    public static void main(String[] args){
        Queue q = new Queue();
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        System.out.println("q.dequeue()"+q.dequeue().data);
        q.enqueue(3);
        System.out.println("q.dequeue()"+q.dequeue().data);
        q.enqueue(4);
        q.enqueue(5);
        q.traversal();
    }
    
}
