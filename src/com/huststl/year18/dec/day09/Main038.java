package com.huststl.year18.dec.day09;

//leetcode 38 报数 难度（easy)
public class Main038 {

    //解法1
    public String countAndSay01(int n){
        String result = "1";
        for(int i=1;i<n;i++){
            result = nextCount(result);
        }
        return result;
    }

    public String nextCount(String s) {
        int length = s.length();
        StringBuilder  a = new StringBuilder();
        int i=0;
        int num = 0;
        char prev = ' ';
        char now;

        while (true){
            if(prev ==' '){  //第一次进入循环
                prev = s.charAt(i);
                num++;
            }else {
                now = s.charAt(i);
                if(now == prev){
                    num++;
                }else {
                    a.append(num);
                    a.append(prev);
                    prev = now;
                    num = 1;
                }
            }
            i++;
            if(i == length){
                a.append(num);
                a.append(prev);
                break;
            }
        }
        return a.toString();
    }

    //解法2
    public String countAndSay(int n){
        if(n <=0)
            return "";
        if(n == 1)
            return "1";

        StringBuilder s = new StringBuilder();

        for(int i=2;i<=n;i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j=1;j<s.length();j++){
                if(s.charAt(j) == s.charAt(j-1)){
                    count++;
                }else {
                    sb.append(count);
                    sb.append(s.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(s.charAt(s.length()-1));
            s = sb;
        }
        return s.toString();
    }
}
