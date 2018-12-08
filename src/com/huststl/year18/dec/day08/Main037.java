package com.huststl.year18.dec.day08;

//leetcode 037 解数独 难度（hard)
public class Main037 {

    public void solveSudoku(char[][] board){
        solve(board);
    }

    public boolean solve(char[][] board) {

        for(int row = 0;row<9;row++){
            for(int col = 0;col<9;col++){
                if(board[row][col] == '.'){
                    for(char i = '1';i<='9';i++){
                        board[row][col] = i;
                        if(isValid(board,row,col) && solve(board)){
                            return true;
                        }
                        
                        board[row][col] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col) {
        for(int i=0;i<9;i++){
            if(i!=col && board[row][i] == board[row][col]){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(i!= row && board[i][col] == board[row][col]){
                return false;
            }
        }

        int beginRow = 3 * (row/3);
        int beginCol = 3* (col/3);

        for(int i= beginRow;i<beginRow+3;i++){
            for(int j= beginCol;j<beginCol+3;j++){
                if(i!=row && j!=col && board[i][j] == board[row][col]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main037 sol = new Main037();
        char[][] nums = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        boolean result = sol.solve(nums);
        System.out.println(result);
        for(char[] ch:nums){
            for(char c:ch){
                System.out.print(String.valueOf(c)+" ");
            }
            System.out.println();
        }
    }
}
