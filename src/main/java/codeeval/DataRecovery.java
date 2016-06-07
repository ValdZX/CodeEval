package codeeval;

import java.io.*;
import java.util.*;

public class DataRecovery {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            Map<Integer,String> map = new TreeMap<Integer,String>();
            String result = "";
            String[] lines = line.split(";");
            String[] words = lines[0].split(" ");
            String[] nums = lines[1].split(" ");
            for(int i = 0; i < nums.length; i++){
                map.put(new Integer(nums[i]), words[i]);
            }
            List<String> emptyWords = new ArrayList<String>();
            for (int i = nums.length; i < words.length; i++) {
                emptyWords.add(words[i]);
            }
            int i = 0;
            for (int j = 1; j <= words.length; j++) {
                if(!map.containsKey(j)){
                    map.put(j, emptyWords.get(i));
                    i++;
                }
            }
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                String string = entry.getValue();
                result += string + " ";
            }
            System.out.println(result);
        }
    }
}
