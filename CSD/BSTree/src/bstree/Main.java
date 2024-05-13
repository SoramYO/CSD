package bstree;

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        int[] a = {1,4,5,6,3,7,8,2};
        tree.insert(a);

        System.out.println("Inorder traversal of the binary search tree:");
        tree.inorderTraversal();

        int keyToSearch = 6;
        if (tree.search(keyToSearch))
            System.out.println("\n" + keyToSearch + " found in the binary search tree.");
        else
            System.out.println("\n" + keyToSearch + " not found in the binary search tree.");

        int keyToDelete = 1;
        tree.delete(keyToDelete);
        tree.delete(4);
        System.out.println("\nInorder traversal after deleting " + keyToDelete + ":");
        tree.inorderTraversal();
    }
}