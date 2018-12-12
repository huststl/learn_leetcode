package com.huststl.year18.dec.day12;


//leetcode 043 Multiply Strings 难度（medium)
public class Main043 {
    public String multiply(String num1,String num2){

        //字符串反转
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();

        //两数相乘，最大位数为二者位数之和
        int[] b = new int[num1.length()+num2.length()];

        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                //先获取对应位相乘，不考虑进位
                b[i+j] += (num1.charAt(i) -'0') * (num2.charAt(j) - '0');
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=num1.length()+num2.length()-1;i>=0;i--){
            stringBuilder.append(b[i]);
        }
        while (stringBuilder.charAt(0)=='0' && stringBuilder.length()>1)
            stringBuilder.deleteCharAt(0);

        return stringBuilder.toString();
    }
}
