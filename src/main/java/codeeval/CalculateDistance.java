/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Vald_ZX
 */
public class CalculateDistance {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String [] lines = line.split(" ");
            Integer x = new Integer(lines[0].substring(1, lines[0].length() - 1));
            Integer y = new Integer(lines[1].substring(0,lines[1].length() - 1));
            Point p1 = new Point(x, y);
            x = new Integer(lines[2].substring(1, lines[2].length() - 1));
            y = new Integer(lines[3].substring(0,lines[3].length() - 1));
            Point p2 = new Point(x, y);
            
            System.out.println((int)p1.distance(p2));
        }      
    }
}
