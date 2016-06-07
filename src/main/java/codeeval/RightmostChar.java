package codeeval;

import java.io.*;

public class RightmostChar {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] arrays = line.split(",");
            int offset = arrays[0].lastIndexOf(arrays[1]);
            if (offset != -1) {
                System.out.println(arrays[0].indexOf(arrays[1]));
            }
        }
    }
}
