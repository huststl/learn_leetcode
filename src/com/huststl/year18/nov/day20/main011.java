package com.huststl.year18.nov.day20;

//盛最多的水 难度（medium)
public class main011 {


    //解法1
    public int maxArea01(int[] height){
        int res = 0,i=0,j=height.length-1;

        while (i<j){
            res = Math.max(res,Math.min(height[i],height[j]));

            if(height[i] < height[j])
                ++i;
            else
                --j;
        }
        return res;
    }

    //解法2
    public int maxArea02(int[] height){
        int res = 0,i=0,j=height.length-1;
        while (i<j){
            int h = Math.min(height[i],height[j]);
            res = Math.max(res,h*(j-i));
            while (i<j && h==height[i])
                ++i;
            while (i<j && h==height[j])
                --j;
        }
        return res;
    }
}
