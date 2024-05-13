/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_list;

/**
 *
 * @author PHUC NGUYEN
 */
class Node {
    Car data;
    Node next;
    
    Node(){
        
    }
    Node(Car x, Node p){
        data = x;
        next = p;
    }
    Node(Car x){
        this(x, null);
    }        
    
}
