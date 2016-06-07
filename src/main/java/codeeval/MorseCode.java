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
import java.util.HashMap;

/**
 *
 * @author Vald_ZX
 */
public class MorseCode {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);        
        BufferedReader in = new BufferedReader(new FileReader(file));
        HashMap<String,String> map = new HashMap();
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");
        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");
        map.put("-----", "0");
        map.put(".----", "1");
        map.put("..---", "2");
        map.put("...--", "3");
        map.put("....-", "4");
        map.put(".....", "5");
        map.put("-....", "6");
        map.put("--...", "7");
        map.put("---..", "8");
        map.put("----.", "9");
        String line;
        while ((line = in.readLine()) != null) {
            String [] temp = line.split("  ");
            String result = "";
            for (int i = 0; i < temp.length; i++) {
                String [] syms = temp[i].split(" ");
                for (int j = 0; j < syms.length; j++) {
                    result +=map.get(syms[j]);                    
                }
                result+=" ";
            }
            
            System.out.println(result);
        }      
    }
}
