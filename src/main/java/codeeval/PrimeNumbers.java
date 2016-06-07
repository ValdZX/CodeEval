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
public class PrimeNumbers {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int max = new Integer(line);
            if(max == 2)
            {
                System.out.println("2");
            }
            else if(max == 3)
            {
                System.out.println("2,3");
            }
            else
            {
                String result = "2,3,5";
                for (int i = 7; i <= max; i++) {
                    boolean flag =  true;
                    for (int j = 2; j <= (int)(Math.sqrt(i) + 0.5); j++) {
                        if(i%j==0)
                        {
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                    {
                        result += "," + i;
                    }
                }
                System.out.println(result);
            }
        }
     }
}
