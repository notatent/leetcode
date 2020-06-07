package com.mean.world.a021_merge2SortedLists;

import java.util.ArrayList;

class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(6))));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(11)))));
        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return loop4Collection(l1, l2);
    }

    private ListNode loop4Collection(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ArrayList<ListNode> allNodes = new ArrayList<>();
        ListNode smaller = null;
        boolean has = true;
        ListNode current = new ListNode();
        ListNode sentinelNode = current;
        while (has) {
            if (l1.val <= l2.val) {
                smaller = l1;
                l1 = l1.next;
                if (l1 == null) {
                    smaller.next = l2;
                    l2 = null;
                }
            } else {
                smaller = l2;
                l2 = l2.next;
                if (l2 == null) {
                    smaller.next = l1;
                    l1 = null;
                }
            }
            allNodes.add(smaller);
            // same as l1 == null, cause when one listnode is null another listnode is null at same time
            if (l2 == null) {
                has = false;
            }
        }
        // set each node from all nodes, and move current pointer to next pointer
        for (ListNode node : allNodes) {
            current.next = node;
            current = current.next;
        }
        return sentinelNode.next;
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
