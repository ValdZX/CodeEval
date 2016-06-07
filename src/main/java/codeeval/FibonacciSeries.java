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
import java.util.ArrayList;
import java.util.List;

public class FibonacciSeries {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        List<Integer> fibonacci = new ArrayList<Integer>();
        fibonacci.add(1);
        fibonacci.add(1);
        while ((line = in.readLine()) != null) {
            int x = new Integer(line);
            if(x == 0){
                System.out.println("0");
                continue;
            }
            if (fibonacci.size() < x) {
                for (int i = fibonacci.size() - 1; i < x; i++) {
                    fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i));
                }
            }
            System.out.println(fibonacci.get(x - 1));
        }
    }
}
