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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Vald_ZX
 */
public class CashRegister {
    public static void main(String[] args) throws IOException {
        HashMap<Double, String> map = new HashMap<Double, String>();
        List<Double> list = new ArrayList<Double>(12);
        
        Double one_hundred = 100.0;
        map.put(one_hundred, "ONE HUNDRED");
        list.add(one_hundred);
        Double fifty = 50.0;
        map.put(fifty, "FIFTY");
        list.add(fifty);
        Double twenty = 20.0;
        map.put(twenty, "TWENTY");
        list.add(twenty);
        Double ten = 10.0;
        map.put(ten, "TEN");
        list.add(ten);
        Double five = 5.0;
        map.put(five, "FIVE");
        list.add(five);
        Double two = 2.0;
        map.put(two, "TWO");
        list.add(two);
        Double one = 1.0;
        map.put(one, "ONE");
        list.add(one);        
        Double half_dollar = 0.5;
        map.put(half_dollar, "HALF DOLLAR");
        list.add(half_dollar);
        Double quarter = 0.25;
        map.put(quarter, "QUARTER");
        list.add(quarter);
        Double dime = 0.1;
        map.put(dime, "DIME");
        list.add(dime);
        Double nickel = 0.05;
        map.put(nickel, "NICKEL");
        list.add(nickel);
        Double penny = 0.01;
        map.put(penny, "PENNY");
        list.add(penny);
        
        
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            StringBuilder sb = new StringBuilder("");
            String[] lines = line.split(";");
            double pp = new Double(lines[0]);
            double ch = new Double(lines[1]);
            if (ch < pp) {
                System.out.println("ERROR");
                continue;
            }
            if (ch == pp) {
                System.out.println("ZERO");
                continue;
            }
            double resulD = Math.round((ch - pp)*100)/100.0;
            
            for (double dou: list) {
                while (true) {
                    if (resulD >= dou) {
                        resulD -= dou;
                        sb.append(",");
                        sb.append(map.get(dou));
                    }
                    else{break;}
                }
            }
            sb.deleteCharAt(0);
            System.out.println(sb);
        }
    }
}
