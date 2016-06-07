/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Vald_ZX
 */
public class BeautifulStrings {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int result = 0;
            HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < line.length(); i++) {
                int t = (int)line.charAt(i);
                boolean flag = false;
                if(t >= 65 && t <= 90)
                {
                    t -= 64;
                    flag = true;
                }
                else if(t >= 97 && t <= 122)
                {
                    t -= 96;
                    flag = true;
                }
                if(flag)
                {
                    try {
                        int val = map.get(t);
                        map.put(t, ++val);
                    } catch (Exception e) {
                        map.put(t, 1);
                    }
                }                
            }
            Integer [] arr = new Integer[map.size()];
            map.values().toArray(arr);
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                result +=(27 - arr.length + i)* arr[i];
            }
            
            System.out.println(result);
        }      
     }
}
