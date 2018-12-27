package com.huststl.year18.dec.day26;

//leetcode 059 Spiral Matrix II(螺旋矩阵 II) 难度（medium)
public class Main059 {
    //给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

    public int[][] generateMatrix(int n){
        if(n==0)
            return new int[0][0];
        if(n==1){
            int[][] n1 = new int[1][1];
            n1[0][0] = 1;
            return n1;
        }

        int maxtix[][] = new int[n][n];
        int i=0,j=0,wid=n,high = n,go =0,k=1;
        while (k<n*n){
            //对应左下右上四个方向
            switch (go){
                //对于横向，全部扫描获取
                case 0:
                    while (j<wid){
                        maxtix[i][j] = k;
                        k++;
                        j++;
                    }
                    j--;
                    i++;
                    go++;
                    break;
                case 1:
                    while (i<high-1){
                        maxtix[i][j] = k;
                        k++;
                        i++;
                    }
                    go++;
                    break;
                case 2:
                    while (j>=n-wid){
                        maxtix[i][j] = k;
                        k++;
                        j--;
                    }
                    j++;
                    i--;
                    go++;
                    high--;
                    break;

                case 3:
                    while (i>n-high){
                        maxtix[i][j] = k;
                        k++;
                        i--;
                    }
                    go = 0;
                    wid--;
                    break;
            }
        }
        return maxtix;
    }
}
