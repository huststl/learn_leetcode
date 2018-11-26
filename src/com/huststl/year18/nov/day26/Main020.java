package com.huststl.year18.nov.day26;

import java.util.Stack;

//leetcode 20 难度 （easy)
public class Main020 {

    public boolean isValid(String str){
        Stack<Integer> stack = new Stack<>();

        char in[] = str.toCharArray();

        for(char c : in){
            if(c == '(')
                stack.push(0);
            else if(c=='[')
                stack.push(1);
            else if(c=='{')
                stack.push(2);
            else if (stack.isEmpty())
                return false;
            else if (c==')' && stack.pop()!=0)
                return false;
            else if (c==']'&& stack.pop()!=1)
                return false;
            else if(c=='}' && stack.pop()!=2)
                return false;
        }
        return stack.isEmpty();
    }
}
