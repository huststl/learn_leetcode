package com.huststl.year18.nov.day23;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode15 3Sum 难度（medium)
public class Main015 {

    //解法1
    public static List<List<Integer>> threeSum01(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> Is = new LinkedList<>();

        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                int l = i+1, r = nums.length-1,sum = 0-nums[i];

                while (l < r){
                    if(nums[l] + nums[r] == sum){
                        Is.add(Arrays.asList(nums[i],nums[l],nums[r]));

                        while (l < r && nums[l] == nums[l+1])
                            l++;
                        while (l < r && nums[r] == nums[r-1])
                            r--;
                        l++;
                        r--;
                    }else if(nums[l] + nums[r] < sum){
                        while (l < r && nums[l] == nums[l+1])
                            l++;
                        l++;
                    }else {
                        while (l < r && nums[r] == nums[r-1])
                            r--;
                        r--;
                    }
                }
            }
        }
        return Is;
    }
}
