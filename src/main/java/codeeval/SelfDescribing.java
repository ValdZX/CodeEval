/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

/**
 *
 * @author Vald_ZX
 */
public class SelfDescribing {
     public static void main(String[] args) {
         System.out.println(selfDescription(2020));
         System.out.println(selfDescription(22));
         System.out.println(selfDescription(1210));
    }
    private static int selfDescription(int num)
    {
        int legth = (int)Math.ceil(Math.log10(num));
        int [] mass = new int[legth];
        for(int i = legth - 1;i >= 0; i--)
        {
            int lev = (int)Math.pow(10, i);
            if(num > lev - 1)
            {
                mass[legth - 1 -i] = num / lev;
                num = num % lev;
            }
        }
        for(int i = 0;i < legth; i++)
        {
            if(mass[i] != countnumbers(mass, i))
            {
                return 0;
            }
        }
        
        return 1;
    }
    private static int countnumbers(int [] mass, int num)
    {
        int res = 0;
        for (int numP : mass) {
            if(num == numP)
            {
                res ++;
            }
        }
        return res;
    }
}
