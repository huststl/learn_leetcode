package com.huststl.year18.dec.day13;

import com.huststl.year18.nov.day16.Main004;

//leetcode 44 通配符匹配（动态规划）难度（hard)
public class Main044 {

    public boolean isMatch(String s,String p){
        int is = 0;
        int ip = 0;

        int press = 0;
        int presp = 0;

        boolean backstrack = false;

        for(is = 0;is < s.length();){
            if(ip == p.length()){
                if(backstrack == false){
                    return false;
                }else if(p.charAt(p.length()-1) == '*'){
                    return true;
                }else {
                    ip = presp;
                    is = ++ press;
                }
            }

            if(p.charAt(ip) == '?'){
                is++;
                ip++;
            }else if(p.charAt(ip) == '*'){
                presp = ++ip;
                press = is;
                backstrack = true;

            }else {
                if(p.charAt(ip) == s.charAt(is)){
                    is++;
                    ip++;
                }else if(backstrack){
                    ip = presp;
                    is = ++ press;
                }else {
                    return false;
                }
            }
        }

        while (ip <= p.length() -1 && p.charAt(ip) == '*'){
            ip++;
            if(ip == p.length()){
                break;
            }
        }

        return ip == p.length();
    }

    public static void main(String[] args) {
        Main044 sol = new Main044();
        System.out.println(sol.isMatch("aa", "a"));
        System.out.println(sol.isMatch("aa", "aa"));
        System.out.println(sol.isMatch("aaa", "aa"));
        System.out.println(sol.isMatch("aa", "*"));
        System.out.println(sol.isMatch("aa", "a*"));
        System.out.println(sol.isMatch("ab", "?*"));
        System.out.println(sol.isMatch("aab", "c*a*b"));
        System.out.println(sol.isMatch("ab", "*a"));
        System.out.println(sol.isMatch("hi", "*?"));

    }
}
