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
public class NumberPairs {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        int result = 0;
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        //1,2,3,4,6;5
        //2,4,5,6,9,11,15;20
        //1,2,3,4;50
        while ((line = in.readLine()) != null) {
            String [] lines = line.split(";");
            String [] numsStr = lines[0].split(",");
            int x = new Integer(lines[1]);
            lines = null;
            ArrayList<Integer> nums = new ArrayList();
            for (int i = 0; i < numsStr.length; i++) {
                nums.add(new Integer(numsStr[i]));
            }
            numsStr = null;
            ArrayList<Integer> list = new ArrayList();
            for (int i = 0; i < nums.size(); i++) {
                if(list.indexOf(i) != -1)
                    continue;
                int index = nums.indexOf(x - nums.get(i));
                if(index != -1)
                {
                    list.add(i);
                    list.add(index);
                }
            }
            if(list.size() > 0)
            {                 
                System.out.print(nums.get(list.get(0)) + "," + nums.get(list.get(1)));
                for (int i = 2; i < list.size(); i+=2) {   
                    System.out.print(";" + nums.get(list.get(i)) + "," + nums.get(list.get(i + 1)));
                }
                System.out.print("\n");
            }
            else
            {
                System.out.println("NULL");
            }
        }
     }
}
