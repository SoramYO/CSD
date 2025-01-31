package bstree;

class BST {

    Node root;

    BST() {
        root = null;
    }

    void insert(int a[]) {
        for (int i = 0; i < a.length; i++) {
            root = insertRecursive(root, a[i]);
        }
    }

    void insert(int key) {
        root = insertRecursive(root, key);

    }

    private Node insertRecursive(Node root, int key) {  //different root*

        if (root == null) { //if isEmpty
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    private void inorderTraversalRecursive(Node root) {
        if (root != null) {
            inorderTraversalRecursive(root.left);
            System.out.print(root.key + " ");
            inorderTraversalRecursive(root.right);
        }
    }

    boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node root, int key) {
        if (root == null || root.key == key) {
            return root != null;
        }

        if (key < root.key) {
            return searchRecursive(root.left, key);
        } else {
            return searchRecursive(root.right, key);
        }
    }

    void delete(int key) {
        root = deleteRecursive(root, key);
    }

    Node deleteRecursive(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key == root.key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRecursive(root.right, root.key);

        } else if (key > root.key) {
            root.right = deleteRecursive(root.right, key);
        } else {
            root.left = deleteRecursive(root.left, key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }
}
