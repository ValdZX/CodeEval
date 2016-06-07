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
import java.util.Map;

/**
 *
 * @author Vald_ZX
 */
public class TheMajorElement {
    public static void main (String[] args) throws FileNotFoundException, IOException {        
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;  
        next: while ((line = in.readLine()) != null) {
            HashMap<Integer, Integer> map = new HashMap();
            String[] strs = line.split(",");
            for (int i = 0; i < strs.length; i++) {
                Integer num = new Integer(strs[i]);
                Integer temp = map.get(num);
                if(temp != null)
                {
                    map.put(num, temp + 1);
                }
                else
                {
                    map.put(num, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer integer = entry.getKey();
                Integer integer1 = entry.getValue();
                if(integer1 >= strs.length/2)
                {
                    System.out.println(integer);
                    continue next;
                }
            }
            System.out.println("None");
        }   
    }
}
