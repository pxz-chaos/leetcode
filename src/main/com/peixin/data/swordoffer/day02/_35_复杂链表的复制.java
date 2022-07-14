package com.peixin.data.swordoffer.day02;

import java.util.HashMap;

/**
 * @author pxz_chaos
 */
@SuppressWarnings("ALL")
public class _35_复杂链表的复制 {
    @SuppressWarnings("MapOrSetKeyShouldOverrideHashCodeEquals")
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        @SuppressWarnings("MapOrSetKeyShouldOverrideHashCodeEquals")
        HashMap<Node, Node> map = new HashMap<>(10);
        Node cur = head;


        while (cur != null) {
            //noinspection MapOrSetKeyShouldOverrideHashCodeEquals
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
