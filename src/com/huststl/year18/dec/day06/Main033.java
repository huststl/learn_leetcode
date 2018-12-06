package com.huststl.year18.dec.day06;

//leetcode 33 搜索旋转排序数组 难度(hard)
public class Main033 {

    public int search(int[] nums,int target){
        if(nums == null || nums.length < 1)
            return -1;

        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }

            //条件1
            if(nums[mid] >= nums[left]){
                if(target <nums[mid] && target >= nums[left]){
                    right = mid -1 ;
                }else {
                    left = mid +1;
                }
            }

            //条件2
            if(nums[mid] <= nums[right]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid +1;
                }else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
