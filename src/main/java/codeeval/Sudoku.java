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
import java.util.ArrayList;

/**
 *
 * @author Vald_ZX
 */
public class Sudoku {
     public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        bigwhile: while ((line = in.readLine()) != null) {
            String [] lines = line.split(";");
            String numsStr[] = lines[1].split(",");
            int rank = new Integer(lines[0]);
            int [][] nums = new int[rank][rank];
            
            
            for (int i = 0; i < rank; i++) {
                for (int j = 0; j < rank; j++) {
                    nums[i][j] = new Integer(numsStr[(rank * i)+j]);
                } 
            }
            for (int i = 0; i < rank; i++) {
                ArrayList<Integer> temp = new ArrayList();
                for (int j = 0; j < rank; j++) {
                    if(temp.indexOf(nums[i][j]) == -1)
                    {
                        temp.add(nums[i][j]);
                    }
                    else
                    {
                        System.out.println("False");
                        continue bigwhile;
                    }
                }
            }
            for (int i = 0; i < rank; i++) {
                ArrayList<Integer> temp = new ArrayList();
                for (int j = 0; j < rank; j++) {
                    if(temp.indexOf(nums[j][i]) == -1)
                    {
                        temp.add(nums[j][i]);
                    }
                    else
                    {
                        System.out.println("False");
                        continue bigwhile;
                    }
                }
            }
            System.out.println("True");
        }
     }
}
