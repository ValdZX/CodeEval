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
public class SwapCase {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("ABZ abz!");
        for (int i = 0; i < str.length(); i++) {
            int t = (int)str.charAt(i);
            if(t >= 65 && t <= 90)
            {
                str.setCharAt(i, (char)(t + 32));
            }
            else if(t >= 97 && t <= 122)
            {
                str.setCharAt(i, (char)(t - 32));
            }
        }
        System.out.println(str.toString());
    }
}
