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
 */
public class ArrayStack<T> {
    ArrayList<T> data = new ArrayList();
    //push pop top isEmpty clear traversal
    
    public boolean isEmpty(){
        return data.isEmpty();
    }
    public void clear(){
        data.clear();
    }
    public void push(T e){
        data.add(e);
    }
    public T pop() throws Exception{
        if(isEmpty()) throw new Exception("Invalid Operation");
        return data.remove(data.size()-1);//xoa phan tu cuoi cung va return gia tri
    }
    public T top(){
        return data.get(data.size()-1); //lay phan tu top cua stack
    }
    public void traversal(){
        for(T x:data){
            System.out.println(x.toString()+ " ");
        }
    }
    
    
    
    
    public static void main(String[] args) throws Exception {
        ArrayStack as = new ArrayStack();
        as.push("CSD201");
        as.push("PRO192");
        as.push("CVP301");
        as.pop();
        as.traversal();
    }
    
}
