package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LetterCasePercentageRatio {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int upper = 0;
            int lower = 0;
            for (int i = 0; i < line.length(); i++) {
                if (Character.isUpperCase(line.charAt(i))) {
                    upper++;
                } else if (Character.isLowerCase(line.charAt(i))) {
                    lower++;
                }
            }
            int all = upper + lower;
            float lowerRate = (float)lower / all * 100;
            float upperRate = (float)upper / all * 100;
            String lowerStr = String.format("%.2f", lowerRate);
            String upperStr = String.format("%.2f", upperRate);
            System.out.println("lowercase: " + lowerStr + " uppercase: " + upperStr);
        }
    }
}
