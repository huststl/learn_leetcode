package com.huststl.year18.nov.day18;


//反转整数  难度（easy)

public class Main007 {

    //解法1
    public int reverse01(int x){

        int result = 0;
        while (x!=0){

            int num = x%10;
            int res = result * 10 + num;
            if((res-num)/10 !=result)
                return 0;

            result = res;

            x= x/10;
        }
        return result;
    }

    //解法2
    public int reverse02(int x){

        int y = 0;
        int n;//接受余数
        while (x!=0){
            n = x%10;
            if(y>Integer.MAX_VALUE/10 || y<Integer.MIN_VALUE/10){
                return 10;
            }

            y = y*10+n;
            x/=10;
        }
        return y;
    }
}
