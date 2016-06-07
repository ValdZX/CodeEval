/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval.easy;

import java.io.*;

public class BitPositions {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String [] strs = line.split(",");
            int x = new Integer(strs[0]);
            int a = new Integer(strs[1]);
            int b = new Integer(strs[2]);
            
            int ai = x >> (a - 1);
            ai &= 01;
            int bi = x >> (b - 1);
            bi &= 01;
            if(ai == bi)
                System.out.println(true);
            else
                System.out.println(false);
        }
     }
}
