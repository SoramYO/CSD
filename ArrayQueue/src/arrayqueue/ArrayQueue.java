/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayqueue;

import java.util.ArrayList;

/**
 *
 * @author Son
 * @param <T>
 */
public class ArrayQueue<T> {

    ArrayList<T> data = new ArrayList();

    //enqueue  dequeue isEmpty traversal front clear
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void clear() {
        data.clear();
    }

    public T front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Invalid Exception");
        }
        return data.get(0);
    }
    public void enqueue(T d){
        data.add(d);
    }
    public T dequeue()throws Exception{
        if (isEmpty()) {
            throw new Exception("Invalid Exception");
        }
        return data.remove(0);
    }
    public void traversal(){
        for(T x: data) System.out.println(x.toString()+ " ");
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue aq = new ArrayQueue();
        aq.enqueue("Phuc");
        aq.enqueue("An");
        aq.enqueue("Cac");
        aq.enqueue("Cho");
        aq.enqueue("Phai");
        aq.enqueue("Khong");
        aq.dequeue();
        aq.traversal();
        
    }

}
