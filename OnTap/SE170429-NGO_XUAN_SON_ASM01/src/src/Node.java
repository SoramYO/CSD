// =========================================================
// Do NOT modify this file 
// =========================================================

class Node{
    private Student data;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Student x, Node p) {
        this.data = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (Student x) {
        this(x,null);
    }
    
    public Student getData() {
        return this.data;
    }
    
    public void setData(Student student) {
        this.data = student;
    }
 }

