/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_list;


public class DoubleLinkedQueue<T> extends DoublelyLinkedList<T>{
    public void enqueue(T data){
        addLast(data);
    }
    public T dequeue() throws Exception{
        return removeFirst();
    }
    public T front()throws Exception{
        if(isEmpty()) throw new Exception("Invalid operation");
        return header.next.getData();
    }
    public void clear() throws Exception{
        while(!isEmpty()) removeFirst();
    }
    public static void main(String[] args) throws Exception {
        DoubleLinkedQueue aq = new DoubleLinkedQueue();
        aq.enqueue("Phuc");
        aq.enqueue("An");
        aq.enqueue("Cac");
        aq.enqueue("Cho");
        aq.enqueue("Phai");
        aq.enqueue("Khong");
        aq.dequeue();
        aq.travesal();
        
    }
}
