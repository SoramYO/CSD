/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Son
 */
public class QuickSort {

    public static List<Integer> QuickSort(List<Integer> a) {
        if (a.size() == 0) {
            return new ArrayList();
        }
        if (a.size() == 1) {
            return a;
        }
        int pivot = a.get(0);
        ArrayList<Integer> high = new ArrayList();
        ArrayList<Integer> low = new ArrayList();
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > pivot) {
                high.add(a.get(i));
            } else {
                low.add(a.get(i));
            }
        }
        List<Integer> l = QuickSort(low);
        List<Integer> h = QuickSort(high);
        l.add(pivot);
        l.addAll(h);
        return l;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void quickSort2(int[] a, int first, int last) {
        if (first >= last) {
            return;
        }
        int pivotIdx = partition2(a, first, last);
        quickSort2(a, first, pivotIdx - 1);//de qyu trai
        quickSort2(a, pivotIdx + 1, last);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }

    public static int partition2(int[] a, int first, int last) {
        int up = first, down = last, pivot = a[first];
        //bu∞c 1: tang up cho den Khi gap phan tu dau tien Ion hon pivot
        do {
            while (a[up] <= pivot) {
                up++;
            }
            //buoc 2: giam down cho den khi gap phan tu dau tien nho hon pivot
            while (a[down] > pivot) {
                down--;
            }
            //buoc 3: neu nhu up < down: swap a [up) &-)
            // neu up >=down: swap a[first]<=>a [down] return down
            if (up < down) {
                int temp = a[up];
                a[up] = a[down];
                a[down] = temp;
            }
        } while (up < down);
        int temp = a[first];//pivot
        a[first] = a[down];
        a[down] = temp;
        return down;//pivotIdx
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList(Arrays.asList(4, 2, 6, 9, 3));
        int[] arr = {10, 7, 8, 9, 1, 5};
        int N = arr.length;

        quickSort(arr, 0, N - 1);
        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + ",");
        }

        int[] b = {4,2, 6,9,3, 0, 10, -5, 20, 100};
        quickSort2(b, N, N);
        System.out.println("\n");
        for (int z : b) {
            System.out.print(z + ",");
        }
        a = QuickSort(a);
        System.out.println("\n" + a);
    }
}
