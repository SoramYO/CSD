/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingdemo;

/**
 *
 * @author Son
 */
public class MergeSort {

    public static void mergeSort(int[] a, int p, int r) {
        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSort(a, p, q);//chia ben trai
        mergeSort(a, q + 1, r);
        merge(a, p, q, r);
    }

    public static void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0, n = r - p + 1;
        int[] b = new int[n];
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        while (i <= q) {
            b[k++] = a[i++];
        }
        while (j <= r) {
            b[k++] = a[j++];
        }
        //copy b vao a theo thu tu
        for (i = p, k = 0; i <= r; i++, k++) {
            a[i] = b[k];
        }
    }
    public static void main (String [] args){
        int [] a ={1,0,9,2,6,8,7,5,3,4};
        mergeSort(a, 0, a.length-1);
        for(int x: a){
            System.out.print(x+" ");
        }
    }
}
