/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Scanner;

/**
 *
 * @author Son
 */
public class BinarySearch {
static int cntBinary = 0, cntLinear = 0;
    public static int binarySearch(int[] a,int x, int start, int stop){
        cntBinary++;
        if (start >stop) return -1;//khong tim thay 
        //x trong a(base case)
        int mid=(start + stop )/ 2;// tim vi tri giua mang
        //can search
        if (a[mid]==x) return mid; //tim thay x trong mang a
        else if (a[mid]<x){
            //truong hop a[mid] < x
            //x nam ben phai cua a[mid] => start = mid +1
            return binarySearch(a, x, mid+1, stop);
        }
        else {
            //truong hop a[mid]>x
            //x nam ben trai cua a[mid] => stop = mid -1
            return binarySearch(a, x, start, mid-1);
        }
        
    }
    public static int linearSearch(int[] a, int x){
        for(int i = 0; i<a.length;i++){
            if (a[i] == x){
                return i;
            }
            cntLinear++;
            
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0;i < 100;i++){
            a[i] = i;
        }
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("Binary"+ binarySearch(a, x, 0, a.length-1) + "cntBinary"+ cntBinary);
        System.out.println("Linear"+ linearSearch(a, x)+ "cntLinear"+ cntLinear);
    }
    
}
