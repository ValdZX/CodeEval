package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vald_ZX
 */
public class HappyNumbers {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int num = new Integer(line);
            ArrayList <Integer> list = new ArrayList<Integer>();
            while(true)
            {
                if(num == 1)
                {
                    System.out.println("1");
                    break;
                }
                if(list.indexOf(num) == -1)
                {
                    list.add(num);
                    num = nextNum(num);
                }
                else
                {
                    System.out.println("0");
                    break;
                }
                
            }
        }        
     }
    public static int nextNum(int num)
    {
        int result = 0;
        while(num > 0)
        {
            result +=(num % 10)*(num % 10);
            num = num / 10;
        }
        return result;
    }
}
