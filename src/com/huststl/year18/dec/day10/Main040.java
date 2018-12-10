package com.huststl.year18.dec.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode 40 组合总和II 难度 （medium)
public class Main040 {

    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target < 0)
            return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);//排序，使得寻找相同出权值的节点变得容易
        get(candidates,target,0,list,res);
        return res;

    }

    private void get(int[] candidates, int target, int i, List<Integer> list, List<List<Integer>> res) {
        if( i > candidates.length || target < 0)
            return;//因为没有自环，所以每次都是从下一个节点开始搜索，要添加一个条件判断节点仍在图中
        if(target == 0){
            //满足条件，添加至结果集
            res.add(new ArrayList<>(list));
            return;
        }

        for(int p = i;p<candidates.length;p++){
            list.add(candidates[p]);//添加节点到路径
            get(candidates,target-candidates[p],p+1,list,res);
            list.remove(list.size()-1);
            while (p < candidates.length-1 && candidates[p] == candidates[p+1])
                p++;//因为存在重复节点，所以已经被剔除的节点不能再被放回到路径中

        }
    }


}
