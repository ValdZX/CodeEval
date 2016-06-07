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
public class PointInCircle {
    public static void main (String[] args) throws FileNotFoundException, IOException {
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        Point center = new Point();
        double radius;
        Point point = new Point();
        int t = line.indexOf(",");
        String Cx = line.substring(9, t);
        String Cy = line.substring(t + 2, line.indexOf(")"));
        center.setLocation(Double.valueOf(Cx), Double.valueOf(Cy));
        t = line.indexOf("R") + 8;
        radius = Double.valueOf(line.substring(t,line.lastIndexOf(";")));
        t = line.lastIndexOf(",");        
        Cx = line.substring(line.lastIndexOf("(")+1, t);
        Cy = line.substring(t + 2, line.lastIndexOf(")"));
        point.setLocation(Double.valueOf(Cx), Double.valueOf(Cy));
        double distance = center.distance(point);
        if(radius > distance)
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
        //Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)
    }
  }
}
