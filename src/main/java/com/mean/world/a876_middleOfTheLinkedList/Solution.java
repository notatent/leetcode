package com.mean.world.a876_middleOfTheLinkedList;

/**
 * Created by tent on 2020-06-10 19:48
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5/*, new ListNode(6)*/)))));
        Solution solution = new Solution();
        ListNode listNode = solution.middleNode(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode middleNode(ListNode head) {
        //return usingArray(head);
        return optimize2Pointers(head);
        //return twoPointers(head);
    }

    /**
     * time complexity O(N)
     * space complexity O(N)
     */
    private ListNode usingArray(ListNode head) {
        // return array[array.length/2]
        return null;
    }

    private ListNode optimize2Pointers(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * time complexity O(N)
     * space complexity O(1)
     */
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
