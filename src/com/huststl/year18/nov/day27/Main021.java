package com.huststl.year18.nov.day27;


//Merge Two Sorted Lists 混合插入有序链表 难度(easy)
public class Main021 {


    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    //解法1
    public ListNode mergeTwoLists01(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0);
        ListNode newList = head;

        if(l1 == null || l2 == null){
            //两者有为空的情况
            if(l1==null){
                return l2;
            }
            if(l2==null){
                return l1;
            }
        }

        while (l1!=null && l2!=null){ //二者都不为空
            if(l1.val <= l2.val){
                newList.next = l1;
                l1 = l1.next;
            }else {   //if(l1.val < l2.val)
                newList.next = l2;
                l2 = l2.next;
            }

            newList = newList.next;
        }

        while (l1!=null){
            newList.next = l1;
            l1 = l1.next;
            newList = newList.next;
        }

        while (l2!=null){
            newList.next = l2;
            l2 = l2.next;
            newList = newList.next;
        }

        return head.next;

    }

    //解法2
    public ListNode mergeTwoLists02(ListNode l1,ListNode l2){
        if(l1 == null)
            return l2;
        if(l2==null){
            return l1;

        }
        ListNode resultHead;
        if(l1.val < l2.val){
            resultHead = l1;
            resultHead.next = mergeTwoLists02(l1.next,l2);
        }else {
            resultHead = l2;
            resultHead.next = mergeTwoLists02(l1,l2.next);
        }
        return resultHead;
    }

    //解法3
    public ListNode mergeTwoLists03(ListNode l1,ListNode l2){
        if(l1 == null || (l2!=null && l1.val > l2.val)){
            ListNode t = l1;l1 = l2;l2 = t;
        }

        if(l1!=null) l1.next = mergeTwoLists03(l2.next,l2);

        return l1;
    }

}
