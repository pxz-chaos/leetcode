package com.peixin.data.structure.day08;

/**
 * @ClassName _206_反转链表
 * @Author pxz_chaos
 * @Date 2022/7/18 19:39
 */
public class _206_反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode newHead = null, cur = head, next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }

        return newHead;
    }

    public class ListNode {
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
}
