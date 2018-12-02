package com.huststl.year18.dec.day02;

//leetcode 029 两数相除(java) 难度（medium)
public class Main029 {

    //解法1
    public static int divide01(int dividend,int divisor){
        if(dividend == Integer.MIN_VALUE && divisor==-1){
            return Integer.MIN_VALUE;
        }
        if(dividend == 0){
            return 0;
        }

        int sign = ((dividend < 0)^(divisor<0))?-1:1;//异或确定最后的符号
        long x = (dividend<0)?-(long)dividend:(long)dividend;
        long y = (divisor<0)?-(long)divisor:(long)divisor;

        int result = 0;
        while (x>=y){
            long temp = y,mid =1;
            while (x>=(temp<<1)){
                mid <<=1;
                temp <<=1;
            }
            x-=temp;
            result +=mid;
        }

        return sign > 0 ? result:-result;
    }

    //解法2
    public int divide02(int dividend,int divisor){
        //判断最终结果的正负性
        boolean isPositive = true;
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){
            isPositive = false;
        }

        //判断结束后全部当作正数操作
        //使用long解决数值溢出情况
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        if(ldivisor == 0 || ldividend<ldivisor)
            return 0;

        long result = divide(ldividend,ldivisor);
        if(result > Integer.MAX_VALUE){
            return isPositive?Integer.MAX_VALUE :Integer.MIN_VALUE;
        }

        return (int)(isPositive?result : -result);

    }

    public long divide(long ldividend, long ldivisor) {
        if(ldividend < ldivisor)
            return 0;
        long sum = ldivisor;
        long result = 1;

        //二分法计算结果
        while (ldividend >= (sum+sum)){
            sum += sum;
            result += result;
        }

        return result +divide(ldividend-sum, ldivisor);
    }
}
