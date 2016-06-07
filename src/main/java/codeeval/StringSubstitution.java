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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Vald_ZX 
 */
public class StringSubstitution {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            //System.out.println(line);
            HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
            String [] lines = line.split(";");
            String old = lines[0];
            String [] subStrs = lines[1].split(",");
            lines = null;
            
            for (int i = 0; i < subStrs.length - 1; i+=2) {
                List<Integer> offset = map.get(subStrs[i+1]);
                if(offset == null)
                {
                    offset = new ArrayList<Integer>();
                    map.put(subStrs[i+1], offset);
                }
                old = replaceString(old, subStrs[i], subStrs[i+1], map.get(subStrs[i]), offset);
            }
            System.out.println(old);
        }      
     }
    private static String replaceString(String aSearch, String aFind, String aReplace, List<Integer> offset, List<Integer> offsetNew) {
        String result = aSearch;
        if (result != null && result.length() > 0) {
            int b = 0;
            int a = 0;
            if(offset != null)
            {
                do
                {
                    b = a;
                    a = result.indexOf(aFind, b == 0? 0 : b + 1);
                }while(offset.indexOf(a) != -1);
            }
            else
            {
                a = result.indexOf(aFind);
            }
            if (a != -1) {
                result = result.substring(0, a) + aReplace + result.substring(a + aFind.length());
                offsetNew.add(a);
            }
        }
        return result;
    }
}
