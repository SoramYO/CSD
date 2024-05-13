 
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
public class SinglyLinkedListCar {

    Node head,tail;

    public SinglyLinkedListCar() {
        head=tail=null;
    }
    boolean isEmpty(){
        return( head == null);
    }
    void clear() { head=tail=null;}
    
   public void addFirst (int xPrice,String xVendor,String xType) {
        Car data = new Car(xPrice,xVendor,xType);
        if (isEmpty()) {
            head = tail = new Node(data);
        }else {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
              
    }
   
    public void addLast (int xPrice,String xVendor,String xType) {
        Car data = new Car(xPrice,xVendor,xType);
        if (isEmpty()) {
            head = tail = new Node(data);
        }else {
            Node node = new Node(data);
            tail.next = node;
            tail = node;
        }
             
    }
    
    
   public Car removeFirst() throws Exception {
        if (head == null) {throw new Exception("Invailid operation");
        }
        Car data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;

        }
        return data;
    } 
   
   public Car removeLast() throws Exception {
        if (head == null) {throw new Exception("Invailid operation");
        }
        Car data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            Node curr = head;
            while (curr.next.next != null){
                curr = curr.next;}
            tail = curr;
            tail.next = null;
            }
                
            
            
        return data;
    } 
     public void traversal() {
        Node curr = head;
        int i = 1;
        while (curr != null) {
            String Car;
            System.out.println("Car" + i + "=" + curr.data);
            i++;
            curr = curr.next;
        }
    }       
            
    public static void main(String[] args) {
        try{
            SinglyLinkedListCar l = new SinglyLinkedListCar();
            l.addFirst(1900, "Vifast", "Sedan");
            l.addLast(2000, "Posche", "Sedan");
            l.addLast(3000, "VF6", "Tesla");
            l.removeFirst();
            l.removeLast();
            l.traversal();
        }catch( Exception e){
            e.printStackTrace();
        };
    }
    
}
