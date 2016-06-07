/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class QueryBoard {
    public static void main(String[] args) throws IOException {
        int size = 256;
        byte[][] matrix = new byte[size][size];
        int i, j, x;
        int result = 0;
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] command = line.split(" ");
            if ("SetRow".equals(command[0])) {
                i = new Integer(command[1]);
                x = new Integer(command[2]);
                for (j = 0; j < size; j++) {
                    matrix[i][j] = (byte)x;
                }
            } else if ("SetCol".equals(command[0])) {
                j = new Integer(command[1]);
                x = new Integer(command[2]);
                for (i = 0; i < size; i++) {
                    matrix[i][j] = (byte)x;
                }
            } else if ("QueryRow".equals(command[0])) {
                result = 0;
                i = new Integer(command[1]);
                for (j = 0; j < size; j++) {
                    result += matrix[i][j];
                }
                System.out.println(result);
            } else if ("QueryCol".equals(command[0])) {
                result = 0;
                j = new Integer(command[1]);
                for (i = 0; i < size; i++) {
                    result += matrix[i][j];
                }
                System.out.println(result);
            }
        }
    }
}