package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/push-dominoes/
 * Problem No - 838
 */
public class Dominoes {

    public static void main(String[] args) {
        String s = "....L";
        System.out.println(dominos(s));


    }

    private static String dominos(String str) {

        if(!str.contains(".") || ".".equals(str)){
            return str;
        }



        char[] res = new char[str.length()];
        Arrays.fill(res,'.');

        for(int i = 0 ; i< str.length() ; i++){
            // if we encounter the 'L' doominoes
            if(str.charAt(i) == 'L'){
                res[i] = str.charAt(i);
                if(i == 1 && str.charAt(i-1) == '.'){
                    res[i-1] = 'L';
                }else if(i>1 && str.charAt(i-1) == '.' && str.charAt(i-2) == '.'){
                    res[i-1]='L';
                }
            }
            if(str.charAt(i) == 'R'){
                res[i] = str.charAt(i);
                if(i == str.length()-2 && str.charAt(i+1) == '.'){
                    res[i+1] = 'R';
                }else if(i< str.length()-2 && str.charAt(i+1) == '.' && str.charAt(i+2) == '.') {
                    res[i+1] = 'R';
                }
            }


        }



        return new String(res);

    }


}
