package com.huststl.year18.dec.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leecode 39  Combination Sum 难度（medium)
public class Main039 {

    //解法1
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        getResult(candidates,target,0,result,new ArrayList<Integer>());
        return result;
    }

    private void getResult(int[] candidates, int target, int pos, List<List<Integer>> result, List<Integer> ans) {
        for(int i=pos;i<candidates.length;i++){
            if(target == candidates[i]){
                ans.add(candidates[i]);
                result.add(new ArrayList<Integer>(ans));
                ans.remove(ans.size()-1);
                return;
            }else if(target > candidates[i]){
                ans.add(candidates[i]);
                getResult(candidates,target-candidates[i],i,result,ans);
                ans.remove(ans.size()-1);
            }else {
                return;
            }
        }
    }
}
