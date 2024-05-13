/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

	Node root;

	BSTree() {
		root = null;
	}

	boolean isEmpty() {
		return (root == null);
	}

	void clear() {
		root = null;
	}

	void visit(Node p) {
		System.out.print("p.info: ");
		if (p != null) {
			System.out.println(p.info + " ");
		}
	}

	void fvisit(Node p, RandomAccessFile f) throws Exception {
		if (p != null) {
			f.writeBytes(p.info + " ");
		}
	}

	void breadth(Node p, RandomAccessFile f) throws Exception {
		if (p == null) {
			return;
		}
		Queue q = new Queue();
		q.enqueue(p);
		Node r;
		while (!q.isEmpty()) {
			r = q.dequeue();
			fvisit(r, f);
			if (r.left != null) {
				q.enqueue(r.left);
			}
			if (r.right != null) {
				q.enqueue(r.right);
			}
		}
	}

	void preOrder(Node p, RandomAccessFile f) throws Exception {
		if (p == null) {
			return;
		}
		fvisit(p, f);
		preOrder(p.left, f);
		preOrder(p.right, f);
	}

	void inOrder(Node p, RandomAccessFile f) throws Exception {
		if (p == null) {
			return;
		}
		inOrder(p.left, f);
		fvisit(p, f);
		inOrder(p.right, f);
	}

	void postOrder(Node p, RandomAccessFile f) throws Exception {
		if (p == null) {
			return;
		}
		postOrder(p.left, f);
		postOrder(p.right, f);
		fvisit(p, f);
	}

	void loadData(int k) { //do not edit this function
		String[] a = Lib.readLineToStrArray("data.txt", k);
		int[] b = Lib.readLineToIntArray("data.txt", k + 1);
		int[] c = Lib.readLineToIntArray("data.txt", k + 2);
		int n = a.length;
		for (int i = 0; i < n; i++) {
			insert(a[i], b[i], c[i]);
		}
	}

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
	public void insert(Boat x) {
		Node p = new Node(x);
		Node f = null, q = root;
		while (q != null) {
			if (q.info.sail == x.sail) {
				return;
			}
			if (q.info.sail < x.sail) {
				f = q;
				q = q.right;
			} else {
				f = q;
				q = q.left;
			}
		}
		if (f == null) {
			root = p;
		} else if (p.info.sail > f.info.sail) {
			f.right = p;
		} else {
			f.left = p;
		}
	}

	void insert(String xSea, int xSail, int xPaddle) {
		//You should insert here statements to complete this function
		if (xSea.charAt(0) == 'B') {
			return;
		}
		insert(new Boat(xSea, xSail, xPaddle));
	}

//Do not edit this function. Your task is to complete insert function above only.
	void f1() throws Exception {
		clear();
		loadData(1);
		String fname = "f1.txt";
		File g123 = new File(fname);
		if (g123.exists()) {
			g123.delete();
		}
		RandomAccessFile f = new RandomAccessFile(fname, "rw");
		breadth(root, f);
		f.writeBytes("\r\n");
		inOrder(root, f);
		f.writeBytes("\r\n");
		f.close();
	}

