/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_list;

/**
 *
 * @author Son
 */
public class DoubleLinkedStack<T> extends DoublelyLinkedList<T>{
    //top push pop clear top
    public void push(T data){
        //push tuong ung boi addLast
        addLast(data);
    }
    public T pop() throws Exception{
        //tuong ung voi remove last
        return removeLast();
    }
    public T top()throws Exception{
        if(isEmpty()) throw new Exception("Invalid Operation");
        return trailer.prev.getData();
    }
    public void clear() throws Exception{
        while(!isEmpty()){
            removeFirst();
        }
    }
    
    
    
    
    
    public static void main(String[] args) throws Exception {
        DoubleLinkedStack as = new DoubleLinkedStack();
        as.push("CSD201");
        as.push("PRO192");
        as.push("CVP301");
        as.pop();
        as.travesal();
    }
}
