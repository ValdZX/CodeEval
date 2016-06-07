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
public class FizzBuzz {
    public static void main(String[] args) {
        
        int [] mass = {2,7, 15};
        int F=0, B=0;
        for(int i = 1; i <= mass[2]; i++)
        {
            F = i%mass[0];
            B = i%mass[1];
            if(F==0 && B==0)
            {
                System.out.print("FB ");
                continue;
            }
            else if(F==0)
            {
                System.out.print("F ");
                continue;
            }
            else if(B==0)
            {
                System.out.print("B ");
                continue;
            }
            System.out.print(i + " ");
        }
    }
}
