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
import java.util.List;

/**
 * @author Vald_ZX
 */
public class PlaywithDNA {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lines = line.split(" ");
            String etalon = lines[0];
            int col = new Integer(lines[1]);
            String lab = lines[2];
            int size = etalon.length();
            StringBuilder sb = new StringBuilder("");
            List<List<String>> strirs2d = new ArrayList<List<String>>(col + 1);

            for (int i = 0; i <= lab.length() - size; i++) {
                String substr = lab.substring(i, i + size);
                int count = isGoodStr(etalon, col, substr);
                if (count != -1) {
                    if (count > strirs2d.size() - 1) {
                        int jmax = count - strirs2d.size() + 1;
                        for (int j = 0; j < jmax; j++) {
                            strirs2d.add(new ArrayList<String>());
                        }
                    }
                    strirs2d.get(count).add(substr);
                }
            }
            for (List<String> list : strirs2d) {
                Collections.sort(list);
                for (String string: list) {
                    sb.append(string).append(" ");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb);
            } else {
                System.out.println("No match");
            }
        }
    }

    public static int isGoodStr(String etalon, int col, String sublab) {
        int count = 0;
        for (int i = 0; i < etalon.length(); i++) {
            char chE = etalon.charAt(i);
            char slE = sublab.charAt(i);
            if (chE != slE) {
                count++;
                if (col < count) {
                    return -1;
                }
            }
        }
        return count;
    }
}
