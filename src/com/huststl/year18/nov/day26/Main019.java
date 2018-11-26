package com.huststl.year18.nov.day26;

//leetcode 19 难度 （easy)

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class Main019 {

    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode p = head;
        ListNode q = head;

        //p先移动n个位置
        for(int i=0;i<n;i++){
            p = p.next;
        }

        if(p == null){
            head = head.next;
            return head;
        }

        //当p达到尾部
        while (p.next !=null){
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;

        return head;
    }
}
