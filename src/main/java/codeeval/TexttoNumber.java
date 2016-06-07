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
import java.util.Map;

/**
 *
 * @author Vald_ZX
 */
public class TexttoNumber {
    static Map<String, Integer> diction = new HashMap();

    static {
        diction.put("zero", 0);
        diction.put("one", 1);
        diction.put("two", 2);
        diction.put("three", 3);
        diction.put("four", 4);
        diction.put("five", 5);
        diction.put("six", 6);
        diction.put("seven", 7);
        diction.put("eight", 8);
        diction.put("nine", 9);
        diction.put("ten", 10);
        diction.put("eleven", 11);
        diction.put("twelve", 12);
        diction.put("thirteen", 13);
        diction.put("fourteen", 14);
        diction.put("fifteen", 15);
        diction.put("sixteen", 16);
        diction.put("seventeen", 17);
        diction.put("eighteen", 18);
        diction.put("nineteen", 19);
        diction.put("twenty", 20);
        diction.put("thirty", 30);
        diction.put("forty", 40);
        diction.put("fifty", 50);
        diction.put("sixty", 60);
        diction.put("seventy", 70);
        diction.put("eighty", 80);
        diction.put("ninety", 90);
        diction.put("hundred", 100);
        diction.put("thousand", 1000);
        diction.put("million", 1000000);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lines = line.split(" ");
            int result = 0;
            boolean isBig = false;
            int big = 0;
            boolean isSm = false;
            int sm = 0;
            boolean isNegativ = false;
            for (int i = lines.length - 1; i >= 0; i--) {
                if (lines[i].equals("negative")) {
                    isNegativ = true;
                    break;
                }
                int num = diction.get(lines[i]);

                if (num >= 100) {
                    if (isSm) {
                        isSm = false;
                        if (isBig) {
                            result += big * sm;
                            isBig = false;
                        } else {
                            result += sm;
                        }
                    }
                    big = num;
                    isBig = true;
                } else if (num >= 20) {
                    int temp = 0;
                    if (isSm) {
                        temp = num + sm;
                        isSm = false;
                    } else {
                        temp = num;
                    }
                    if (isBig) {
                        result += big * temp;
                        isBig = false;
                    } else {
                        result += temp;
                    }
                } else if (num >= 10) {
                    if (isBig) {
                        result += big * num;
                        isBig = false;
                    } else {
                        result += num;
                    }
                } else {
                    sm = num;
                    isSm = true;
                }
            }
            if (isSm) {
                if (isBig) {
                    result += big * sm;
                    isBig = false;
                } else {
                    result += sm;
                }
            }
            if (isNegativ) {
                result = -result;
            }
            System.out.println(result);
        }
    }
}
