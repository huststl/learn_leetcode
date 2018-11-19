package com.huststl.year18.nov.day19;


//回文数 难度（easy）
public class Main009 {

    // 解法1
    public boolean isPalindrome01(int x){

        String string = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(string);
        if(string.equals(stringBuilder.reverse().toString()))
            return true;
        else
            return false;
    }

    //解法2
    public boolean isPalindrome02(int x){
        if(x == 0)
            return true;
        else if(x<0)
            return false;
        int temp = x;
        int contrast = 0;
        while (temp > 0){
            contrast = contrast * 10 + temp % 10;
            temp /= 10;
        }
        return contrast == x;
    }
}
