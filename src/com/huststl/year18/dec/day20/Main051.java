package com.huststl.year18.dec.day20;

import java.util.ArrayList;
import java.util.List;

//leetcode 51 八皇后问题 难度（hard)
public class Main051 {

    public List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queenList = new int[n];//第i个位置存放的数表示row行时，Q的列
        placeQueen(queenList,0,n,res);//第0行放Q
        return res;
    }

    private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        //如果已经填满，就生成结果
        if(row == n){
            ArrayList<String> list = new ArrayList<String>();
            for(int i=0;i<n;i++){
                String str = "";
                for(int col = 0;col<n;col++){
                    if(queenList[i] == col){
                        str += "Q";

                    }else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(list);
        }
        for(int col = 0;col<n;col++){//循环每一列
            if(isValid(queenList,row,col)){
                queenList[row] = col;
                placeQueen(queenList,row+1,n,res);
            }
        }
    }

    private boolean isValid(int[] queenList, int row, int col) {
        for(int i=0;i<row;i++){
            int pos = queenList[i];
            if(pos == col){ //和新加入的Q处于同一列
                return false;
            }

            if(pos+row -i == col){ //在新加入的Q的右对角线上
                return false;
            }
            if(pos-row+i == col){ //在新加入的Q的左对角线上
                return false;
            }
        }
        return true;
    }
}
