package com.huststl.year18.nov.day21;

//leetcode13 罗马数字转整数 难度(easy)
public class main013 {

    public int romanToInt(String s){
        int ans = 0;
        int[] aArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rArray = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for(int i=0;i<aArray.length;i++){
            while (s.indexOf(rArray[i]) == 0){
                ans += aArray[i];
                s = s.substring(rArray[i].length());
            }
        }
        return ans;
    }
}
