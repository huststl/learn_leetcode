package com.huststl.year18.nov.day15;


import java.util.Arrays;
import java.util.HashSet;

//leetcode 第3题 难度 medium
public class Main003 {

    //法1
    public int lengthOfLongestSubstring01(String s){

        int[] m = new int[256];
        Arrays.fill(m,-1);
        int res = 0,left= -1;
        for(int i=0;i<s.length();i++){
            left = Math.max(left,m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res,i-left);
        }
        return res;
    }


    //法2
    public int lengthOfLongestSubstring02(String s){
        int res = 0,left=0,right = 0;
        HashSet<Character> t = new HashSet<Character>();

        while (right < s.length()){

            if(!t.contains(s.charAt(right))){
                t.add(s.charAt(right++));
                res = Math.max(res,t.size());
            }else {
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }


}
