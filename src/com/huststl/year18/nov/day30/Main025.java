package com.huststl.year18.nov.day30;



import java.util.Stack;

//Reverse Nodes in k-Group 难度 （hard)
public class Main025 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup01(ListNode head,int k){
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode temp = head;

        for(int i=0;i<k;i++){
            if(head !=null){
                st.push(head);
            }else {
                return temp;
            }

            head = head.next;
        }
        ListNode first = st.pop();
        ListNode res = first;

        for(int i=0;i<k-1;i++){
            first.next = st.pop();
            first = first.next;
        }

        first.next = reverseKGroup01(head,k);
        return res;

    }

    //解法2
    public ListNode reverseKGroup02(ListNode head,int k){

        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode res = root;
        ListNode temp = head;

        int i=0;
        while (temp != null){
            i++;
            temp = temp.next;
        }

        while (i >= k){
            for(int j=0;j<k-1;j++){
                ListNode node = root.next;
                root.next = head.next;
                head.next = root.next.next;
                root.next.next = node;
            }
            root = head;
            head = head.next;
            i -= k;
        }
        return res.next;
    }


}
