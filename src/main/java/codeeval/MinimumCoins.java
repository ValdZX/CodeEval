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
public class MinimumCoins {
     public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int coins = Integer.valueOf(line);
            int m5 = coins/5;
            int m3 = (coins - m5*5) / 3;
            int m1 = coins - (m5*5 + m3*3);
            
            System.out.println(m1+m3+m5);
        }
     }
}
