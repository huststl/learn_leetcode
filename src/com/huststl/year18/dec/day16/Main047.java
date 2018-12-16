package com.huststl.year18.dec.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode 047 Permutations II Java 难度（hard)
public class Main047 {

    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        //排序有利于判断重复值
        Arrays.sort(nums);
        //深度优先算法
        dfs(nums,used,list,res);
        return res;

    }

    private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        //如果结果长度和输入长度相等，则添加进结果集
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            //如果该元素已经被使用，则继续遍历
            if(used[i])
                continue;
            //从下一个重复值只有在前一个重复值被使用的情况才可以使用
            if(i>0 && nums[i-1] == nums[i] && !used[i-1])
                continue;

            used[i] = true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}
