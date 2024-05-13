package sortingdemo;

public class InsertionSort {

    public static void insertionsort(int[] a) {
        int i, j, x;
        int n = a.length;
        for (i = 1; i < n; i++) {
            x = a[i];//rut la bai len
            j = i;//kiem tra la bai rut len
            while (j > 0 && x < a[j - 1]) {
                a[j] = a[j - 1];//dich la bai tao cho trong
                j--;//kiemtra den la bai truoc do
            }
            a[j] = x;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 3, 8, 1};
        insertionsort(a);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }
}
