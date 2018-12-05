package com.huststl.year18.dec.day05;

import java.util.ArrayList;
import java.util.List;

//leetcode 32 最长有效括号 难度（hard)
public class Main032 {


    public int longestValidParentheses(String s){

        List<ele> list = new ArrayList<ele>();

        int max = 0;
        int now = 0;
        int size = s.length();

        int[] tmp = new int[size];//辅助数组

        int i = 0;//辅助数组下标

        for(char c:s.toCharArray()){
            if(c == '('){
                list.add(new ele(i,c));
                tmp[i] = 0;
                i++;
                continue;
            }

            if(c == ')'){
                if(list.isEmpty() || list.get(list.size()-1).getSmp() != '('){
                    now = 0;
                    tmp[i] = 0;
                    i++;
                    continue;
                }else {
                    ele e = list.get(list.size()-1);
                    tmp[e.getIndex()] = 1;
                    tmp[i] = 1;
                    i++;
                    list.remove(list.size()-1);
                }
            }

        }

        for(int x = 0;x<tmp.length;x++){
            if(tmp[x] == 1){
                now +=1;
                max = max > now ? max:now;
            }
            else {
                now= 0;
            }
        }
        return max;

    }

    public static class ele{ //辅助类

        public int index;
        public char smp;

        public ele(int index,char smp){
            this.index = index;
            this.smp = smp;
        }

        public int getIndex(){
            return this.index;
        }

        public char getSmp(){
            return this.smp;
        }
    }
}
