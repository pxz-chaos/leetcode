package com.peixin.data.swordoffer.day02;

import java.util.Stack;

public class _6_从尾到头打印链表 {
    private Stack<Integer> stack;

    //采用辅助栈
    public _6_从尾到头打印链表() {
        this.stack = new Stack<>();
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];


        ListNode cur = head;
        while (cur != null) {

            stack.push(cur.val);
            cur = cur.next;

        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
