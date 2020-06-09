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

    /**
     * The recursive version is slightly trickier and the key is to work backwards.
     * Assume that the rest of the list had already been reversed, now how do I reverse the front part?
     * <p>
     * Let's assume the list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
     * Assume from node nk+1 to nm had been reversed and you are at node nk.
     * n1 → … → nk-1 → nk → nk+1 ← … ← nm
     * We want nk+1’s next node to point to nk.
     * So,
     * nk.next.next = nk;
     * <p>
     * Be very careful that n1's next must point to Ø.
     * If you forget about this, your linked list has a cycle in it.
     * This bug could be caught if you test your code with a linked list of size 2.
     */
    // TODO how to understand, refer reverse.md
    private ListNode recursive(ListNode head) {
        if (head.next == null) return head;
        ListNode last = recursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
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
