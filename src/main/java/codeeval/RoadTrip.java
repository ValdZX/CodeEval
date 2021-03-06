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
public class RoadTrip {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String [] lines = line.split(";");
            int [] nums = new int[lines.length];
            for (int i = 0; i < lines.length; i++) {
                nums[i] = new Integer(lines[i].substring(lines[i].indexOf(",")+1));
            }
            Arrays.sort(nums);
            String result = "" + nums[0];
            for (int i = 1; i < nums.length; i++) {
                result += "," + (nums[i]-nums[i-1]);
            }
            System.out.println(result);
        }
     }
}
