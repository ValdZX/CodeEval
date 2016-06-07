package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class JugglingWithZeros {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] substrs = line.split(" ");
            StringBuilder binary = new StringBuilder();
            for (int i = 0; i < substrs.length; i+=2) {
                char sym;
                if("00".equals(substrs[i])){
                    sym = '1';
                } else {
                    sym = '0';
                }
                for (int j = 0; j < substrs[i + 1].length(); j++) {
                    binary.append(sym);
                }
            }
            if(binary.length() > 31){
                BigInteger result = new BigInteger(binary.toString(),2);
                System.out.println(result);
            } else {
                int result = Integer.parseInt(binary.toString(), 2);
                System.out.println(result);
            }
        }
    }
}
