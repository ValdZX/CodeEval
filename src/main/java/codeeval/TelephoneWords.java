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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vald_ZX
 */
public class TelephoneWords {
    static Map<Character, char[]> map = new HashMap<Character, char[]>();

    public static void main(String[] args) throws IOException {
        map.put('0', new char[]{'0'});
        map.put('1', new char[]{'1'});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        while ((line = in.readLine()) != null) {
            String res = recurs(line, 0, line);
            StringBuilder result = new StringBuilder(res);
            result.deleteCharAt(result.length() - 1);
            System.out.println(result);
            
        }
    }

    static String recurs(String line, int id, String curLine) {
        StringBuilder sb = new StringBuilder(curLine);
        StringBuilder result = new StringBuilder();
        char[] syms = map.get(line.charAt(id));
        for (char d: syms) {
            sb.setCharAt(id, d);
            if(id != line.length() - 1)
            {                
                result.append(recurs(line, id + 1, sb.toString()));
            }
            else
            {
                result.append(sb).append(",");
            }
        }
        return result.toString();
    }
}
