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
public class MultiplyLists {
    public static void main (String[] args) throws FileNotFoundException, IOException {        
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;  
        
        while ((line = in.readLine()) != null) {
            String arrs[] = line.split(" \\| ");
            String arr1[] = arrs[0].split(" ");
            String arr2[] = arrs[1].split(" ");
            System.out.print(new Integer(arr1[0]) * new Integer(arr2[0]));
            for (int i = 1; i < arr1.length; i++) {                
                System.out.print(" " + (new Integer(arr1[i]) * new Integer(arr2[i])));
            }
            System.out.print("\n");
        }   
    }
}
