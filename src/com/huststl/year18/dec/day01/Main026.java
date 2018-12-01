package com.huststl.year18.dec.day01;

//leetcode 26 删除排序数组中的重复项 难度（easy)
public class Main026 {

    //解法1
    //计算思路，设置结果length，前一个的数值previous
    //从第二个数组中的数字开始，向最后一个循环
    //如果该数字与previous相同，啥也不干
    //如果不同，长度+1，previous变为当前的数字，数组中的计算的当前不重复的位置为该值。

    public int removeDuplicates01(int[] nums){
        int length = 1;
        if(nums.length == 0){
            return 0;
        }

        int previous = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] != previous){
                length++;
                previous = nums[i];
                nums[length-1] = previous;
            }
        }
        return length;
    }

    //解法2
    public int removeDuplicates(int[] nums){
        if(nums.length ==0)
            return 0;
        //判断无输入
        int number=0;//标记计数
        for(int i=0;i<nums.length;i++){
            if(nums[i] != nums[number]){
                number++;
                nums[number] = nums[i];
            }
        }
        number+=1;//标记+1即为数字个数
        return number;
    }
}
