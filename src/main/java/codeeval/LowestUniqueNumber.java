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
import java.util.HashMap;

/**
 *
 * @author Vald_ZX
 */
public class LowestUniqueNumber {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String [] strs = line.split(" ");
            Integer [] arr = new Integer[strs.length];
            HashMap<Integer, Boolean> set = new HashMap<Integer, Boolean>();
            for (int i = 0; i < strs.length; i++) {
                arr[i] = new Integer(strs[i]);
                if(set.get(arr[i]) == null)
                    set.put(arr[i], false);
                else
                    set.put(arr[i], true);
            }
            
            int min = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                if(set.get(arr[i]) == false)
                {
                    if(min > arr[i]){
                        result = i+1;
                        min = arr[i];
                    }
                }
            }
                System.out.println(result);
        }      
    }
}
