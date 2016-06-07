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
import java.util.Arrays;

/**
 *
 * @author Vald_ZX
 */
public class StringPermutations {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String result = "";
            char[] chars = line.toCharArray();
            Arrays.sort(chars);
            result = String.valueOf(chars);
            int[] massCounters = new int[chars.length - 1];
            int[] massMaxs = new int[massCounters.length];
            for (int i = 0; i < massMaxs.length; i++) {
                massMaxs[i] = i+1;
            }
            
            char[] temps = Arrays.copyOf(chars, chars.length);
            bigwhile: while(true)
            {
                bigfor:for (int i = 0; i < massCounters.length; i++) 
                {
                    if(i>0)
                    {
                        if(massCounters[i] != massMaxs[i])
                        {
                            for (int j = 0; j < i; j++) 
                            {
                                if(massCounters[j] != massMaxs[j])
                                {
                                    continue bigfor;
                                }
                            }
                            for (int j = 0; j < i; j++) 
                            {
                                massCounters[j] = 0;
                            }
                            massCounters[i]++; 
                            temps = next(temps,i,massCounters[i]);
                            result += "," + String.valueOf(temps);
                        }
                        else
                        {
                            if(i == massCounters.length - 1)
                            {
                                for (int j = 0; j < i; j++) 
                                {
                                    if(massCounters[j] != massMaxs[j])
                                    {
                                        continue bigfor;
                                    }
                                }
                                break bigwhile;
                            }
                        }
                    }
                    else if(massCounters[i] != massMaxs[i])
                    {
                        massCounters[i]++;
                        char temp = temps[temps.length - 1];
                        temps[temps.length - 1] = temps[temps.length - 2];
                        temps[temps.length - 2] = temp;
                        result += "," + String.valueOf(temps);
                        break;
                    }
                }
            }
            System.out.println(result);
        }
    }
    private static char[] next(char[] current, int level, int sym)
    {
        int por = level + 1;
        int num = sym;
        char [] result = Arrays.copyOf(current, current.length);
        char [] origin = Arrays.copyOfRange(current, current.length - por - 1, current.length);
        Arrays.sort(origin);
        char [] sort = new char[por];
        int j = 0;
        for (int i = 0; i < origin.length; i++) 
        {
            if(origin[i] != origin[num])
            {
                sort[j] = origin[i];
                j++;
            }
        }
        result[current.length - por - 1] = origin[num];
        j=0;
        for (int i = current.length - por; i < current.length; i++,j++) {
            result[i] = sort[j];
        }
        return result;
    }
}
