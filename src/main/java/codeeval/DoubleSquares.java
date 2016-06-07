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
public class DoubleSquares {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int num = new Integer(line);
            int count = (int)Math.round(Math.sqrt(num));
            int numD2 = num/2;
            int result = 0;
            int pl = 0;
            for (int i = 0; i <= numD2; i++) {
                int j = (int)Math.round(Math.sqrt(num - i * i));
                for (; j >= pl; j--) {
                    if (j * j + i * i == num) {
                        result++;
                    }
                }
                pl++;
            }
            System.out.println(result);
        }
    }
}
