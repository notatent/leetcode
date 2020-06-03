package com.mean.world.a141_linkedListCycle;

/**
 * Created by tent on 2020-06-03 14:51
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        return twoPointers(head);
    }

    private boolean twoPointers(ListNode head) {
        if (head == null) return false;
        ListNode faster = head.next;
        ListNode slower = head;
        while (faster != slower) {
            if (faster == null || faster.next == null) {
                return false;
            }
            faster = faster.next.next;
            slower = slower.next;
        }
        return true;
    }

    private boolean hashTable(ListNode head) {
        // TODO
        return false;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

