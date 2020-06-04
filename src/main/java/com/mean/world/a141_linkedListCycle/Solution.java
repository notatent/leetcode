package com.mean.world.a141_linkedListCycle;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean hasCycle(ListNode head) {
        return hashTableCheck(head);
    }

    private boolean twoPointer(ListNode head) {
        return false;
    }

    /**
     * use hashmap
     * runtime 19.47%, memory 5.71%
     * <p>
     * use hashset
     * runtime 6.01%, memory 5.71%
     * <p>
     * hashmap get method O(1) faster than hashset contains method O(N) ???
     */
    private boolean hashTableCheck(ListNode head) {
        if (head == null) return false;
        Map<ListNode, ListNode> nodes = new HashMap<>();
        //Set<ListNode> nodes = new HashSet<>();
        ListNode current = head;
        while (current.next != null) {
            if (nodes.get(current.next) != null) {
                //if(nodes.contains(current.next)){
                return true;
            }
            nodes.put(current, current);
            //nodes.add(current);
            current = current.next;
        }
        return false;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
