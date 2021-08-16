package leetcode;

import java.util.*;

public class LongestPalindrome {

    public static void main(String[] args) {
        //List<String> strings = Arrays.asList("xaabacxcabaaxcabaax","babcccbabbab", "babad", "cbbd","a","ac");
        List<String> strings = Arrays.asList("babab");
        for (String value:strings) {
            System.out.println(LongestPalindrome.longestPalindromes(value));
        }
    }

    public static String longestPalindromes(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static String longestPalindrome(String s) {
       Set<String> map = new HashSet<>();
        for(int i = 0 ;i < s.length();i++){
            for(int j = i+1 ; j < s.length() ; j++){
                if(s.charAt(i) == s.charAt(j)){
                  //System.out.println(i +"----- " + j + "------" + s.substring(i,j+1));
                    map.add(i+","+j);
                }
            }
        }
        if(map.isEmpty()){
            map.add(0+","+0);
        }
        String result = null;
        for(String key : map){
            //System.out.println(key);
            String[] split = key.split(",");
            int first = Integer.valueOf(split[0]);
            int last = Integer.valueOf(split[1]);
            boolean isPalindrome = false;
            for(int i = Integer.valueOf(split[0]) ; i <= Integer.valueOf(split[1]) ; i++){
                if(first == last){
                    if(s.charAt(first) == s.charAt(last)){
                        isPalindrome = true;
                    }else{
                        isPalindrome = false;
                    }
                    break;
                }
                if(s.charAt(first) == s.charAt(last)){
                    first++;
                    last--;
                    isPalindrome = true;
                }else{
                    isPalindrome = false;
                    break;
                }
            }
            if(isPalindrome){
                String temp = s.substring(Integer.valueOf(split[0]) , Integer.valueOf(split[1])+1);
                if(result == null){
                    result = temp;
                }else if(temp.length() > result.length()){
                    result = temp;
                }
            }
        }
        return result;
    }

}