//=============================================================
	void breadth2(Node p, RandomAccessFile f) throws Exception {
		if (p == null) {
			return;
		}
		Queue q = new Queue();
		q.enqueue(p);
		Node r;
		while (!q.isEmpty()) {
			r = q.dequeue();
			if (r.info.paddle > 5) {
				fvisit(r, f);
			}
			if (r.left != null) {
				q.enqueue(r.left);
			}
			if (r.right != null) {
				q.enqueue(r.right);
			}
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
		breadth(root, f);
		f.writeBytes("\r\n");
		//------------------------------------------------------------------------------------
		/*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
		breadth2(root, f);
		//------------------------------------------------------------------------------------
		f.writeBytes("\r\n");
		f.close();
	}

//=============================================================
	public Node search(Node p, int key) {
		if (p == null) {
			return null;
		}
		if (p.info.sail == key) {
			return p;
		} else if (p.info.sail > key) {
			return search(p.left, key);
		} else {
			return search(p.right, key);
		}
	}

	public void deleteByCopy(int x) { // x = sail
		Node p = search(root, x);
		if (p == null) {
			System.out.println("Key " + x + " does not exists, deletion failed");
			return;
		}
		//find f is father of p
		Node f = null, q = root;
		while (q != p) {
			f = q;
			if (q.info.sail > p.info.sail) {
				q = q.left;
			} else {
				q = q.right;
			}
		}
		//1.p has no child
		if (p.left == null && p.right == null) {
			if (f == null) {
				root = null;
			} else if (f.left == p) {
				f.left = null;
			} else {
				f.right = null;
			}
		} //2.p has left child only
		else if (p.left != null && p.right == null) {
			if (f == null) {
				root = p.left;
			} else if (f.left == p) {
				f.left = p.left;
			} else {
				f.right = p.left;
			}
		} //3.p has right child only
		else if (p.left == null && p.right != null) {
			if (f == null) {
				root = p.right;
			} else if (f.left == p) {
				f.left = p.right;
			} else {
				f.right = p.right;
			}
		} //4.p has both child
		else if (p.left != null && p.right != null) {
			//tim q la node lon nhat ben con trai cua p -> q la con phai nhat
			//cua con trai cua p
			q = p.left;
			f = null;
			while (q.right != null) {
				f = q;
				q = q.right;
			}
			p.info = q.info;
			//delete q
			if (f == null) {
				p.left = q.left;
			} else {
				f.right = q.left;
			}
		}
	}
	int count3 = 0;

	void inOrder2(Node p, RandomAccessFile f) throws Exception {
		if (p == null) {
			return;
		}
		inOrder2(p.left, f);
		if (p.left != null) {
			count3++;
			if (count3 == 2) {
				Node q = p.left;
				deleteByCopy(q.info.sail);
			}
		}
		inOrder2(p.right, f);
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
		breadth(root, f);
		f.writeBytes("\r\n");
		//------------------------------------------------------------------------------------
		/*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
		inOrder2(root, f);
		//------------------------------------------------------------------------------------
		breadth(root, f);
		f.writeBytes("\r\n");
		f.close();
	}

//=============================================================
	int count4 = 0;

	Node rotateRight(Node p) {
		if (p == null || p.left == null) {
			return (p);
		}
		Node q = p.left;
		p.left = q.right;
		q.right = p;
		return (q);
	}

	void inOrder4(Node p, RandomAccessFile f) throws Exception {
		if (p == null) {
			return;
		}
		inOrder4(p.left, f);
		if (p.left != null) {
			count4++;
			if (count4 == 2) {
				Node parent = findParent(root, p);
				if (parent.left.info.sail== p.info.sail) {
					parent.left = p.left;
					parent.left.right = p;
					p.left = null;
				} else {

					System.out.println("-");
					parent.right = p.left;
					parent.right.right = p;
					p.left = null;
				}
			}

		}

		inOrder4(p.right, f);
	}

	Node findParent(Node root, Node child) {
		if (root == null || root == child) {
			return null;
		}
		if (root.left == child || root.right == child) {
			return root;
		}
		Node parent = findParent(root.left, child);
		if (parent != null) {
			return parent;
		}

		// Recursive case: Search for the parent in the right subtree
		parent = findParent(root.right, child);
		return parent;
	}

	void f4() throws Exception {
		clear();
		loadData(13);;
		String fname = "f4.txt";
		File g123 = new File(fname);
		if (g123.exists()) {
			g123.delete();
		}
		RandomAccessFile f = new RandomAccessFile(fname, "rw");
		breadth(root, f);
		f.writeBytes("\r\n");
		//------------------------------------------------------------------------------------
		/*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
		inOrder4(root, f);
		//------------------------------------------------------------------------------------
		breadth(root, f);
		f.writeBytes("\r\n");
		f.close();
	}

}
