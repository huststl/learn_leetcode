package com.huststl.year18.dec.day11;

import java.util.Stack;

//leetcode 042 接雨水 难度（hard)
public class Main042 {

    //解法1
    //使用堆栈，分别存储值和下标
    public int trap(int[] height){
        int length = height.length;

        if(length <=2 ){
            return 0;
        }

        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();

        s.push(0);
        index.push(1);

        int leftMost = 0;
        int result = 0;

        for(int i=0;i<length;i++){
            int currentVal = height[i];
            //如果当前值比最左值大，则说明形成了一个封闭的盛水区间
            if(currentVal >= leftMost){
                while (!s.isEmpty()){
                    result += (leftMost - s.pop()) * index.pop();
                }
                s.push(currentVal);
                index.push(1);
                leftMost = currentVal;

            }else {
                //如果当前值比最左值小，则说明该盛水区间仍然没到最右点
                int count = 1;
                //将所有比当前值小的区间填满，并将水平区间的个数插入栈中
                while (currentVal > s.peek()){
                    count += index.peek();
                    result += (currentVal - s.pop()) * index.pop();
                }
                s.push(currentVal);
                index.push(count);
            }
        }
        return result;
    }

    //解法2
    //双指针 不使用堆栈
    public int trap2(int[] height){
        int length = height.length;
        if(length<=2){
            return 0;
        }

        //获得可以盛水的区间
        int startIndex = 0;
        while (startIndex < length-1 && height[startIndex] <= height[startIndex+1]){
            startIndex++;
        }

        int result = 0;
        //这里思路类似于上一段代码，只是可以填水的区间将值改为填水后的值
        int index = startIndex;
        while (++index < length){
            int currentHeight = height[index];
            if(currentHeight > height[startIndex]){
                for(int i = index -1;i>startIndex;i--){
                    result += (height[startIndex] - height[i]);
                }
                startIndex = index;
            }else {
                for(int i=index;i>0 && height[i] >height[i-1];i--){
                    result += (height[i] - height[i-1]);
                    height[i-1] = height[i];
                }
            }
        }
        return result;

    }

    //动态编程，先遍历获得区间
    public int trap3(int[] height){
        int length = height.length;
        //leftMax数组
        int[] left = new int[length];
        //rigthMax数组
        int[] right = new int[length];

        int leftMax = 0;
        int rightMax = 0;

        for(int i=0;i<length;i++){
            leftMax = left[i] = Math.max(leftMax,height[i]);
            rightMax = right[length-i-1] = Math.max(rightMax,height[length-i-1]);
        }
        int result = 0;
        for(int j=0;j<length;j++){
            result += Math.min(left[j],right[j])-height[j];
        }
        return result;
    }


    //解法4 双指针进阶
    public int trap4(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int leftMax=0, rightMax=0;
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(height[left], leftMax);
                result += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(height[right], rightMax);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }



}
