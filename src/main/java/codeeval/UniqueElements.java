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
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Vald_ZX
 */
public class UniqueElements {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String [] nums = line.split(",");
            HashSet<Integer> setter = new HashSet<Integer>();
            for (String str : nums) {
                setter.add(new Integer(str));
            }
            Integer [] arr = new Integer[setter.size()];
            setter.toArray(arr);
            Arrays.sort(arr);
            StringBuilder result =new StringBuilder(arr[0].toString());
            for (int i = 1; i < arr.length; i++) {
                result.append("," + arr[i]);
            }
            System.out.println(result);
        }        
     }
}
