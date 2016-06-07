/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

/**
 *
 * @author Vald_ZX
 */
public class FindAWriter {
     public static void main(String[] args) {
         String code = "3Kucdq9bfCEgZGF2nwx8UpzQJyHiOm0hoaYP6ST1WM7Nks5XjrR4IltBeDLV vA| 2 26 33 55 34 50 33 61 44 28 46 32 28 30 3 50 34 61 40 7 1 31";
         int s = code.indexOf('|');
         String data = code.substring(0, s);
         String nums = code.substring(s+2, code.length());
         String[] numsS = nums.split(" ");
         int[] numsI = new int[numsS.length];
         for (int i = 0; i < numsS.length; i++) {
             try {
                numsI[i] = Integer.parseInt(numsS[i]);
            } catch (NumberFormatException e) {
            }
         }
         StringBuilder res = new StringBuilder();
         for (int i : numsI) {
             res.append(data.charAt(i-1));
         }
         System.out.println(res.toString());
     }
}
