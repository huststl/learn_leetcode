package com.huststl.year18.nov.day14;



public class Main002 {


    public class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int x){
            val = x;
        }
    }



    //递归思路
    public ListNode addTwoNumbers1(ListNode l1,ListNode l2){

        if( l1 == null || l2==null){

            return l1 == null ? l2:l1;
        }

        int value = l1.val + l2.val;

        ListNode result = new ListNode(value % 10);

        result.next = addTwoNumbers1(l1.next,l2.next);

        if(value >= 10) {

            result.next = addTwoNumbers1(new ListNode(value / 10),result.next);
        }
        return result;

    }

    //解题2

    public ListNode addTwoNumber2(ListNode l1,ListNode l2){

        ListNode dummy = new ListNode(-1);

        ListNode cur = dummy;

        int carry = 0;

        while (l1 != null && l2 !=null){

            int d1 = l1 == null ?0:l1.val;

            int d2 = l2 == null ?0:l2.val;

            int sum = d1 + d2 + carry;

            carry = sum >=10 ? 1: 0;
            cur.next = new ListNode(sum%10);
            cur = cur.next;

            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }

        if(carry == 1)
            cur.next = new ListNode(1);
        return  dummy.next;
    }
}
