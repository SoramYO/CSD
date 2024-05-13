package csd_list;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Son
 */
public class CheckPrime {

    public int f1(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isPrimeDigit(c)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimeDigit(char c) {
        int digit = Character.getNumericValue(c);
        return digit == 2 || digit == 3 || digit == 5 || digit == 7;
    }

    public String f2(String str) {
        String[] words = str.split(" ");
        StringBuilder reversed = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            reversed.insert(0, words[i]);
            if (i < words.length - 1) {
                reversed.insert(0, " ");
            }
        }
        return reversed.toString();
    }

}
//public class MyString implements IString {
//
//    @Override
//    public int f1(String str) {
//        int count = 0;
//        int size = str.length();
//        int number = 0;
//        boolean OK = false;
//        for (int i = 0; i < size; i++) {
//            //            String s = str.charAt(i) + "";
//            char c = str.charAt(i);
//            try {
//                number = Character.getNumericValue(c);
//                OK = checkPrime(number);
//                if (OK) {
//                    count++;
//                }
//            } catch (Exception e) {
//                continue;
//            }
//        }
//        return count;
//    }
//
//
//    public boolean checkPrime(int number) {
//        if (number <= 1) {
//            return false;
//        }
//        for (int i = 2; i <= Math.sqrt(number); i++) {
//            if (number % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
