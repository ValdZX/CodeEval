package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NiceAngles {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            double coord = Double.valueOf(line);
            int sec = (int)Math.floor(coord * 3600);
            int deg = sec / 3600;
            sec = Math.abs(sec % 3600);
            int min = sec / 60;
            sec %= 60;
            System.out.printf("%02d.%02d'%02d\"%n", deg, min, sec);
        }
    }
}
