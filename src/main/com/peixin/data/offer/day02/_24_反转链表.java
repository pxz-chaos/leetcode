package com.peixin.data.offer.day02;

public class _24_反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head, newHead = null, next = null;

        while (cur != null) {
            next = cur.next;//记录写一个节点
            cur.next = newHead;//让第一个节点断掉
            newHead = cur;//让断掉的cur成为头节点
            cur = next;//让cur后移

        }

        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
