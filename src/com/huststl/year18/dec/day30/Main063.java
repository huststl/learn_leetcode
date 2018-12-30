package com.huststl.year18.dec.day30;

//leetcode 063  Unique PathII 难度（medium)
public class Main063 {
    public int uniquePathsWithObstacles(int[][] abstacleGrid){
        int[][] ways = new int[abstacleGrid.length][abstacleGrid[0].length];

        int i=0,j=0;
        for(i=0;i<abstacleGrid.length;i++){
            for(j=0;j<abstacleGrid[0].length;j++){
                if(abstacleGrid[i][j] ==1){
                    ways[i][j] =0;
                }else if(i==0 && j==0){
                    ways[i][j] = 1;
                }else if(i==0 && j>0){
                    ways[i][j] = ways[i][j-1];
                }else if(j==0 && i>0){
                    ways[i][j] = ways[i-1][j];
                }else {
                    ways[i][j] = ways[i-1][j]+ways[i][j-1];
                }
            }
        }
        return ways[i-1][j-1];
    }
}
