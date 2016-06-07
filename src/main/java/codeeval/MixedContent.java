/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vald_ZX
 */
public class MixedContent {
    public static void main(String[] args) {
        String str = "melon,apricot,peach,pineapple";
        String[] strs = str.split(",");
        List<Integer> numsL = new ArrayList<Integer>();
        List<String> strsL = new ArrayList<String>();
        for (String string : strs) 
        {
            try {
                numsL.add(Integer.parseInt(string));
            } catch (NumberFormatException e) {
                strsL.add(string);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String string : strsL) 
        {
            res.append(string).append(',');
        }
        int t = res.length() - 1;
        if(t != -1)res.deleteCharAt(t);
        for (Integer num : numsL) 
        {
            res.append(',').append(num);
        }
        if(numsL.size()>0)if(t != -1)res.setCharAt(t, '|');
        else res.deleteCharAt(0);
        System.out.println(res.toString());
    }
}
