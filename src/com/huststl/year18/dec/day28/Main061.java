package com.huststl.year18.dec.day28;

//leetcode 061 Rotate List
public class Main061 {

    public ListNode rotateRight(ListNode head,int k){
        if(head == null || k==0){
            return head;
        }

        int cnt = 1;
        ListNode p2 = head;
        while (p2.next!=null){
            cnt++;
            p2 = p2.next;
        }

        k = k % cnt;

        ListNode pHead = head;
        ListNode p1 = head;
        for(int i=0;i<cnt-k-1;i++){
            p1 = p1.next;
        }

        p2.next = pHead;
        pHead = p1.next;
        p1.next = null;

        return pHead;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}