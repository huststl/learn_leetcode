package com.huststl.year18.dec.day26;

//leetcode 058 求末尾单词的长度  难度(easy)
public class Main058 {

    public int lengthOfLastWord(String s){

        int len = s.length();
        int i = len - 1;
        int count = 0;

        while (i>=0 && s.charAt(i)==' '){
            i--;
        }

        for(;i>=0;i--){
            char ch = s.charAt(i);
            if(ch !=' '){
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
