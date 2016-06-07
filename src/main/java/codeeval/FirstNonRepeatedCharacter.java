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
import java.util.HashSet;

/**
 *
 * @author Vald_ZX
 */
public class FirstNonRepeatedCharacter {
     public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            HashSet<Character> set = new HashSet<Character>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (!set.contains(c)) {
                    int res = line.indexOf(c, i + 1);
                    if (res == -1) {
                        System.out.println(c);
                        break;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
    }
}
