package com.mean.world.a002_addTwoNumbers;

import java.util.StringJoiner;

/**
 * Created by tent on 2019-11-04 14:38
 */
public class NodeTest {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);

        Node tmp = node;
        tmp = node.next;
        System.out.println(tmp);
        tmp = tmp.next;
        System.out.println(tmp);
        tmp = tmp.next;
        System.out.println(tmp);
    }

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("next=" + next)
                    .toString();
        }
    }
}
