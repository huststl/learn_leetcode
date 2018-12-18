package com.huststl.year18.dec.day17;

//leetcode 048 旋转图像 难度（medium)
public class Main048 {
//    你有一个n*n 的2D矩阵表示一个图像。
//
//    将图像旋转90度（顺时针）。
//
//    注意:
//
//    你必须在原地旋转图像，这意味着你必须直接修改输入2D矩阵。不要分配另一个2D矩阵并进行旋转。




    public void rotate(int[][] matrix){
        int n = matrix.length;
        if(n<=1){
            return;
        }

        int x = (n-1)/2;
        //先上下对称交换
        for(int i=0;i<=x;i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[i-1];
            matrix[i-1] = tmp;
        }
        //主对角线对称交换

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
