package com.huststl.year18.nov.day29;

import com.huststl.year18.nov.day14.Main002;

//leetcode 24 两两交换相邻的节点 难度（medium)
public class Main024 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head){
        if(head == null)
            return null;


        //表头节点，默认链表中的数据都为正数
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode left = preHead;
        ListNode mid = head;

        if(head.next == null){
            return head;
        }

        ListNode right = head.next;

        while (mid !=null && mid.next !=null){

            mid.next = right.next;
            right.next = mid;
            left.next = right;

            left = mid;
            mid = left.next;

            if(mid!=null){
                right = mid.next;
            }
        }

        return preHead.next;
    }
}
