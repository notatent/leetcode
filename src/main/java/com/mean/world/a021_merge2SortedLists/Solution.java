package com.mean.world.a021_merge2SortedLists;

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
//        return loop(l1, l2);
        return reverse(l1, l2);
    }

    /**
     * comment out code performance bad
     */
    private ListNode loop(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //ArrayList<ListNode> allNodes = new ArrayList<>();
        //ListNode smaller = null;
        boolean has = true;
        ListNode current = new ListNode();
        ListNode sentinelNode = current;
        while (has) {
            if (l1.val <= l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
                if (l1 == null) {
                    current.next = l2;
                    l2 = null;
                }
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
                if (l2 == null) {
                    current.next = l1;
                    l1 = null;
                }
            }
            //allNodes.add(smaller);
            // same as l1 == null,
            // cause when one listnode is null another listnode is null at same time
            if (l2 == null) {
                has = false;
            }
        }
        // set each node from all nodes, and move current pointer to next pointer
        //for (ListNode node : allNodes) {
        //  current.next = node;
        // current = current.next;
        //}
        return sentinelNode.next;
    }

    private ListNode reverse(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode current = new ListNode();
        ListNode sentinelNode = current;
        if (l1.val <= l2.val) {
            current.next = l1;
            current = current.next;
            current.next = reverse(l1.next, l2);
        } else {
            current.next = l2;
            current = current.next;
            current.next = reverse(l1, l2.next);
        }
        System.out.println("======");
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
