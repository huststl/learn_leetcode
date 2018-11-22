package com.huststl.year18.nov.day22;

//leetcode 014 最长公共前缀
public class Main014 {


    //解法1
    public String longestCommonPrefix01(String[] strs){
        if(strs == null || strs.length ==0)
            return "";
        String res = new String();
        for(int j=0;j<strs[0].length();j++){
            char c = strs[0].charAt(j);
            for(int i=1;i<strs.length;i++){
                if(j >= strs[i].length() || strs[i].charAt(j)!=c){
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }

    //解法2
    public String longestCommonPrefix02(String[] strs){
        if(strs == null || strs.length ==0)
            return "";
        for(int j=0;j<strs[0].length();j++){
            for(int i=0;i<strs.length;i++){
                if(j >= strs[i].length() || j >= strs[i+1].length()
                        || strs[i].charAt(j)!=strs[i+1].charAt(j)){
                    return strs[i].substring(0,j);
                }
            }
        }
        return strs[0];
    }

}
