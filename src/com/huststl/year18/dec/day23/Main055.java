package com.huststl.year18.dec.day23;

//leetcode 55 Jump Game 难度（medium)
public class Main055 {

    public boolean canJump(int[] nums){
        if(nums.length < 1)
            return false;

        if(nums.length == 1)
            return true;

        int max = 0; //记录到当前点时能达到的最大位置

        for(int i=0;i<nums.length-1;i++){
            max = Math.max(max,i+nums[i]);

            if(max < i+1){ //   如果到达不了后续点
                return false;
            }

            if(max >=(nums.length-1)){
                return true;
            }
        }
        return false;
    }
}
