package com.huststl.year18.nov.day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//4Sum 结果是目标值的四个数字和
public class Main018 {

    public List<List<Integer>> fourSum(int[] nums,int target){

        List<List<Integer>> ret = new ArrayList<>();

        if(nums == null || nums.length <3 )
            return ret;

        int len = nums.length;

        Arrays.sort(nums);

        // 注意，对于 num[i]，寻找另外两个数时，只要从 i+1 开始找就可以了。
        // 这种写法，可以避免结果集中有重复，因为数组时排好序的，
        // 所以当一个数被放到结果集中的时候，其后面和它相等的直接被跳过。

        for(int i=0;i<len;i++){
            //避免重复！
            if( i> 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1;j<len;j++){

                if(j>i+1 && nums[j] == nums[j-1])
                    continue;
                //往后找，避免重复
                int begin = j+1;
                int end = len-1;

                while (begin < end){
                    int sum = nums[i] + nums[j] +nums[begin]+nums[end];
                    if(sum == target){

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[begin]);
                        list.add(nums[end]);
                        ret.add(list);
                        begin++;
                        end--;

                        //避免重复！！！
                        while (begin<end && nums[begin] == nums[begin-1])
                            begin++;
                        while (begin<end && nums[end] == nums[end+1])
                            end--;
                    }else if(sum > target){
                        end--;
                    }else {
                        begin++;
                    }
                }
            }
        }
        return ret;
    }
}
