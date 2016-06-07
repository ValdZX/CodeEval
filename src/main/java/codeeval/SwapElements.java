/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Vald_ZX
 */
public class SwapElements {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String [] temp = line.split(":");
            String [] arr = temp[0].split(" ");
            String [] swaps = temp[1].split(",");
            Integer [] mass = new Integer[arr.length];
            for (int i = 0; i < arr.length; i++) {
                mass[i] = new Integer(arr[i]);
            }
            for (int i = 0; i < swaps.length; i++) {
                int a =new Integer(swaps[i].substring(1, swaps[i].indexOf("-")));
                int b =new Integer(swaps[i].substring(swaps[i].indexOf("-") +1, swaps[i].length()));
                int tempNum = mass[a];
                mass[a] = mass[b];
                mass[b] = tempNum;
            }
            String result = "" + mass[0];
            for (int i = 1; i < mass.length; i++) {
                result+=" " + mass[i];
            }
            System.out.println(result);
        }      
    }
}
