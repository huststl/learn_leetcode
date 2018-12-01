package com.huststl.year18.dec.day01;

//leetcode 27 删除数组中指定的元素 难度（easy)
public class Main027 {

    public int removeElement(int[] nums,int val){

        int i=0;
        int j=0; //J用来记录非value的位置
        /**
         * 从左边开始遍历数组，当前元素如果等于value（即nums[i]==value），则继续执行，
         * 反之，若为非value，则将此时 i 位置对应的值复制到 j 位置上。
         *
         */
        for(i=0;i<nums.length;i++){
            if(nums[i] == val){
                continue;
            }else {
                nums[j] = nums[i];//将i位置对应的值复制到j位置上
                j++;
            }
        }
        return j;

    }
}
