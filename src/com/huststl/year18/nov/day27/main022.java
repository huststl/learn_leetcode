package com.huststl.year18.nov.day27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Generate Parentheses 生成括号 难度（easy)
public class main022 {

    //解法1
    public List<String> generateParenthesis01(int n){
        List<String> res = new ArrayList<String>();
        helper(n,n,"",res);
        return res;
    }

    public void helper(int left, int right, String out, List<String> res) {

        if(left < 0 || right < 0 || left > right){
            return;
        }
        if(left == 0 && right == 0){
            res.add(out);
            return;
        }
        helper(left-1,right,out + "(",res);
        helper(left,right-1,out + ")",res);

    }

    //解法2
    public List<String> generateParenthesis02(int n){
        Set<String> res = new HashSet<String>();
        if(n == 0){
            res.add("");
        }else {
            List<String> pre = generateParenthesis02(n-1);
            for(String str:pre){
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i) == '('){
                        str = str.substring(0,i+1)+"()"+
                                str.substring(i+1,str.length());

                        res.add(str);
                        str = str.substring(0,i+1)+
                                str.substring(i+3,str.length());
                    }
                }
                res.add("()"+str);
            }
        }
        return new ArrayList<>(res);

    }
}
