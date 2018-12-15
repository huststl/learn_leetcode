package com.huststl.year18.dec.day15;

import java.util.ArrayList;
import java.util.List;

//leetcode 46 Permutations-全排列 难度（medium)
public class Main046 {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        dfs(res,nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int j) {

        if( j == nums.length){
            List<Integer> temp = new ArrayList<Integer>();
            for(int num : nums)
                temp.add(num);

            res.add(temp);
        }

        for(int i = j;i<nums.length;i++){
            swap(nums,i,j);
            dfs(res,nums,j+1);
            swap(nums,i,j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //解法2
    public List<List<Integer>> permute2(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length ==0 || nums == null)
            return res;
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        res.add(list);

        for(int i =1;i<nums.length;i++){
            int size = res.size();
            for(int j=0;j<size;j++){
                int size2 = res.get(0).size();

                for(int k=0;k<=size2;k++){
                    List<Integer> temp = new ArrayList<>(res.get(0));
                    temp.add(k,nums[i]);
                    res.add(temp);
                }
                res.remove(0);
            }
        }
        return res;

    }
}
