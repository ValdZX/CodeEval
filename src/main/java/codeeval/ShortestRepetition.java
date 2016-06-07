package codeeval;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vald_ZX
 */
public class ShortestRepetition {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String temp = "" + line.charAt(0);
            int j = 0;
            for (int i = 0; i < line.length(); i++) {
                if(j == temp.length())
                {
                    j = 0;
                }
                if(temp.charAt(j) == line.charAt(i))
                {
                    j++;
                }
                else
                {
                    temp = line.substring(0, i+1);
                    j = 0;
                }
            }
            System.out.println(temp.length());
        }      
    }
}
