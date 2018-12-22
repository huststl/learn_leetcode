package com.huststl.year18.dec.day22;

//leetcode 53 和最大的子序列 难度（medium)
public class Main053 {

    //给定一个整数数组nums，找到相邻的子数组（至少包含一个数字），它的总和是最大的，并返回它的和。

    //解法1 暴力法 O（n^2)

    public int maxSubArray(int[] nums){
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                max = sum > max ? sum:max;
            }
        }
        return max;
    }

    //解法2 动态规划法 O（n)

    public int maxSubarray2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    //解法3
    public int maxSubarray3(int[] nums){
        int max = nums[0];
        int mem = max;
        for(int i=1;i<nums.length;i++){
            mem = Math.max(mem + nums[i],nums[i]);
            max = Math.max(mem,max);
        }
        return max;
    }

}
