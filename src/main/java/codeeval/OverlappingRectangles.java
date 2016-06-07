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
public class OverlappingRectangles {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String [] strs = line.split(",");
            int Ax1 = Integer.valueOf(strs[0]);
            int Ay1 = Integer.valueOf(strs[1]);
            
            int Bx1 = Integer.valueOf(strs[2]);
            int By1 = Integer.valueOf(strs[3]);
            
            int Ax2 = Integer.valueOf(strs[4]);
            int Ay2 = Integer.valueOf(strs[5]);
            
            int Bx2 = Integer.valueOf(strs[6]);
            int By2 = Integer.valueOf(strs[7]);
            
            if(Ax1 > Bx1)
            {
                int temp = Ax1;
                Ax1 = Bx1;
                Bx1 = temp;
            }
            if(Ay1 > By1)
            {
                int temp = Ay1;
                Ay1 = By1;
                By1 = temp;
            }
            if(Ax2 > Bx2)
            {
                int temp = Ax2;
                Ax2 = Bx2;
                Bx2 = temp;
            }
            if(Ay2 > By2)
            {
                int temp = Ay2;
                Ay2 = By2;
                By2 = temp;
            }
            if(isCross(Ax1, Bx1, Ax2, Bx2) && isCross(Ay1, By1, Ay2, By2))
                System.out.println(true);
            else
                System.out.println(false);
        }
     }
    private static boolean isCross(int a1, int a2, int b1, int b2)
    {
        if(a1 <= b1 && b1 <= a2)
            return true;
        else if (b1 <= a1 && a1 <= b2)
            return true;
        return false;
    }
}
