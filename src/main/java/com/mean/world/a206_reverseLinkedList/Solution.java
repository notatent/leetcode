package com.mean.world.a206_reverseLinkedList;

/**
 * Created by tent on 2020-06-02 14:13
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return iterative(head);
    }

    private ListNode iterative(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            // get next node
            ListNode tmpNext = curr.next;
            // revert current node's next pointer to pre
            curr.next = pre;
            // move pre and curr forward
            pre = curr;
            curr = tmpNext;
        }
        return pre;
    }

    private ListNode recursive(ListNode head) {
        // TODO
        return null;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
