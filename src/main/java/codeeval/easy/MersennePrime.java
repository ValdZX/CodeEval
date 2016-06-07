package codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AsRock on 23.05.2016.
 */
public class MersennePrime {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            int number = Integer.valueOf(line);
            if (number < 3) {
                continue;
            }

            int i = 2;
            int mersenne;
            String result = "3";
            do {
                i++;
                mersenne = (int) (Math.pow(2, i) - 1);
                if (isPrime(i) && mersenne < number) {
                    result = result.concat(",").concat(String.valueOf(mersenne));
                }
            } while (mersenne < number);
            System.out.println(result);
        }
    }

    private static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        } else if (num == 3) {
            return true;
        } else if (num == 5) {
            return true;
        } else {
            boolean flag = true;
            for (int j = 2; j <= (int) (Math.sqrt(num) + 0.5); j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }
}


