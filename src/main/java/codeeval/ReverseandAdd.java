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
public class ReverseandAdd {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int num = new Integer(line);
            int revers;
            //System.out.println(revers);
            for (int i = 0; i < 100; i++) {
                revers = getRevers(num);
                if(num == revers)
                {
                    System.out.println(i + " " + num);
                    break;
                }
                num = num + revers;
            }
        }

    }

    static int getRevers(int num) {
        
        int temp = num;
        int result = 0;
        while(true)
        {
            if(temp == 0)
            {
                return result;
            }
            int temp2 = temp % 10;
            temp = temp/10;
            result = result * 10 + temp2;
        }
    }
}
