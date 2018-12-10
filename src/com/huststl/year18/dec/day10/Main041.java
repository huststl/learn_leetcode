package com.huststl.year18.dec.day10;


import java.util.Arrays;

//leetcode 41 缺失的第一个正数 Java(medium)
public class Main041 {

    public int firstMissingPositive(int[] nums){
        if(nums.length == 0)
            return 1;
        //排序
        Arrays.sort(nums);

        int k =1;
        for(int i=0;i<nums.length;i++){
            //去负
            if(nums[i] <= 0){
                continue;
            }
            //去重
            if( i > 0 && nums[i] == nums[i-1])
                continue;
            if(nums[i] !=k ){
                return k;
            }
            k++;
        }
        return nums[nums.length-1]+1;
    }
}
