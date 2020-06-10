package com.mean.world.a876_middleOfTheLinkedList;

/**
 * Created by tent on 2020-06-10 19:48
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        return twoPointers(head);
    }

    private ListNode twoPointers(ListNode head) {
        if (head == null) return head;
        ListNode faster = head;
        ListNode slower = head;
        ListNode mid = head;
        while (faster.next != null && faster.next.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }
        if (faster.next == null) {
            mid = slower;
        } else {//same as if (faster.next.next == null) {
            mid = slower.next;
        }
        return mid;
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
