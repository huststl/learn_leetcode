package com.huststl.year18.dec.day21;

import java.util.LinkedList;
import java.util.List;

//leetcode 52 八皇后问题2 难度（hard）
public class Main052 {

    public int solve(int n, int index, List<Integer> tmpList){
        if(n==index){
            return 1;
        }

        int count = 0;
        for(int col = 0;col<n;col++){
            int row = index;
            int rowList;
            for(rowList = 0;rowList<tmpList.size();rowList++){
                int rowrow = rowList;
                int colcol = tmpList.get(rowrow);

                //同一列
                if(col == colcol){
                    break;
                }
                //同一斜线
                if(Math.abs(rowrow-row) == Math.abs(colcol-col))
                    break;


            }

            if(rowList == tmpList.size()){
                tmpList.add(col);
                int val = solve(n,index+1,tmpList);
                tmpList.remove(tmpList.size()-1);
                if(val>0){
                    count +=val;
                }
            }
        }
        return count;
    }

    public int totalNQueens(int n){
        List<Integer> tmpList = new LinkedList<>();
        return solve(n,0,tmpList);
    }
}
