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
public class Factorial {

    public static long fatorial (long n){
        if(n<2) {
            return n;
        }
        return n*fatorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("n!= " + fatorial(n));
    }
    
}
