package com.huststl.year18.nov.day28;


import java.util.Comparator;
import java.util.PriorityQueue;

//Merge k Sorted Lists(java) 难度（hard)
public class Main023 {

    //解法1
    //    用heap来做，先把k个list的第一个元素放进heap，每次poll出一个后，
    //    放进poll出的那个的后一个，直到heap为空。时间复杂度O（mklogk），空间复杂度为O（k）

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists01(ListNode[] lists){
        if(lists == null || lists.length==0){
            return null;
        }
        if(lists.length == 1)
            return lists[0];

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(int i=0;i<lists.length;i++){
            if(lists[i] != null)
                queue.add(lists[i]);
        }

        ListNode dummy = new ListNode(-1),cur = dummy;

        while (!queue.isEmpty()){
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = temp;
            if(temp.next !=null)
                queue.add(temp.next);
        }

        return dummy.next;
    }


    //解法2
    //merge sort的想法，比解法一更优。每次都两两list merge，直到merge成一个list，
    // 时间复杂度O（(m/2)(k/2 + k/4 + k/8 + …)logk），还是O（kmlogk），
    // 但是比方法一有常数量上的优化。空间复杂度为O（1）.

    public ListNode mergeKLists02(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        int begin = 0,end = lists.length - 1;

        while (begin < end){
            int mid = (begin + end -1)/2;
            for(int i=0;i<=end;i++){
                lists[i] = merge2list(lists[i],lists[end-i]);
            }
            end = (begin+end)/2;
        }
        return lists[0];
    }

    public ListNode merge2list(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1),cur = dummy;

        while (l1 !=null && l2!=null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }

        if(l1!=null)
            cur.next = l1;
        if(l2!=null)
            cur.next = l2;

        return dummy.next;
    }


}
