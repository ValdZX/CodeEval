package codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class NumberPairs {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] arrAndXStrs = line.split(";");
            String[] arrStrs = arrAndXStrs[0].split(",");
            int X = Integer.valueOf(arrAndXStrs[1]);
            int[] arr = new int[arrStrs.length];
            for (int i = 0; i < arrStrs.length; i++) {
                arr[i] = Integer.valueOf(arrStrs[i]);
            }
            TwoArrays twoArrays = getTwoArrays(arr, X);
            if (twoArrays.getLow() == null || twoArrays.getHigh() == null) {
                System.out.println("NULL");
                continue;
            }
            int[] low = twoArrays.getLow();
            int[] high = twoArrays.getHigh();
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int i = 0; i < high.length; i++) {
                for (int j = low.length - 1; j >= 0; j--) {
                    if (high[i] + low[j] == X) {
                        map.put(low[j], high[i]);
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                builder.append(';').append(entry.getKey()).append(',').append(entry.getValue());
            }
            builder.deleteCharAt(0);
            System.out.println(builder.toString());
        }
    }

    private static TwoArrays getTwoArrays(int[] arr, int X) {
        int middleX = X / 2;
        int indexMiddle = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > middleX) {
                indexMiddle = i;
                break;
            }
        }
        if (indexMiddle == -1) {
            return new TwoArrays(arr, null);
        } else if (indexMiddle == 0) {
            return new TwoArrays(null, arr);
        }
        int[] low = Arrays.copyOfRange(arr, 0, indexMiddle);
        int[] high = Arrays.copyOfRange(arr, indexMiddle, arr.length);
        return new TwoArrays(low, high);
    }

    private static class TwoArrays {
        private int[] low;
        private int[] high;

        private TwoArrays(int[] low, int[] high) {
            this.low = low;
            this.high = high;
        }

        public int[] getLow() {
            return low;
        }

        public int[] getHigh() {
            return high;
        }
    }
}
