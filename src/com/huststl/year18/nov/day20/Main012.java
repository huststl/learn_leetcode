package com.huststl.year18.nov.day20;

//数字旋转罗马字符
public class Main012 {

    public String intToRoman(int num){

        String[][] base = new String[][]{
                {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // 个位的表示
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, // 十位的表示
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // 百倍的表示
                {"M", "MM", "MMM", "", "", "", "", "", ""}//千位的表示

        };

        String result ="";

        // 每除一次就示处理后一个数位（从小到大）
        // i记录当前处理的是第几个数位
        for(int i=0;num!=0;num /=10,i++){
            //如果不为0，说明这个数位上有值，要进行相加操作
            if(num % 10 != 0){
                //拼接结果
                result = base[i][num % 10 -1]+result;
            }
        }
        return result;
    }
}
