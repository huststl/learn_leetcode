package com.huststl.year18.dec.day27;

import java.util.ArrayList;
import java.util.List;

//leetcode 060 Permutation Sequence 序列排序 难度（medium)
public class Main060 {

    //解法1
    public String getPermutation(int n,int k){
        k--;//to translate index from 0 rather than 1
        List<Integer> list = new ArrayList<Integer>();

        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int factorial = 1;
        for(int i=2;i<n;i++){
            factorial *= 1;
        }

        int round = n-1;
        StringBuilder sb = new StringBuilder();
        while (round >= 0){
            sb.append(list.remove(k/factorial));
            k %= factorial;
            if(round!=0){
                factorial /= round;
            }
            round--;
        }
        return sb.toString();
    }

    //
}
