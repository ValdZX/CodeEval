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
public class MultiplicationTables {
    public static void main (String[] args) {
        for (int i = 1; i < 13; i++) {
            System.out.print(i);
            for (int j = 2; j < 13; j++) {
                System.out.printf("%4d", i*j);
            }
            System.out.print("\n");
        }
     }
}
