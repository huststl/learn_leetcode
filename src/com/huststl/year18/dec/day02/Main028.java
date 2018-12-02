package com.huststl.year18.dec.day02;

// leetcode 028 实现strStr() 难度（easy)
public class Main028 {

    //解法1
    public static int strStr01(String haystack,String needle){

        //一些最基本情况的判断
        if(needle.equals("")){
            return 0;
        }
        char[] hs = haystack.toCharArray();
        char[] nd = needle.toCharArray();

        if(haystack.equals(needle)){
            return 0;
        }

        //冒泡算法优化
        for(int i=0;i<=hs.length-nd.length;i++){
            //当前字符与目标字符串首字符相等则进入判断部分
            if(nd[0] == hs[i]){
                int index = i;

                //依次比较后面的字符，如果不相等则跳出该循环
                for(int j=0;j<nd.length;j++){
                    if(nd[j]!=hs[index++]){
                        break;
                    }

                    //如果比较到最后一个字符
                    if(j==nd.length-1){
                        return i;
                    }
                }
            }else {
                continue;
            }
        }
        return -1;
    }

    //解法2
    public int strStr02(String haystack,String needle){
        //要找的是空，返回0
        if(needle == null){
            return 0;
        }
        //元字符是null，肯定是-1找不到
        if(haystack == null){
            return -1;
        }
        int len1 = haystack.length();
        int len2 = needle.length();

        //要找的比原来的长
        if(len1<len2){
            return -1;
        }

        if(len1 == len2){
            if(haystack.equals(needle)){
                return 0;
            }else {
                return -1;
            }
        }

        if(len2 == 0){
            return 0;
        }

        int begin = 0;

        while (len1-begin >=len2){
            //假设存在
            boolean exist = true;

            for(int i=begin,j=0;i<len1 && j<len2;i++,j++){
                if(haystack.charAt(i)!=needle.charAt(j)){
                    exist = false;
                    break;
                }
            }

            if(exist)
                return begin;
            begin++;
        }
        return -1;
    }
}
