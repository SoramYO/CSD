/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_list;

import java.util.Scanner;

/**
 *
 * @author Son
 */
public class Fibonaci {

    public static long fibo(int n){
        if(n< 2) return n;
        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("n!= " + fibo(n));
    }
    
}
