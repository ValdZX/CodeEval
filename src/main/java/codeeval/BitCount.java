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
public class BitCount {
    public static void main(String[] args) {
        System.out.println(countBit(10));
    }
    private static int countBit(int num)
    {
        int res = 0;
        while(num != 0)
        {
            int emp = num & 1;
            if(emp == 1)
            {
                res ++;
            }
            num = num >> 1;
        }
        return res;
    }
            
}
