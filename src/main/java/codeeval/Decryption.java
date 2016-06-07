/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Vald_ZX
 */
public class Decryption {
     public static void main(String[] args) throws FileNotFoundException, IOException {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "BHISOECRTMGWYVALUZDNFJKPQX";
        String message = "012222 1114142503 0313012513 03141418192102 0113 2419182119021713 06131715070119";
       
        String[] words = message.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String decode_word = "";
            for (int j = 0; j < word.length(); j+=2) {
                int sym = new Integer(word.substring(j, j+2));
                decode_word += alphabet.charAt(key.indexOf(alphabet.charAt(sym)));
            }
            result += decode_word + " ";
        }
        System.out.println(result);
    }
}
