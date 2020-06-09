package com.mean.world.a019_removeNthNodeFromEndOfList;


public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // return twice(head,n);
        return once(head,n);
    }
    //TODO optimize,
    // using sentinel node(head node)
    // length--
    private ListNode twice(ListNode head, int n){
        if(n <= 0) return head;
        int size = 0;
        int index = 0;
        int removeIndex = 0;
        ListNode curr = head;
        ListNode newHead = head;
        // get node's size
        while(curr != null){
            size++;
            curr = curr.next;
        }
        // remove Nth node
        removeIndex = size - n - 1;//NOTE: index start with ZERO, so have to minus 1
        // when remove first node
        if(removeIndex == -1){
            return head.next;
        }
        while(index != removeIndex){
            index++;
            head = head.next;
        }
        curr = head.next ;
        head.next = curr.next;
        return newHead;
    }

    //TODO optimize,
    // using sentinel
    // node move n+1 steps
    private ListNode once(ListNode head, int n){
        if(n <= 0) return head;
        ListNode faster = head;
        int index = 0;
        while(index != n){// not ==
            index++;
            faster = faster.next;
        }
        if(faster == null){
            return head.next;
        }
        ListNode newHead = head;
        while(faster.next != null){//
            faster = faster.next;
            head = head.next;
        }
        head.next = head.next.next;// remove Nth node
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
