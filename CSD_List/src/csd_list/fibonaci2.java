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
public class fibonaci2 {
    public static long[] fibo2 (int n){
        if( n<=1 ){
            long[] ans = {n, 0};
            return ans ;     
        }
        long[] temp = fibo2(n-1);
        long[] ans = {temp[0] + temp [1],temp[0]};
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("fibo ("+ n +") = " + fibo2(n)[0]);
    }
}
