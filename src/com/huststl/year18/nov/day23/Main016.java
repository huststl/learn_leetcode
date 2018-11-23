package com.huststl.year18.nov.day23;

import java.util.Arrays;

//3Sum Closest 难度（medium)
public class Main016 {

    public int threeSumClosest(int[] nums,int target){

        int diff = nums[0] + nums[1] + nums[2] - target;

        Arrays.sort(nums);

        for(int i=0;i< nums.length-2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1,right = nums.length-1;

            while (left < right){
                int sum = nums[i] +nums[left] + nums[right];

                diff = Math.abs(sum - target) < Math.abs(diff)?sum - target : diff;

                if(sum == target){
                    return sum;
                }else if(sum < target){
                    while (left < right && nums[left++] == nums[left]){

                    }
                }else {
                    while (left < right && nums[right--] == nums[right]){

                    }
                }
            }
        }
        return target + diff;
    }
}
