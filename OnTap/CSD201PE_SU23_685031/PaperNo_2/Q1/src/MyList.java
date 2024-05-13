/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

	Node head, tail;

	MyList() {
		head = tail = null;
	}

	boolean isEmpty() {
		return (head == null);
	}

	void clear() {
		head = tail = null;
	}

	void fvisit(Node p, RandomAccessFile f) throws Exception {
		if (p != null) {
			f.writeBytes(p.info + " ");
		}
	}

	void ftraverse(RandomAccessFile f) throws Exception {
		Node p = head;
		while (p != null) {
			fvisit(p, f); // You will use this statement to write information of the node p to the file
			p = p.next;
		}
		f.writeBytes("\r\n");
	}

	void loadData(int k) { //do not edit this function
		String[] a = Lib.readLineToStrArray("data.txt", k);
		int[] b = Lib.readLineToIntArray("data.txt", k + 1);
		int[] c = Lib.readLineToIntArray("data.txt", k + 2);
		int n = a.length;
		for (int i = 0; i < n; i++) {
			addLast(a[i], b[i], c[i]);
		}
	}

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
	 */
	public void addLast(Boat x) {
		Node p = new Node(x);
		if (isEmpty()) {
			head = tail = p;
		} else {
			tail.next = p;
			tail = p;
		}
	}

	void addLast(String xSea, int xSail, int xPaddle) {
		//You should write here appropriate statements to complete this function.
		if (xSea.charAt(0) == 'B') {
			return;
		}
		addLast(new Boat(xSea, xSail, xPaddle));

	}

	//You do not need to edit this function. Your task is to complete the addLast function above only.
	void f1() throws Exception {
		clear();
		loadData(1);
		String fname = "f1.txt";
		File g123 = new File(fname);
		if (g123.exists()) {
			g123.delete();
		}
		RandomAccessFile f = new RandomAccessFile(fname, "rw");
		ftraverse(f);
		f.close();
	}

//==================================================================
	public void addFirst(Boat x) {
		Node p = new Node(x);
		if (isEmpty()) {
			head = tail = p;
		} else {
			p.next = head;
			head = p;
		}
	}

	void addAfter(Node p, Boat x) {
		Node p1 = new Node(x);
		if (isEmpty()) {
			return;
		}
		p1.next = p.next;
		p.next = p1;
		if (p == tail) {
			tail = p1;
		}
	}

	void insert(Boat x, int index) {
		int count = 0;
		Node p = head;
		while (p.next != null) {
			if (index == 0) {
				this.addFirst(x);
				break;
			}
			if (count == index - 1) {
				this.addAfter(p, x);
				break;
			}
			count++;
			p = p.next;
		}
	}

	void f2() throws Exception {
		clear();
		loadData(5);
		String fname = "f2.txt";
		File g123 = new File(fname);
		if (g123.exists()) {
			g123.delete();
		}
		RandomAccessFile f = new RandomAccessFile(fname, "rw");
		ftraverse(f);
		Boat x, y, z;
		x = new Boat("X", 1, 2);
		y = new Boat("Y", 2, 3);
		z = new Boat("Z", 3, 4);
		//------------------------------------------------------------------------------------
		/*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
		insert(x, 2);
		insert(y, 3);
		insert(z, 5);
		//------------------------------------------------------------------------------------
		ftraverse(f);
		f.close();
	}

//==================================================================
	public int max() {
		int max = Integer.MIN_VALUE;
		Node p = head;
		while (p != null) {
			if (p.info.sail > max) {
				max = p.info.sail;
			}
			p = p.next;
		}
		return max;
	}

	int count = 0;

	public Node searchf3(int max) {
		Node p = head;
		while (p != null) {
			if (p.info.sail == max) {
				count++;
				if (count == 2) {
					return p;
				}
			}
			p = p.next;
		}
		return null;
	}

	public void remove(Node p) {
		if (p == null) {
			return;
		}
		//find q where q.next = p
		Node f = head, q = null;
		while (f != null && f != p) {
			q = f;
			f = f.next;
		}
		//remove head
		if (q == null) {
			head = head.next;
			if (head == null) {
				tail = null;
			}
		} else {
			q.next = p.next;
			if (p == tail) {
				tail = q;
			}
		}
		p.next = null;
	}

	void f3() throws Exception {
		clear();
		loadData(9);
		String fname = "f3.txt";
		File g123 = new File(fname);
		if (g123.exists()) {
			g123.delete();
		}
		RandomAccessFile f = new RandomAccessFile(fname, "rw");
		ftraverse(f);
		//------------------------------------------------------------------------------------
		/*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
		int max = max();
		Node p = searchf3(max);
		remove(p);
		addFirst(p.info);

		//------------------------------------------------------------------------------------
		ftraverse(f);
		f.close();
	}

//==================================================================
	public int size() {
		Node p = head;
		int c = 0;
		while (p != null) {
			c++;
			p = p.next;
		}
		return c;
	}

	public Node get(int k) {
		Node p = head;
		int c = 0;
		while (p != null && c < k) {
			c++;
			p = p.next;
		}
		return p;
	}

	public void sortf4(int fro, int to) {
		int n = size();
		for (int i = fro; i < to - 1; i++) {
			for (int j = i + 1; j < to; j++) {
				Node pi = get(i), pj = get(j);
				if (pi.info.sail > pj.info.sail) {
					Boat t = pi.info;
					pi.info = pj.info;
					pj.info = t;
				}
			}
		}
	}

	void f4() throws Exception {
		clear();
		loadData(13);
		String fname = "f4.txt";
		File g123 = new File(fname);
		if (g123.exists()) {
			g123.delete();
		}
		RandomAccessFile f = new RandomAccessFile(fname, "rw");
		ftraverse(f);
		//------------------------------------------------------------------------------------
		/*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
		sortf4(2, 6);
		//------------------------------------------------------------------------------------
		ftraverse(f);
		f.close();
	}

}
