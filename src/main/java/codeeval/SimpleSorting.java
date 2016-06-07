package codeeval;

import java.io.*;
import java.util.Arrays;

public class SimpleSorting {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lines = line.split(" ");
            double[] doubs = new double[lines.length];
            for (int i = 0; i < lines.length; i++) {
                doubs[i] = Double.valueOf(lines[i]);
            }
            Arrays.sort(doubs);
            System.out.printf("%.3f",doubs[0]);
            for (int i = 1; i < doubs.length; i++) {
                System.out.printf(" %.3f", doubs[i]);
            }
            System.out.println();
        }
    }
}
