/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.io.*;

/**
 *
 * @author Vald_ZX
 */
public class RomanNumbers {
    static String[] MASS = {"I","V","X","L","C","D","M"};
    public static void main(String[] args) throws FileNotFoundException, IOException{
        for (String str: args) {
            int num = 0;
            try {
                num = Integer.parseInt(str);
                System.out.println(ToRomane(num));
            } catch (NumberFormatException e) {
            }
        }
    }
    private static String ToRomane(int num)
    {
        String result = "";
        
        int temp = 0;
        
        if(num == 0)
        {
           return "N"; 
        }
        
        if(num > 999)
        {
            temp = num / 1000;
            num = num % 1000;
            for (int i = 0; i < temp; i++) {
                result+=MASS[6];
            }
        }
        for(int i = 2;i >= 0; i--)
        {
            int lev = (int)Math.pow(10, i);
            if(num > lev - 1)
            {
                temp = num / lev;
                num = num % lev;
                int c = i*2;
                switch(temp)
                {
                    case 1: result += MASS[c]; break;
                    case 2: result += MASS[c] + MASS[c]; break;
                    case 3: result += MASS[c] + MASS[c] + MASS[c]; break;
                    case 4: result += MASS[c] + MASS[c+1]; break;
                    case 5: result += MASS[c+1]; break;
                    case 6: result += MASS[c+1] + MASS[c]; break;
                    case 7: result += MASS[c+1] + MASS[c]+ MASS[c]; break;
                    case 8: result += MASS[c+1] + MASS[c]+ MASS[c]+ MASS[c]; break;
                    case 9: result += MASS[c]+ MASS[c+2]; break;                    
                }
            }
        }
        return result;
    }    
}
