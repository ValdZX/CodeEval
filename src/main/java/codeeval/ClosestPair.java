/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.awt.geom.Point2D;
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
public class ClosestPair {
    public static void main (String[] args) throws FileNotFoundException, IOException {        
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));        
        boolean isBegin = false;
        int count = -1;
        ArrayList<Point2D> points = new ArrayList<Point2D>();
        String line;  
        
        while ((line = in.readLine()) != null) {
            if(points.size() == count)
            {
                System.out.printf("%.4f\n", Minimum(points));
                points.clear();
                isBegin = false;
            }
            if(!isBegin)
            {
                count = new Integer(line);
                isBegin = true;
            }
            else
            {
                String [] lines = line.split(" ");
                points.add(new Point2D.Double(new Double(lines[0]), new Double(lines[1])));
            }
            
        }   
    }
    private static double Minimum(ArrayList<Point2D> points)
    {
        double result = Double.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            Point2D point2D = points.get(i);
            for (int j = i+1; j < points.size(); j++) {
                Point2D point2D1 = points.get(j);
                double dist = point2D.distance(point2D1);
                if(result > dist)
                {
                    result = dist;
                }
            }
        }
        return result;
    }
}

/*
public static void main (String[] args) throws FileNotFoundException, IOException {        
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));        
        boolean isBegin = false;
        int count = -1;
        int i = 0;
        Point2D[] points = null;
        String line;  
        
        while ((line = in.readLine()) != null) {
            
            if(!isBegin)
            {
                count = new Integer(line);
                if(count == 0)
                {
                    break;
                }
                points = new Point2D[count];
                isBegin = true;
            }
            else
            {
                String [] lines = line.split(" ");
                points[i] = new Point2D.Float(new Float(lines[0]), new Float(lines[1]));
                i++;
            }
            if(i == count)
            {
                double result = Minimum(points);
                if(result < 40000)
                    System.out.printf("%.4f\n", result);
                else
                    System.out.println("INFINITY");
                isBegin = false;
                i=0;
            }
        }   
    }
    private static double Minimum(Point2D[] points)
    {
        float result = Float.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            Point2D point2D = points[i];
            for (int j = i+1; j < points.length; j++) {
                try
                {
                Point2D point2D1 = points[j];
                float dist = (float)point2D.distance(point2D1);
                if(result > dist)
                {
                    result = dist;
                }
                }
                catch(Exception e)
                {
                }
            }
        }
        return result;
    }
*/
