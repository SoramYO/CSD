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
public class Dec2Binary {

    public static void dec2bin(int n){
        int q = n/2;
        int r = n-q*2;
        if(q!=0) dec2bin(q);
        System.out.print(r + "");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n ");
        int n = sc.nextInt();
        dec2bin(n);
    }
    
}
