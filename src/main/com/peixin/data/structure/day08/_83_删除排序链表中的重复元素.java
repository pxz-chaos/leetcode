package com.peixin.data.structure.day08;

import org.junit.Test;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回已排序的链表 。
 *
 * @ClassName _83_删除排序链表中的重复元素
 * @Author pxz_chaos
 * @Date 2022/7/18 19:56
 */
public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //head:1->1->1->3
        // 搞一个辅助节点 -1->1->1->1->3  让其串在head上
        ListNode helper = new ListNode(-1);
        helper.next = head;

        //当前节点
        ListNode cur = helper;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return helper.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1),
                node1 = new ListNode(1),
                node2 = new ListNode(1),
                node3 = new ListNode(2);


        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(head);
        System.out.println(deleteDuplicates(head));


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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
