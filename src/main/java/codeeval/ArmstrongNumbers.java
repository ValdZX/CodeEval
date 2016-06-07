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
public class ArmstrongNumbers {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int num = new Integer(line);
            int num2 = num;
            int size = getCountZ(num);
            int result = 0;
            while(num>0)
            {
                result+=Math.pow(num%10, size);
                num /= 10;
            }
            if(result == num2)
            {
                System.out.println("True");
            }
            else
            {
                System.out.println("False");
            }
        }        
     }
    private static int getCountZ(int num)
    {
        int result = 0;
        while(num>0)
        {
            result++;
            num /= 10;
        }
        return result;
    }
}
