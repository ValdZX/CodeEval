package codeeval;

import java.io.*;

public class RollerCoaster {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            StringBuilder result = new StringBuilder();
            boolean switcher = true;
            for (char symbol: line.toCharArray()){
                if(Character.isLetter(symbol)){
                    if(switcher){
                        result.append(Character.toUpperCase(symbol));
                        switcher = false;
                    } else {
                        result.append(Character.toLowerCase(symbol));
                        switcher = true;
                    }
                } else {
                    result.append(symbol);
                }
            }
            System.out.println(result.toString());
        }
    }
}
