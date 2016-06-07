package codeeval.easy;

/**
 * Created by AsRock on 30.05.2016.
 */
public class GridWalk {
    public static void main (String[] args) {
        int res = 0;
        for (int i = 1; i < 19*2+1; i+=2) {
            res+=i;
        }
        res=res * 2 + (20*2-2);
        System.out.println(res);
    }
}
