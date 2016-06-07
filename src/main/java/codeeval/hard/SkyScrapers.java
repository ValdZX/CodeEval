package codeeval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SkyScrapers {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            List<Integer> result = new ArrayList<Integer>();
            String[] lineSubStrs = line.split("; |;");
            for (String lineSubStr : lineSubStrs) {
                String[] numsSubStrs = lineSubStr.substring(1,lineSubStr.length() - 1).split(",");
                addToList(result, numsSubStrs);
            }
            int buff = -1;
            boolean emptyStart = true;
            for (int i = 0; i < result.size(); i++) {
                if(emptyStart && result.get(i) != 0){
                    emptyStart = false;
                }
                if(!emptyStart) {
                    if (buff != result.get(i)) {
                        buff = result.get(i);
                        System.out.print((i + 1) + " " + result.get(i) + " ");
                    }
                }
            }
            System.out.print((result.size() + 1) + " " + 0);
            System.out.println();
        }
    }
    private static void addToList(List<Integer> list, String[] numsSubStrs){
        int a = Integer.valueOf(numsSubStrs[0]) - 1;
        int b = Integer.valueOf(numsSubStrs[2]) - 1;
        int size = Integer.valueOf(numsSubStrs[1]);
        for (int i = a; i < b; i++) {
            if(i >= list.size()){
                list.add(0);
                i--;
            } else {
                if(list.get(i) < size){
                    list.set(i, size);
                }
            }
        }
    }
}
