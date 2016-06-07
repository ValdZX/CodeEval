package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AgeDistribution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int i = Integer.valueOf(line);
            if (i > 100) {
                System.out.println("This program is for humans");
            } else if (i >= 66) {
                System.out.println("The Golden Years");
            } else if (i >= 23) {
                System.out.println("Working for the man");//23 65
            } else if (i >= 19) {
                System.out.println("College");//19 22
            } else if (i >= 15) {
                System.out.println("High school");//15 18
            } else if (i >= 12) {
                System.out.println("Middle school");//12 14
            } else if (i >= 5) {
                System.out.println("Elementary school");//5 11
            } else if (i >= 3) {
                System.out.println("Preschool Maniac");//3 4
            } else if (i >= 0) {
                System.out.println("Still in Mama's arms");//0 2
            } else {
                System.out.println("This program is for humans");
            }
        }
    }
}
