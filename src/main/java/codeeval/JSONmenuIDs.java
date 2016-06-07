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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vald_ZX
 */
public class JSONmenuIDs {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            Pattern latlon = Pattern.compile("\"label\": \"Label [0-9]+\"");
            Matcher matcher = latlon.matcher(line);
            int result = 0;
            while (matcher.find()) {
                if (matcher.group(0) != null) {
                    String num = matcher.group(0);
                    result += new Integer(num.substring(16, num.length() - 1));
                }
            }
            System.out.println(result);
        }
    }
}
