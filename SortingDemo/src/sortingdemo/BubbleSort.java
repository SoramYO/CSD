package sortingdemo;

public class BubbleSort {

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    //swap a[j] va a[i]
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 3, 8, 1};
        bubbleSort(a);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }
}
