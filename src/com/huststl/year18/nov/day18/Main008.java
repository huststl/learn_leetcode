package com.huststl.year18.nov.day18;

//字符串转整数 (atoi) 难度 easy

public class Main008 {

    public int myAtoi01(String str){

        boolean flag = false;
        boolean posi = true;

        long res = 0;

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(c>='0' && c<='9')
                res = res *10+(c-'0');
            else if (c == '-' && !flag)
                posi = false;
            else if (c == '+' && !flag)
                posi = true;
            else if(flag||!flag&&c!=' ')
                break;
            if(!flag && c!=' ')
                flag = true;
            if(res-1 > Integer.MIN_VALUE)
                break;
        }

        return posi?(int)Math.min(res,Integer.MAX_VALUE)
                :(int)Math.max(-1 *res,Integer.MIN_VALUE);
    }

    //解法2
    public int myAtoi02(String str) {

        if (str.isEmpty())
            return 0;
        int sign = 1, base = 0, i = 0, n = str.length();

        while (i < n && str.charAt(i) == ' ') ++i;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }

        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {

                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            }

            base = 10 * base + (str.charAt(i++) - '0');
        }

        return base * sign;
    }
}
