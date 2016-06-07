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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Vald_ZX
 */
public class LongestLines {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        line = in.readLine();
        int count = new Integer(line);
        List<String> strs = new ArrayList<String>();
        while ((line = in.readLine()) != null) {
            strs.add(line);
        }
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return -1;
                else if(o1.length() < o2.length())
                    return 1;
                else
                    return 0;
            }
        };
        Collections.sort(strs, comparator);
        for (int i = 0; i < count; i++) {
            System.out.println(strs.get(i));
        }
    }
}
