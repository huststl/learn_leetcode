package com.huststl.year18.dec.day14;

//leetcode 045 Jump Game 难度（hard)
public class Main045 {

    //解法1
    public int jump(int[] nums){
        if(nums.length <=1){
            return 0;
        }
        if(nums[0] == 0)
            return -1;

        //记录当前活动距离
        int reach = nums[0];
        int steps = 0,start = 0;

        for(;start < nums.length && start <= reach;){
            ++steps;
            if(reach >= nums.length-1){
                return steps;
            }

            //nextMax表示下一步能到达的最远距离
            int nextMax = 0;
            //在当前start和reach之间，找下一步能到达最远的距离的下标
            for(int i=start;i<=reach;++i){
                if((i+nums[i]) > nextMax){
                    nextMax = i+nums[i];
                    start = i;
                }
            }
            reach = nextMax;

        }
        return -1;
    }

    //解法2

    public int jump02(int[] nums){
        if(nums == null || nums.length ==0){
            return -1;
        }

        //cur是维护的当前能跳到的最大位置
        // 第step+1步，能到达的最远距离
        int cur = 0;
        //last是指之前的点能reach到得最远位置
        //已经可以到达最远距离
        int last = 0;
        int step = 0;
        for(int i=0;i<nums.length;i++){
            // 当i 大于之前点能碰到的最大位置时，就需要跳一步，
            // 并把last更新为cur.
            if(i > last){
                step++;
                last = cur;
            }
            //计算step+1的距离
            cur = Math.max(cur,nums[i] + i);
        }
        // 最后返回若是cur能到最后一个元素，就返回step,
        // 若是到不了，就说明根本走不到最后一步，返回-1.
        return cur < nums.length-1?-1:step;
    }
}
