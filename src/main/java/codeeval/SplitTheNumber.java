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
public class SplitTheNumber {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lines = line.split(" ");
            int sym = lines[1].indexOf("+");
            if(sym > -1)
            {
                int a = new Integer(lines[0].substring(0, sym));
                int b = new Integer(lines[0].substring(sym));
                System.out.println(a + b);
                continue;
            }
            
            sym = lines[1].indexOf("-");
            if(sym > -1)
            {
                int a = new Integer(lines[0].substring(0, sym));
                int b = new Integer(lines[0].substring(sym));
                System.out.println(a - b);
            }
        }
    }
}
