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

/**
 *
 * @author Vald_ZX
 */
public class SetIntersection {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String [] arrays = line.split(";");
            ArrayList<Integer> list1 = new ArrayList();
            for (String str : arrays[0].split(",")) {
                list1.add(new Integer(str));
            }
            //ArrayList<Integer> result = new ArrayList();
            StringBuilder result = new StringBuilder();
            for (String str : arrays[1].split(",")) {
                int index = list1.indexOf(new Integer(str));
                if(index > -1)
                {
                    result.append(","+list1.get(index));
                }
            }
            if(result.length()>0)result.deleteCharAt(0);
            System.out.println(result);
        }        
     }
}
