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
public class PassTriangle {
    public static void main (String[] args) throws FileNotFoundException, IOException {
    int res = 0;
    int id = 0;
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        try {
            String [] nums = line.split(" ");
            if(nums.length == 1)
            {
                res += Integer.parseInt(nums[0]);
                id = 0;
                continue;
            }
            int A = Integer.parseInt(nums[id]);
            int B = Integer.parseInt(nums[id + 1]);
            if(A<B)
            {
                res+=B;
                id++;
            }
            else
            {
                res+=A;
            }
        } catch (Exception e) {
        }
    }
    System.out.println(res);
  }
}
