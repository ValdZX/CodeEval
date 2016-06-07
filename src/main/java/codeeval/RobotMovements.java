/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Vald_ZX
 */
public class RobotMovements {
    static int res = 0;
    public static void main (String[] args) throws FileNotFoundException, IOException {
        ArrayList<Point> test = new ArrayList<Point>();
        test.add(new Point(0, 0));
        recurs(test,4);
        System.out.println(res);
    }

    public static void recurs(ArrayList<Point> list, int size)
    {
        Point current = list.get(list.size()-1);
        if(current.x >= 0 && current.x < size-1)
        {
           Point next = new Point(current.x + 1, current.y);
        
            if(next.x == size -1 && next.y == size -1)
               {
                   res++;
               }
            else
               {
                if(be(next, list))
                {
                    ArrayList<Point> newList = new ArrayList<Point>();
                    newList.addAll(list);
                    newList.add(next);
                    recurs(newList, size);
                }
               }
            }        

        if(current.x > 0 && current.x <= size-1)
        {
           Point next = new Point(current.x - 1, current.y);
           if(next.x == size -1 && next.y == size -1)
               {
                   res++;
               }
            else
               {
                if(be(next, list))
                {
                    ArrayList<Point> newList = new ArrayList<Point>();
                    newList.addAll(list);
                    newList.add(next);
                    recurs(newList, size);
                }
               }
        } 

        if(current.y >= 0 && current.y < size-1)
        {
           Point next = new Point(current.x , current.y+ 1);
           if(next.x == size -1 && next.y == size -1)
               {
                   res++;
               }
            else
               {
                if(be(next, list))
                {
                    ArrayList<Point> newList = new ArrayList<Point>();
                    newList.addAll(list);
                    newList.add(next);
                    recurs(newList, size);
                }
               }
        }        

        if(current.y > 0 && current.y <= size-1)
        {
           Point next = new Point(current.x , current.y - 1);
           if(next.x == size -1 && next.y == size -1)
               {
                   res++;
               }
            else
               {
                if(be(next, list))
                {
                    ArrayList<Point> newList = new ArrayList<Point>();
                    newList.addAll(list);
                    newList.add(next);
                    recurs(newList, size);
                }
               }
        } 
    }
    public static boolean be(Point p, ArrayList<Point> list)
    {
        for (Point point : list) {
            if(point.x == p.x && point.y == p.y)
            {
                return false;
            }
        }
        return true;
    }
}
