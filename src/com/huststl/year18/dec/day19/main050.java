package com.huststl.year18.dec.day19;

//leetcode 50 Pow(x,n) Java 难度（medium)
public class main050 {

    public double myPow(double x,int n){
        int sign = 1;
        if(n < 0){
            sign = -1;
            n = -n;
        }
        return sign < 0?1/pow(x,n):pow(x,n);
    }

    public double pow(double x,int n){
        if(n == 0)
            return 1;

        if(n == 1)
            return x;

        if(n % 2 == 0){
            double tmp = pow(x * x,n/2);
            return tmp;
        }else {
            double tmp = pow(x*x,n/2);
            return tmp * x;
        }
    }
}
