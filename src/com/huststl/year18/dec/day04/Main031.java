package com.huststl.year18.dec.day04;

import java.util.Arrays;

//leetcode 31 下一个排列 难度（medium)
public class Main031 {

    //解法1
    public void nextPermutatio01(int[] nums){

        int pos1,pos2;

        for(pos1 = nums.length-1;pos1>0;pos1--){
            if(nums[pos1] > nums[pos1-1])
                break;
        }

        if(pos1 == 0){
            reverse(nums,0,nums.length-1);
        }else {
            for(pos2 = pos1;pos2<nums.length;pos2++){
                if(nums[pos1-1] >= nums[pos2])
                    break;
            }
            swap01(nums,pos1-1,pos2-1);

            reverse(nums,pos1,nums.length-1);
        }
    }

    private void reverse(int[] nums, int l, int r) {
        while (l< r){
            swap01(nums,l,r);
            l++;
            r--;
        }
    }

    public void swap01(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //解法2
    public void nextPermutation(int[] nums){
        int len = nums.length;
        if(len == 1 || len == 0){
            return;
        }
        int i = len -1;
        while (true){
            if(i != 0 && nums[i-1] >= nums[i]){
                i--;
            }else {
                int pos = i-1;
                if(i != 0){
                    for(int k=len-1;k>=i;k--){
                        if(nums[k] > nums[pos]){
                            swap02(nums,pos,k);
                            break;
                        }
                    }
                }
                Arrays.sort(nums,i,len);
                break;
            }
        }

        for(int k=0;k<len;i++){
            System.out.println(nums[k]);
        }
    }

    public void swap02(int[] nums,int pos,int k){
        int tmp = nums[pos];
        nums[pos] = nums[k];
        nums[k] = tmp;
    }

}
