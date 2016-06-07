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
public class SpiralPrinting {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            //3;3;1 2 3 4 5 6 7 8 9

            String[] strs = line.split(";");
            int rows = new Integer(strs[0]);
            int colums = new Integer(strs[1]);
            String[] letters = strs[2].split(" ");

            int layer = 0;
            int i = 0;
            String result = "";
            boolean flag = false;
            while (true) {
                int x;
                int y;
                //1
                for (int j = layer; j < colums - layer; j++) {
                    x = j;
                    y = layer;
                    result += letters[y * colums + x] + " ";
                    i++;
                }
                //2
                for (int j = layer + 1; j < rows - layer; j++) {
                    x = colums - layer - 1;
                    y = j;
                    result += letters[y * colums + x] + " ";
                    i++;
                    flag = true;
                }
                if (flag) {
                    flag = false;
                } else {
                    break;
                }
                //3
                for (int j = colums - layer - 2; j >= layer; j--) {
                    x = j;
                    y = rows - layer - 1;
                    result += letters[y * colums + x] + " ";
                    i++;
                    flag = true;
                }
                if (flag) {
                    flag = false;
                } else {
                    break;
                }
                //4
                for (int j = rows - layer - 2; j >= layer + 1; j--) {
                    y = j;
                    x = layer;
                    result += letters[y * colums + x] + " ";
                    i++;
                }

                layer++;

                if (i >= rows * colums) {
                    break;
                }
            }
            System.out.println(result);

        }
    }
}
