/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingdemo;

public class HeapSort {

    public static void heapify(int[] a, int n, int i) {
        int left = 2 * i + 1;//cho sao con ben trai
        int right = 2 * i + 2;//chi so con ban phai
        int largest = i;//chi so lon nat
        if (left < n && a[left] > a[largest]) {
            largest = left;
        }
        if (right < n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            //swap a[i] voi a [largest]
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, n, largest);//largest is i
        }
    }

    public static void heapSort(int[] a) {
        //buoc 1 heaptify mang a
        int n = a.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(a, n, i);
        }
        //buoc 2 bo phan tu dau tien ra sau cung va heaptify phan con lai cua mang
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 17, 13, 3, 8, 25};
        heapSort(a);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
