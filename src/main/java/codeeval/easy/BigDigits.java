package codeeval.easy;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BigDigits {
    private static String[][] dict =
           {{"-**--", "--*--", "***--", "***--", "-*---", "****-", "-**--", "****-", "-**--", "-**--"},
            {"*--*-", "-**--", "---*-", "---*-", "*--*-", "*----", "*----", "---*-", "*--*-", "*--*-"},
            {"*--*-", "--*--", "-**--", "-**--", "****-", "***--", "***--", "--*--", "-**--", "-***-"},
            {"*--*-", "--*--", "*----", "---*-", "---*-", "---*-", "*--*-", "-*---", "*--*-", "---*-"},
            {"-**--", "-***-", "****-", "***--", "---*-", "***--", "-**--", "-*---", "-**--", "-**--"},
            {"-----", "-----", "-----", "-----", "-----", "-----", "-----", "-----", "-----", "-----"}};

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder[] strs = new StringBuilder[6];
        for (int i = 0; i < 6; i++) {
            strs[i] = new StringBuilder();
        }

        while ((line = in.readLine()) != null) {
            for (int i = 0; i < 6; i++) {
                strs[i].setLength(0);
            }
            line = line.replaceAll("\\D+","");
            for (Character character: line.toCharArray()){
                int num = Integer.valueOf(character+"");
                for (int i = 0; i < 6; i++) {
                    strs[i].append(dict[i][num]);
                }
            }
            for (int i = 0; i < 6; i++) {
                System.out.println(strs[i].toString());
            }
        }
    }

}
