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
import java.util.ArrayList;

/**
 *
 * @author Vald_ZX
 */
public class CompressedSequence {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String [] temp = line.split(" ");
            ArrayList<Integer> list = new ArrayList<Integer>();
            int index = 0;
            int currentNum = new Integer(temp[0]);
            for (String str : temp) {
                int tempNum = new Integer(str);
                if(currentNum == tempNum)
                {
                    index++;
                }           
                else
                {
                    list.add(index);
                    list.add(currentNum);
                    index = 1;
                    currentNum = tempNum;
                }
            }
            list.add(index);
            list.add(currentNum);
           
            String result = "" +list.get(0);
            for (int i = 1; i < list.size(); i++) {
                result +=" " + list.get(i);
                
            }
            System.out.println(result);
        }      
    }
}
